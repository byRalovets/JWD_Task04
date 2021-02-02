package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.common.beans.text.Text;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.impl.Word;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static by.ralovets.epamcourse.server.service.command.util.TextUtils.*;

public class Task06 implements Command {

    @Override
    public String execute(Text text, Object additional) {

        List<String> sortedWords = getWords(text).stream()
                .distinct()
                .map(Objects::toString)
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        StringBuilder builder = new StringBuilder();

        char currentChar = 0;
        for (String s : sortedWords) {
            if (currentChar != s.charAt(0)) {
                currentChar = s.charAt(0);
                builder.append("\n\t");
            }

            builder.append(s).append("; ");
        }

        return builder.toString();
    }
}
