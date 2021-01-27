package by.ralovets.epamcourse.server.service.command;

import by.ralovets.epamcourse.common.beans.CommandIdentificator;
import by.ralovets.epamcourse.server.service.command.impl.*;

import java.util.HashMap;

public class CommandProvider {

    private final HashMap<Integer, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put(1, new Task01());
        commands.put(2, new Task02());
        commands.put(3, new Task03());
        commands.put(4, new Task04());
        commands.put(5, new Task05());
        commands.put(6, new Task06());
        commands.put(7, new Task07());
        commands.put(8, new Task08());
        commands.put(9, new Task09());
        commands.put(10, new Task10());
        commands.put(11, new Task11());
        commands.put(12, new Task12());
        commands.put(13, new Task13());
        commands.put(14, new Task14());
        commands.put(15, new Task15());
        commands.put(16, new Task16());
    }

    public Command getCommand(CommandIdentificator c) {
        return commands.get(c);
    }
}
