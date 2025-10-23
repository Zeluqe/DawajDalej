public class Skrzynka3 extends Skrzynka {

    public Skrzynka3() {
        super("Skrzynka Legendarna", 200.0);
        inicjalizujNagrody();
    }

    @Override
    protected void inicjalizujNagrody() {
        // Rare (45% szans) - waga 45
        dostepneNagrody.add(new Nagroda("Diamentowa Tarcza", "Rare", 220.0, 45));
        dostepneNagrody.add(new Nagroda("Mithrylowy Hełm", "Rare", 250.0, 45));

        // Epic (40% szans) - waga 40
        dostepneNagrody.add(new Nagroda("Smocza Zbroja", "Epic", 400.0, 40));
        dostepneNagrody.add(new Nagroda("Lodowy Miecz", "Epic", 450.0, 40));
        dostepneNagrody.add(new Nagroda("Magiczna Księga", "Epic", 380.0, 40));

        // Legendary (15% szans) - waga 15
        dostepneNagrody.add(new Nagroda("Excalibur", "Legendary", 1000.0, 15));
    }
}
