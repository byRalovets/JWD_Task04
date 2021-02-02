package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.Sentence;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.SentenceElement;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.impl.Word;
import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.common.beans.text.Text;
import by.ralovets.epamcourse.server.service.command.util.TextUtils;

import java.util.HashMap;
import java.util.List;

public class Task16 implements Command {

    @Override
    public String execute(Text text, Object additional)  {
        HashMap<String, Object> params = (HashMap<String, Object>) additional;

        String substring = (String) params.get("str");
        int wordLen = (Integer) params.get("len");

        List<Sentence> sentences = TextUtils.getSentences(text);

        if (sentences.size() > 0) {
            for (SentenceElement e : sentences.get(0).getElements()) {
                if (e instanceof Word && ((Word) e).getContent().length() == wordLen) {
                    ((Word) e).setContent(substring);
                }
            }

            return sentences.get(0).toString();
        }

        return null;
    }
}
