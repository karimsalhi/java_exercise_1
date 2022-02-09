import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Launcher {
    public static boolean openFile(Path path) {
        try {
            String file = java.nio.file.Files.readString(path);
            return true;
        } catch (Exception e) {
            System.out.println("Unreadable file: " + e);
            return false;
        }
    }

    public static int fibo(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        while(true) {
            Scanner scan = new Scanner(System.in);

            String res = scan.nextLine();

            if (res.equals("quit"))
                break;
            else if (res.equals("fibo")) {
                System.out.println("Entrez un nombre:");
                res = scan.nextLine();
                int resFibo = fibo(parseInt(res));
                System.out.println(resFibo);
            }
            else if (res.equals("freq")) {
                System.out.println("Entrez le chemin vers un fichier:");
                res = scan.nextLine();
                boolean fileOpened = openFile(Path.of(res));
                System.out.println(fileOpened);
            }
            else
                System.out.println("Unknown command");
        }
    }
}
