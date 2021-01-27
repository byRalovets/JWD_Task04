package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.common.beans.text.Text;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.impl.Word;

import java.util.List;

import static by.ralovets.epamcourse.server.service.command.util.TextUtils.*;

public class Task01 implements Command {

    @Override
    public String execute(Text text, Object additional) {
        List<Word> uniqueWords = getUniqueWords(getWords(text));

        long maxMatches = 0;
        for (Word word : uniqueWords) {
            long matches = sentencesContainsWordCount(getSentences(text), word);
            if (matches > maxMatches) {
                maxMatches = matches;
            }
        }

        return maxMatches + "";
    }
}
