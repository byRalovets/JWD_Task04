package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.common.beans.text.Text;

import java.util.stream.Collectors;

import static by.ralovets.epamcourse.server.service.command.util.TextUtils.*;

public class Task07 implements Command {

    @Override
    public String execute(Text text, Object additional) {
        return getWords(text).stream()
                .distinct()
                .sorted((w1, w2) -> {
                    double w1VowelsPercent = getVowelsPercent(w1);
                    double w2VowelsPercent = getVowelsPercent(w2);

                    if (w1VowelsPercent > w2VowelsPercent) {
                        return 1;
                    } else if (w1VowelsPercent == w2VowelsPercent) {
                        return 0;
                    }
                    return -1;
                })
                .collect(Collectors.toList()).toString();
    }
}
