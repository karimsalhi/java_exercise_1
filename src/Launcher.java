import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class Launcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Fibo fibo = new Fibo();
        Quit quit = new Quit();
        Freq freq = new Freq();
        Predict predict = new Predict();
        List<Command> commands = new ArrayList<>();
        commands.add(fibo);
        commands.add(quit);
        commands.add(freq);
        commands.add(predict);

        boolean stop = false;
        boolean runned = false;
        do {
            String msg = scanner.nextLine();
            runned = false;
            for (Command command : commands) {
                if (command.name().equals(msg)) {
                    stop = command.run(scanner);
                    runned = true;
                    break;
                }
            }
            if (!runned)
                System.out.println("Unknown Command");
        } while (!stop);
    }
}
