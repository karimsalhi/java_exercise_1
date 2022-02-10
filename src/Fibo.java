import java.util.Locale;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Fibo implements Command {
    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Entrez un nombre:");
        String msg = scanner.nextLine();
        int n = parseInt(msg);
        int i;
        int f1 = 0;
        int f2 = 1;
        int res = 0;

        if (n == 0)
            System.out.println(0);
        if (n == 1)
            System.out.println(1);

        for (i = 2; i <= n; i++)
        {
            res = f1 + f2;
            f1 = f2;
            f2 = res;
        }
        System.out.println(res);

        return false;
    }
}
