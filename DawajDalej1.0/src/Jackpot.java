import java.util.Random;

public class Jackpot {

    private Random random;
    private static final int SZANSA_NA_JACKPOT = 5; /* Oceń czy 5% jest git - wystarczająco, jak tak to zostaw*/

    public Jackpot() {
        this.random = new Random();
    }

    public boolean czyWygraJackpot() {
        int los = random.nextInt(100) + 1;
        return los <= SZANSA_NA_JACKPOT;
    }

    public double losujWartoscJackpota() {
        return 100 + random.nextInt(401) /* max +500 ale nie zawsze bo to by za dobre było ale i tak mało % jest więc spokojnie*. Chociaż dostanie 100 to też słabo ale no zawsze coś*/;
    }

    public double uruchomJackpot() {
        System.out.println("\n*** JACKPOT! ***");
        System.out.println("Losowanie wartości jackpota");

        try {
            for(int i = 0; i < 3; i++) {
                Thread.sleep(500);
                System.out.print(".");
            }
            System.out.println();
        } catch(InterruptedException e) {
            /* ignorancja, zignorować, ingoruj, zignorowałem */
        }

        double wygrana = losujWartoscJackpota();
        System.out.println("ALEŻ TRAFIENIE! NIESAMOWITE!!!");
        System.out.println("Wygrałeś JACKPOT o wartości: " + wygrana + " zł!");

        return wygrana;
    }
}
