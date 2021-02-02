package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.common.beans.text.Text;
import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.server.service.command.util.TextUtils;

import java.util.Comparator;
import java.util.stream.Collectors;

import static by.ralovets.epamcourse.server.service.command.util.TextUtils.getWords;

public class Task07 implements Command {

    @Override
    public String execute(Text text, Object additional) {

        return getWords(text).stream()
                .distinct()
                .sorted(Comparator.comparingDouble(TextUtils::getVowelsPercent))
                .collect(Collectors.toList()).toString();
    }
}
