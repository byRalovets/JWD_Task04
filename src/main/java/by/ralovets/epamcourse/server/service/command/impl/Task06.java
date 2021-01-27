package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.common.beans.text.Text;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.impl.Word;

import java.util.List;
import java.util.stream.Collectors;

import static by.ralovets.epamcourse.server.service.command.util.TextUtils.*;

public class Task06 implements Command {

    @Override
    public String execute(Text text, Object additional) {
        List<Word> words = getWords(text).stream()
                .sorted((w1, w2) -> {
                    char c1 = getFirstChar(w1);
                    char c2 = getFirstChar(w2);

                    if (c1 > c2) {
                        return 1;
                    } else if (c1 == c2) {
                        return 0;
                    }
                    return -1;
                })
                .distinct()
                .collect(Collectors.toList());

        StringBuilder builder = new StringBuilder();

        char currentChar = 0;
        for (Word word : words) {
            if (currentChar != getFirstChar(word)) {
                currentChar = getFirstChar(word);
                builder.append("\n\t");
            }

            builder.append(word).append("; ");
        }

        return builder.toString();
    }
}
