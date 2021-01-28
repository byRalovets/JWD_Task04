package by.ralovets.epamcourse.server.service.command;

import by.ralovets.epamcourse.common.CommandIdentifier;
import by.ralovets.epamcourse.server.service.command.impl.*;

import java.util.HashMap;

public class CommandProvider {

    private static final CommandProvider instance = new CommandProvider();

    public static CommandProvider getInstance() {
        return instance;
    }

    private final HashMap<String, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put(CommandIdentifier.TASK01, new Task01());
        commands.put(CommandIdentifier.TASK02, new Task02());
        commands.put(CommandIdentifier.TASK03, new Task03());
        commands.put(CommandIdentifier.TASK04, new Task04());
        commands.put(CommandIdentifier.TASK05, new Task05());
        commands.put(CommandIdentifier.TASK06, new Task06());
        commands.put(CommandIdentifier.TASK07, new Task07());
        commands.put(CommandIdentifier.TASK08, new Task08());
        commands.put(CommandIdentifier.TASK09, new Task09());
        commands.put(CommandIdentifier.TASK10, new Task10());
        commands.put(CommandIdentifier.TASK11, new Task11());
        commands.put(CommandIdentifier.TASK12, new Task12());
        commands.put(CommandIdentifier.TASK13, new Task13());
        commands.put(CommandIdentifier.TASK14, new Task14());
        commands.put(CommandIdentifier.TASK15, new Task15());
        commands.put(CommandIdentifier.TASK16, new Task16());
    }

    public Command getCommand(String commandId) {
        return commands.get(commandId);
    }
}
