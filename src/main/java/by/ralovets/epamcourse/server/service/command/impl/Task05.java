package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.common.beans.text.Text;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.Sentence;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.impl.Word;

import java.util.List;

import static by.ralovets.epamcourse.server.service.command.util.TextUtils.*;

public class Task05 implements Command {

    @Override
    public String execute(Text text, Object additional) {
        List<Word> words;
        Word w1, w2;
        for (Sentence sentence : getSentences(text)) {
            words = getWords(sentence);

            if (words.size() > 1) {
                w1 = words.get(0);
                w2 = words.get(words.size() - 1);

                words.remove(0);
                words.add(0, w2);
                words.add(w1);
            }
        }
        return text.toString();
    }
}
