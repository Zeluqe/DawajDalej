import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

    private Scanner scanner;
    private boolean dziala;
    private Gracz gracz;
    private ArrayList<Skrzynka> dostepneSkrzynki;
    private Ryzyko ryzyko;
    private Jackpot jackpot;

    public Menu(Gracz gracz, Scanner scanner) {
        this.gracz = gracz;
        this.scanner = scanner;
        this.dziala = true;
        this.dostepneSkrzynki = new ArrayList<Skrzynka>();
        this.ryzyko = new Ryzyko();
        this.jackpot = new Jackpot();
        inicjalizujSkrzynki();
    }

    private void inicjalizujSkrzynki() {
        dostepneSkrzynki.add(new Skrzynka1());
        dostepneSkrzynki.add(new Skrzynka2());
        dostepneSkrzynki.add(new Skrzynka3());
    }

    public void uruchom() {
        while(dziala) {
            wyswietlMenu();
            int wybor = pobierzWybor();
            obsluzWybor(wybor);
        }
    }

    private void wyswietlMenu() {
        System.out.println("\n==== MENU ====");
        System.out.println("#" + gracz.getNick() + " | " + gracz.getSaldo() + " zł");
        System.out.println("1. Otwórz skrzynkę");
        System.out.println("2. Zobacz ekwipunek");
        System.out.println("3. Sklep");
        System.out.println("4. Zaryzykuj");
        System.out.println("5. Statystyki");
        System.out.println("6. Wyjście");
        System.out.print("Wybierz (1-6): ");
    }

    private int pobierzWybor() {
        int wybor = -1;
        try {
            wybor = scanner.nextInt();
            scanner.nextLine();
        } catch(Exception e) {
            System.out.println("Eeee, wygląda na to, że podałeś coś innego niż liczba z przedziału od 1 do 6. Spróbuj ponownie!");
            scanner.nextLine();
        }
        return wybor;
    }

    private void obsluzWybor(int wybor) {
        switch(wybor) {
            case 1:
                opcjaOtworzSkrzynke();
                break;
            case 2:
                opcjaEkwipunek();
                break;
            case 3:
                menuSklepu();
                break;
            case 4:
                opcjaRyzyko();
                break;
            case 5:
                opcjaStatystyki();
                break;
            case 6:
                System.out.println("Do zobaczenia, " + gracz.getNick() + "!");
                dziala = false;
                break;
            default:
                System.out.println("Koleżko, możesz tylko wybrać liczbę z przedziału od 1 do 6!!");
                break;
        }
    }

    private void opcjaOtworzSkrzynke() {
        System.out.println("\n=== OTWIERANIE SKRZYNKI ===");

        System.out.println("Wybierz typ skrzynki do otwarcia:");
        for(int i = 0; i < dostepneSkrzynki.size(); i++) {
            Skrzynka s = dostepneSkrzynki.get(i);
            System.out.println((i+1) + ". " + s.getNazwa() + " (" + s.getCena() + " zł)");
        }
        System.out.println((dostepneSkrzynki.size() + 1) + ". Powrót");
        System.out.print("Twój wybór: ");

        int wybor = pobierzWybor();

        if(wybor == dostepneSkrzynki.size() + 1) {
            System.out.println("Powrót do menu...");
            return;
        }

        int indeks = wybor - 1;
        if(indeks >= 0 && indeks < dostepneSkrzynki.size()) {
            Skrzynka wybranaSkrzynka = dostepneSkrzynki.get(indeks);

            if(gracz.getSaldo() < wybranaSkrzynka.getCena()) {
                System.out.println("Uuu Bida! Nie posiadasz tyle pieniążków aby to zakupić");
                System.out.println("Potrzebujesz mieć: " + wybranaSkrzynka.getCena() + " zł");
                System.out.println("A ty tylko masz: " + gracz.getSaldo() + " zł");
                czekajNaEnter();
                return;
            }

            gracz.odejmijPieniadze(wybranaSkrzynka.getCena());
            Losowanie.animacjaOtwierania();
            Nagroda nagroda = wybranaSkrzynka.otworz();

            gracz.dodajPrzedmiot(nagroda);
            gracz.zwiekszLicznikSkrzynek();

            System.out.println("Otrzymałeś - " + nagroda.getNazwa());
            System.out.println("Rzadkość przedmiotu: " + nagroda.getRzadkosc());
            System.out.println("wartość przedmiotu: " + nagroda.getWartosc() + " zł");
            System.out.println("\nPrzedmiot został już dodany do twojego ekwipunku! \nTeraz śmiało możesz go sprzedać albo zachować do kolekcji.");
            System.out.println("Stan Portfela po zakupie: " + gracz.getSaldo() + " zł");

            //szansa na jackpocik
            if(jackpot.czyWygraJackpot()) {
                double wygranaJackpot = jackpot.uruchomJackpot();
                gracz.dodajPieniadze(wygranaJackpot);
                System.out.println("Nowe saldo po jackpocie: " + gracz.getSaldo() + " zł");
            }

        } else {
            System.out.println("Coś nie tak wpisałeś!");
        }

        czekajNaEnter();
    }

    private void opcjaEkwipunek() {
        gracz.wyswietlEkwipunek();
        czekajNaEnter();
    }

    private void opcjaStatystyki() {
        gracz.wyswietlInfo();
        czekajNaEnter();
    }

    private void opcjaRyzyko() {
        System.out.println("\n=== GRA RYZYKO ===");
        ryzyko.wyswietlZasady();

        System.out.println("\nTwoje saldo: " + gracz.getSaldo() + " zł");
        System.out.print("Ile chcesz postawić? (0 = wyjście): ");

        int stawka = pobierzWybor();

        if(stawka == 0) {
            System.out.println("Wracamy do menu...");
            return;
        }

        if(stawka > gracz.getSaldo()) {
            System.out.println("Nie masz tyle pieniędzy!");
            czekajNaEnter();
            return;
        }

        if(stawka < 1) {
            System.out.println("Stawka musi być większa niż 0!");
            czekajNaEnter();
            return;
        }

        // odejmujemy stawkę
        gracz.odejmijPieniadze(stawka);

        // gramy
        boolean wygrana = ryzyko.zagrajZAnimacja(stawka);

        if(wygrana) {
            gracz.dodajPieniadze(stawka * 2);
        }

        System.out.println("\nAktualne saldo: " + gracz.getSaldo() + " zł");
        czekajNaEnter();
    }

    private void menuSklepu() {
        System.out.println("\n==== SKLEP ====");
        System.out.println("Portfel: " + gracz.getSaldo() + " zł");
        System.out.println("1. Kup skrzynkę");
        System.out.println("2. Sprzedaj przedmiot");
        System.out.println("3. Zobacz dostępne skrzynki");
        System.out.println("4. Powrót");
        System.out.print("Twój wybór: ");

        int wybor = pobierzWybor();

        switch(wybor) {
            case 1:
                opcjaKupSkrzynke();
                break;
            case 2:
                opcjaSprzedaj();
                break;
            case 3:
                opcjaPokazSkrzynki();
                break;
            case 4:
                System.out.println("Wracamy do menu! -.-.-.-");
                break;
            default:
                System.out.println("Koleżko, możesz tylko wybrać liczbę z przedziału od 1 do 4!!");
                break;
        }
    }

    private void opcjaKupSkrzynke() {
        System.out.println("\nSkrzynki możesz zakupić tylko w opcji 1 w menu!");
        System.out.println("Oto lista skrzynek możliwych do zakupu:");
        for(Skrzynka s : dostepneSkrzynki) {
            System.out.println("- " + s.getNazwa() + ": " + s.getCena() + " zł");
        }
        czekajNaEnter();
    }

    private void opcjaPokazSkrzynki() {
        System.out.println("\n==== DOSTĘPNE SKRZYNKI ====");
        for(int i = 0; i < dostepneSkrzynki.size(); i++) {
            Skrzynka s = dostepneSkrzynki.get(i);
            s.wyswietlZawartosc();
            System.out.println();
        }
        czekajNaEnter();
    }

    private void opcjaSprzedaj() {
        if(gracz.getEkwipunek().isEmpty()) {
            System.out.println("Niestety ale twój ekwipaż świeci pustkami, zakup skrzynkę aby nie był taki!");
            czekajNaEnter();
            return;
        }

        gracz.wyswietlEkwipunek();
        System.out.print("\nKtóry przedmiot pragniesz sprzedać? (0 = anuluj): ");

        int wybor = pobierzWybor();

        if(wybor == 0) {
            System.out.println("Sprzedaż pomyślnie anulowano!");
            czekajNaEnter();
            return;
        }

        int indeks = wybor - 1;
        if(indeks >= 0 && indeks < gracz.getEkwipunek().size()) {
            Nagroda nagroda = gracz.getEkwipunek().get(indeks);
            double cena = nagroda.getWartosc();

            gracz.dodajPieniadze(cena);
            gracz.usunPrzedmiot(indeks);

            System.out.println("Sprzedałeś: " + nagroda.getNazwa() + " za jedyne " + cena + " zł");
            System.out.println("Stan Portfela po sprzedaży: " + gracz.getSaldo() + " zł");
        } else {
            System.out.println("Koleżko, nieprawidłowa liczbe wpisałeś!");
        }
        czekajNaEnter();
    }

    private void czekajNaEnter() {
        System.out.println("\nAby kontynuować wciśnij ENTER");
        scanner.nextLine();
    }
}
