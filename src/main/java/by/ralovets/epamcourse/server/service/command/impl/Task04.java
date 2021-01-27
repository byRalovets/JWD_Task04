package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.common.beans.text.Text;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.Sentence;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.impl.PunctuationMark;

import java.util.List;
import java.util.stream.Collectors;

import static by.ralovets.epamcourse.server.service.command.util.TextUtils.*;

public class Task04 implements Command {

    @Override
    public String execute(Text text, Object additional) {
        int length = 5; // ToDo: len is a fun arg

        final PunctuationMark questionMark = new PunctuationMark();
        questionMark.setValue("?");

        List<Sentence> questionSentences = getSentences(text).stream()
                .filter(s -> s.getElements().get(s.getElements().size() - 1).equals(questionMark))
                .collect(Collectors.toList());

        return getWords(questionSentences).stream()
                .filter(w -> w.getContent().length() == length)
                .distinct()
                .collect(Collectors.toList()).toString();
    }
}
