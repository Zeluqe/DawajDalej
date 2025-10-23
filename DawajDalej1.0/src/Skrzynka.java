import java.util.ArrayList;
import java.util.Random;

public abstract class Skrzynka implements interfejs_skrzynki {

    protected String nazwa;
    protected double cena;
    protected ArrayList<Nagroda> dostepneNagrody;
    protected Random random;

    public Skrzynka(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.dostepneNagrody = new ArrayList<Nagroda>();
        this.random = new Random();
    }

    protected abstract void inicjalizujNagrody();

    @Override
    public Nagroda otworz() {
        if(dostepneNagrody.isEmpty()) {
            inicjalizujNagrody();
        }
        return losujNagrode();
    }

    // losowanie nagrody z wagami
    protected Nagroda losujNagrode() {
        int totalWeight = 0;
        for(Nagroda n : dostepneNagrody) {
            totalWeight += n.getWaga();
        }

        int randomNum = random.nextInt(totalWeight) + 1;
        int currentWeight = 0;

        for(Nagroda n : dostepneNagrody) {
            currentWeight += n.getWaga();
            if(randomNum <= currentWeight) {
                return n;
            }
        }

        return dostepneNagrody.get(0);
    }

    @Override
    public void wyswietlZawartosc() {
        System.out.println("\n=== " + nazwa + " ===");
        System.out.println("Cena: " + cena + " zł");
        System.out.println("Możliwe nagrody:");

        for(Nagroda n : dostepneNagrody) {
            String szansa = obliczSzanse(n);
            System.out.println("- " + n.getNazwa() + " [" + n.getRzadkosc() +
                    "] (" + szansa + "%) - Wartość: " + n.getWartosc() + " zł");
        }
    }

    private String obliczSzanse(Nagroda nagroda) {
        int totalWeight = 0;
        for(Nagroda n : dostepneNagrody) {
            totalWeight += n.getWaga();
        }

        double szansa = (double) nagroda.getWaga() / totalWeight * 100;
        return String.format("%.2f", szansa);
    }

    @Override
    public double getCena() {
        return cena;
    }

    @Override
    public String getNazwa() {
        return nazwa;
    }
}
