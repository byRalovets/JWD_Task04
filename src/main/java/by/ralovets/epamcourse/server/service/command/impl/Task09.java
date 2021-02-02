package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.common.beans.text.Text;

import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

import static by.ralovets.epamcourse.server.service.command.util.TextUtils.*;

public class Task09 implements Command {

    @Override
    public String execute(Text text, Object additional) {
        char c = (Character) additional;

        return getWords(text).stream()
                .sorted(Comparator.comparingInt(w -> getCharacterCount(w, c)))
                .map(Objects::toString)
                .collect(Collectors.joining("; "));
    }
}
