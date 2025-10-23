import java.util.Random;

public class Ryzyko {

    private Random random;

    public Ryzyko() {
        this.random = new Random();
    }

    public boolean zagraj(double stawka) {
        int szansa = random.nextInt(100) + 1;
        return szansa > 50;
    }

    // metoda z animacją żeby ładnie było
    public boolean zagrajZAnimacja(double stawka) {
        System.out.println("\nLosowanie");
        try {
            for(int i = 0; i < 3; i++) {
                Thread.sleep(400);
                System.out.print(".");
            }
            System.out.println();
        } catch(InterruptedException e) {
            /* ignorancja, zignorować, ingoruj, zignorowałem - dodaj więcej synonimów - omijanie, wymijanie, zlekceważenie, nieuwzględnianie(nie ma za co) */
        }

        boolean wygrana = zagraj(stawka);

        if(wygrana) {
            System.out.println("*** WYGRANA! ***");
            System.out.println("Gratulacje! Podwoiłeś swoją stawkę!");
            System.out.println("Wygrałeś: " + (stawka * 2) + " zł");
        } else {
            System.out.println("*** PRZEGRANA ***");
            System.out.println("Niestety, straciłeś całą stawkę...");
            System.out.println("Strata: " + stawka + " zł");
        }

        return wygrana;
    }

    public void wyswietlZasady() {
        System.out.println("\n=== ZASADY GRY RYZYKO ===");
        System.out.println("- Wybierz stawkę którą chcesz zaryzykować");
        System.out.println("- Masz 50% szans na wygraną - to jak rzut monetą!");
        System.out.println("- Jeśli wygrasz - PODWAJASZ stawkę!");
        System.out.println("- Jeśli przegrasz - TRACISZ całą stawkę!");
        System.out.println("- Ryzykuj tylko wtedy gdy możesz stracić!");
    }
}
