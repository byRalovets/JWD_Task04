package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.common.beans.text.Text;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.Sentence;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.impl.Word;
import by.ralovets.epamcourse.server.service.command.Command;

import java.util.List;

import static by.ralovets.epamcourse.server.service.command.util.TextUtils.getSentences;
import static by.ralovets.epamcourse.server.service.command.util.TextUtils.getWords;

public class Task05 implements Command {

    @Override
    public String execute(Text text, Object additional) {
        List<Word> words;

        for (Sentence sentence : getSentences(text)) {
            words = getWords(sentence);

            if (words.size() > 1) {
                Word tempWord = words.get(0);
                words.set(0, words.get(words.size() - 1));
                words.set(words.size() - 1, tempWord);
            }
        }

        return text.toString();
    }
}
