import java.util.ArrayList;

public class Gracz {
    private String nick;
    private double saldo;
    private ArrayList<Nagroda> ekwipunek;
    private int otwartychSkrzynek;

    // tworzenie nowego gracza
    public Gracz(String nick) {
        this.nick = nick;
        this.saldo = 100.0; // startowe pieniądze
        this.ekwipunek = new ArrayList<Nagroda>();
        this.otwartychSkrzynek = 0;
    }

    //pobieranie danych
    public String getNick() {
        return nick;
    }

    public double getSaldo() {
        return saldo;
    }

    public ArrayList<Nagroda> getEkwipunek() {
        return ekwipunek;
    }

    public int getOtwartychSkrzynek() {
        return otwartychSkrzynek;
    }

    //ustawienie  danych
    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void dodajPieniadze(double kwota) {
        this.saldo += kwota;
    }

    public boolean odejmijPieniadze(double kwota) {
        if(saldo >= kwota) {
            saldo -= kwota;
            return true;
        }
        return false;
    }

    //przedmiot do eq
    public void dodajPrzedmiot(Nagroda nagroda) {
        ekwipunek.add(nagroda);
    }

    // przedmiot z eq
    public void usunPrzedmiot(int indeks) {
        if(indeks >= 0 && indeks < ekwipunek.size()) {
            ekwipunek.remove(indeks);
        }
    }

    //licznik otwarrtych skrzynek
    public void zwiekszLicznikSkrzynek() {
        otwartychSkrzynek++;
    }

    // informacje o użytkowniku
    public void wyswietlInfo() {
        System.out.println("\n=== INFORMACJE O GRACZU ===");
        System.out.println("Nick: " + nick);
        System.out.println("Saldo: " + saldo + " zł");
        System.out.println("Przedmiotów w ekwipunku: " + ekwipunek.size());
        System.out.println("Otwartych skrzynek: " + otwartychSkrzynek);
    }

    //wyświetlanie eq
    public void wyswietlEkwipunek() {
        System.out.println("\n=== EKWIPUNEK ===");

        if(ekwipunek.isEmpty()) {
            System.out.println("Ekwipunek jest pusty!");
            return;
        }

        for(int i = 0; i < ekwipunek.size(); i++) {
            Nagroda n = ekwipunek.get(i);
            System.out.println((i+1) + ". " + n.getNazwa() +
                    " (Wartość: " + n.getWartosc() + " zł)");
        }
    }
}
