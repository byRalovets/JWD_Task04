package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.impl.Word;
import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.common.beans.text.Text;

import java.util.stream.Collectors;

import static by.ralovets.epamcourse.server.service.command.util.TextUtils.*;

public class Task12 implements Command {

    @Override
    public String execute(Text text, Object additional) {
        int len = (Integer) additional;

        return getWords(text).stream()
                .peek((w) -> {
                    String wordContent = w.getContent();
                    if (wordContent.length() == len && startsWithConsonant(w)) {
                        w.setContent("");
                    }
                })
                .map(Word::getContent)
                .collect(Collectors.joining("; "));
    }
}
