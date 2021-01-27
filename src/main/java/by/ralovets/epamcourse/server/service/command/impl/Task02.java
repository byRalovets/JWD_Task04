package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.common.beans.text.Text;

import java.util.stream.Collectors;

import static by.ralovets.epamcourse.server.service.command.util.TextUtils.getSentences;
import static by.ralovets.epamcourse.server.service.command.util.TextUtils.getWordsCount;

public class Task02 implements Command {

    @Override
    public String execute(Text text, Object additional) {
        return getSentences(text).stream()
                .sorted((a, b) -> {
                    int aWordsCount = getWordsCount(a);
                    int bWordsCount = getWordsCount(b);

                    if (aWordsCount > bWordsCount) {
                        return 1;
                    } else if (aWordsCount == bWordsCount) {
                        return 0;
                    }
                    return -1;
                })
                .collect(Collectors.toList()).toString();
    }
}
