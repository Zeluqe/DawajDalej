public class Skrzynka2 extends Skrzynka {

    public Skrzynka2() {
        super("Skrzynka Srebrna", 100.0);
        inicjalizujNagrody();
    }

    @Override
    protected void inicjalizujNagrody() {
        // Uncommon (50% szans) - waga 50
        dostepneNagrody.add(new Nagroda("Stalowy Miecz", "Uncommon", 90.0, 50));
        dostepneNagrody.add(new Nagroda("Kolczuga", "Uncommon", 100.0, 50));
        dostepneNagrody.add(new Nagroda("Kuszę", "Uncommon", 110.0, 50));

        // Rare (35% szans) - waga 35
        dostepneNagrody.add(new Nagroda("Złoty Naszyjnik", "Rare", 180.0, 35));
        dostepneNagrody.add(new Nagroda("Runiczny Miecz", "Rare", 200.0, 35));

        // Epic (15% szans) - waga 15
        dostepneNagrody.add(new Nagroda("Płonący Topór", "Epic", 350.0, 15));
    }
}
