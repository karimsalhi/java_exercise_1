import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Launcher {
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
            else
                System.out.println("Unknown command");
        }
    }
}
