package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.common.beans.text.Text;
import by.ralovets.epamcourse.server.service.command.util.TextUtils;

import java.util.Comparator;
import java.util.stream.Collectors;

import static by.ralovets.epamcourse.server.service.command.util.TextUtils.getWords;

public class Task13 implements Command {

    @Override
    public String execute(Text text, Object additional) {
        char c = (Character) additional;

        return getWords(text).stream()
                .distinct()
                .sorted((a, b) -> {
                    int aEntries = TextUtils.getCharacterCount(a, c);
                    int bEntries = TextUtils.getCharacterCount(b, c);

                    if (aEntries == bEntries) {
                        return CharSequence.compare(a.getContent(), b.getContent());
                    } else {
                        return aEntries - bEntries;
                    }
                })
                .collect(Collectors.toList()).toString();
    }
}
