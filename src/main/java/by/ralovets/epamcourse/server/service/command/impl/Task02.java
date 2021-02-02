package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.common.beans.text.Text;
import by.ralovets.epamcourse.server.service.command.util.TextUtils;

import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

import static by.ralovets.epamcourse.server.service.command.util.TextUtils.getSentences;

public class Task02 implements Command {

    @Override
    public String execute(Text text, Object additional) {
        return getSentences(text).stream()
                .sorted(Comparator.comparingInt(TextUtils::getWordsCount))
                .map(Objects::toString)
                .collect(Collectors.joining());
    }
}
