import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class Launcher {
    public static void handleFreq(Path path) {
        /*try {
            String file = java.nio.file.Files.readString(path);
            return true;
        } catch (Exception e) {
            System.out.println("Unreadable file: " + e);
            return false;
        }*/

        try {
            String content = java.nio.file.Files.readString(path);
            content = content.toLowerCase(Locale.ROOT);
            String[] words = content.split(" ");
            List<String> list = Arrays.asList(words);
            Map<Object, Integer> frequencyMap = list.stream()
                    .collect(toMap(
                            s -> s, // key is the word
                            s -> 1, // value is 1
                            Integer::sum));
            List<Object> res = list.stream()
                    .sorted(comparing(frequencyMap::get).reversed()) // sort by descending frequency
                    .distinct() // take only unique values
                    .limit(3)   // take only the first 10
                    .collect(toList()); // put it in a returned list
            for(int i = 0; i < 3; i++)
            {
                if (i != 2)
                    System.out.print(res.get(i)+" ");
                else
                    System.out.print(res.get(i));
            }
            System.out.println();

        } catch (Exception e) {
            System.out.println("Unreadable file: " + e.toString());
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
                Path path = Paths.get(res);
                handleFreq(path);
            }
            else
                System.out.println("Unknown command");
        }
    }
}
