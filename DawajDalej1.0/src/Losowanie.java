public class Losowanie {

    public static void animacjaOtwierania() {
        System.out.println("\nOtwieranie skrzynki");
        try {
            for(int i = 0; i < 3; i++) {
                Thread.sleep(500);
                System.out.print(".");
            }
            System.out.println();
        } catch(InterruptedException e) {
        }
    }
}
