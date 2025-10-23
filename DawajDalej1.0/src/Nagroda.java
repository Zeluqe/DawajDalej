public class Nagroda {

    //pola prywatne
    private String nazwa;
    private String rzadkosc;
    private double wartosc;
    private int waga;

    //konstruktor
    public Nagroda(String nazwa, String rzadkosc, double wartosc, int waga) {
        this.nazwa = nazwa;
        this.rzadkosc = rzadkosc;
        this.wartosc = wartosc;
        this.waga = waga;
    }

    // gettery
    public String getNazwa() {
        return nazwa;
    }

    public String getRzadkosc() {
        return rzadkosc;
    }

    public double getWartosc() {
        return wartosc;
    }

    public int getWaga() {
        return waga;
    }

    // settery
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setRzadkosc(String rzadkosc) {
        this.rzadkosc = rzadkosc;
    }

    public void setWartosc(double wartosc) {
        this.wartosc = wartosc;
    }

    public void setWaga(int waga) {
        this.waga = waga;
    }

    //wyświetlanie informacji o nagrodzie
    public void wyswietlInfo() {
        System.out.println("Nazwa: " + nazwa);
        System.out.println("Rzadkość: " + rzadkosc);
        System.out.println("Wartość: " + wartosc + " zł");
    }

    @Override
    public String toString() {
        return nazwa + " [" + rzadkosc + "] - " + wartosc + " zł";
    }
}
