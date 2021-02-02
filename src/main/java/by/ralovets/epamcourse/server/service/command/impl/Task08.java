package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.common.beans.text.Text;
import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.server.service.command.util.TextUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

import static by.ralovets.epamcourse.server.service.command.util.TextUtils.*;

public class Task08 implements Command {

    @Override
    public String execute(Text text, Object additional) {
        return getWords(text).stream()
                .distinct()
                .filter(w -> Arrays.binarySearch(VOWEL_LETTERS, getFirstChar(w)) < 0)
                .sorted(Comparator.comparingInt(TextUtils::getFirstChar))
                .map(Objects::toString)
                .collect(Collectors.joining("; "));
    }
}
