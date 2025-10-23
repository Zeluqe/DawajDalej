public class Skrzynka1 extends Skrzynka {

    public Skrzynka1() {
        super("Skrzynka Podstawowa", 50.0);
        inicjalizujNagrody();
    }

    @Override
    protected void inicjalizujNagrody() {
        dostepneNagrody.add(new Nagroda("Stary Miecz", "Common", 30.0, 60));
        dostepneNagrody.add(new Nagroda("Drewniana Tarcza", "Common", 25.0, 60));
        dostepneNagrody.add(new Nagroda("Skórzana Zbroja", "Common", 35.0, 60));

        dostepneNagrody.add(new Nagroda("Srebrny Pierścień", "Uncommon", 70.0, 30));
        dostepneNagrody.add(new Nagroda("Żelazny Hełm" /* item -w nazwa*/, "Uncommon" /* rzadkość*/, 80.0 /* wartość */, 30 /* % szanse */));

        dostepneNagrody.add(new Nagroda("Magiczny Amulet", "Rare", 150.0, 10));
    }
}
