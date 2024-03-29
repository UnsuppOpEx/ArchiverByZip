package archiver;

import archiver.command.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Обработчик команд
 */
public class CommandExecutor {

    private final static Map<Operation, Command> allKnownCommandsMap;

    static
            {
                allKnownCommandsMap = new HashMap<>();
                allKnownCommandsMap.put(Operation.CREATE, new ZipCreateCommand());
                allKnownCommandsMap.put(Operation.ADD, new ZipAddCommand());
                allKnownCommandsMap.put(Operation.REMOVE, new ZipRemoveCommand());
                allKnownCommandsMap.put(Operation.EXTRACT, new ZipExtractCommand());
                allKnownCommandsMap.put(Operation.CONTENT, new ZipContentCommand());
                allKnownCommandsMap.put(Operation.EXIT, new ExitCommand());
            }

    private CommandExecutor() {
        throw new AssertionError();
    }

    public static void execute(Operation operation) throws Exception {
        allKnownCommandsMap.get(operation).execute();
        }
    }

