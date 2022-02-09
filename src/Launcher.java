import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String res = scan.nextLine();

        if (res.equals("quit"))
            return;
        else
            System.out.println("Unknown command");
    }
}
