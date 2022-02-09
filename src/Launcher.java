import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        while(true) {
            Scanner scan = new Scanner(System.in);

            String res = scan.nextLine();

            if (res.equals("quit"))
                break;
            else
                System.out.println("Unknown command");
        }
    }
}
