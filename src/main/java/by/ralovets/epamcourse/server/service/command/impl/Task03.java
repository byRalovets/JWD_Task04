package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.common.beans.text.Text;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.Sentence;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.impl.Word;

import java.util.List;

import static by.ralovets.epamcourse.server.service.command.util.TextUtils.*;

public class Task03 implements Command {

    @Override
    public String execute(Text text, Object additional) {
        List<Sentence> sentences = getSentences(text);

        if (sentences.size() < 2) return null;

        Sentence firstSentence = sentences.get(0);
        sentences = sentences.subList(1, sentences.size());

        for (Word word : getWords(firstSentence)) {
            // ToDo: Fix
            if (!sentences.contains(word)) return word.toString();
        }

        return "";
    }
}
