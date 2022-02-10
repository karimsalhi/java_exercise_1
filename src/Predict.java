import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class Predict implements Command {
    @Override
    public String name() {
        return "predict";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Entrez le chemin vers un fichier:");
        String msg = scanner.nextLine();
        Path path = Paths.get(msg);

        try {
            String content = java.nio.file.Files.readString(path);
            System.out.println("Entrez un mot:");

            String str = scanner.nextLine();
            if (!content.contains(str)) {
                System.out.println("Le mot n'existe pas dans le fichier");
            }

        } catch (Exception e) {
            System.out.println("Unreadable file: " + e.toString());
        }

        return false;
    }
}
