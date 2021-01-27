package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.common.beans.text.Text;

import java.util.stream.Collectors;

import static by.ralovets.epamcourse.server.service.command.util.TextUtils.*;

public class Task09 implements Command {

    @Override
    public String execute(Text text, Object additional) {
        char c = ' '; // ToDo: Replace

        return getWords(text).stream()
                .sorted((w1, w2) -> {
                    int w1CharCount = getCharacterCount(w1, c);
                    int w2CharCount = getCharacterCount(w2, c);

                    if (w1CharCount > w2CharCount) {
                        return 1;
                    } else if (w1CharCount == w2CharCount) {
                        return 0;
                    }
                    return -1;
                })
                .collect(Collectors.toList()).toString();
    }
}
