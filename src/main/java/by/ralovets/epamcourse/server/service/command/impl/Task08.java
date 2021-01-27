package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.common.beans.text.Text;

import java.util.Arrays;
import java.util.stream.Collectors;

import static by.ralovets.epamcourse.server.service.command.util.TextUtils.*;

public class Task08 implements Command {

    @Override
    public String execute(Text text, Object additional) {
        return getWords(text).stream()
                .distinct()
                .filter(w -> Arrays.binarySearch(VOWEL_LETTERS, getFirstChar(w)) < 0)
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
                .collect(Collectors.toList()).toString();
    }
}
