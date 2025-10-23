import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("   Witaj w DawajDalej!    ");
        System.out.println("==========================");
        System.out.println();

        System.out.print("Podaj swój nick: ");
        String nick = scanner.nextLine();

        Gracz gracz = new Gracz(nick);

        System.out.println("\nWitaj, " + gracz.getNick() + "!");
        System.out.println("Widzę, że jesteś tutaj nowy! Na start swojej przygody otrzymujesz: " + gracz.getSaldo() + " zł");

        Menu menu = new Menu(gracz, scanner);
        menu.uruchom();

        scanner.close();
    }
}
