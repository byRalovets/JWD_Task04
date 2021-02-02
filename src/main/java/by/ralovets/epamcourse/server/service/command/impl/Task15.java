package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.common.beans.text.element.TextElement;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.Sentence;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.SentenceElement;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.impl.Word;
import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.common.beans.text.Text;
import by.ralovets.epamcourse.server.service.command.util.TextUtils;

public class Task15 implements Command {

    @Override
    public String execute(Text text, Object additional) {
        for (TextElement tElem : TextUtils.getSentences(text)) {
            if (tElem instanceof Sentence) {
                Sentence sentence = (Sentence) tElem;
                for (SentenceElement sElem : TextUtils.getWords(sentence)) {
                    if (sElem instanceof Word) {
                        Word word = (Word) sElem;
                        String string = word.getContent();

                        char firstChar = string.charAt(0);
                        string = string.replace(firstChar + "", "");
                        string = firstChar + string;

                        word.setContent(string);
                    }
                }
            }
        }
        return text.toString();
    }
}
