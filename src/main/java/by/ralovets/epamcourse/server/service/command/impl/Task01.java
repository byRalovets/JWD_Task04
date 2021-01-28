package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.common.beans.text.Text;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.impl.Word;
import org.apache.log4j.Logger;

import java.util.List;

import static by.ralovets.epamcourse.server.service.command.util.TextUtils.*;

public class Task01 implements Command {

    private final static Logger log = Logger.getLogger(Task01.class);

    @Override
    public String execute(Text text, Object additional) {
        log.trace("Server: Task01 was started");
        List<Word> uniqueWords = getUniqueWords(getWords(text));

        log.trace("Server: Calculating maxMatches count");
        long maxMatches = 0;
        for (Word word : uniqueWords) {
            long matches = sentencesContainsWordCount(getSentences(text), word);
            if (matches > maxMatches) {
                maxMatches = matches;
            }
        }

        log.trace("Server: Returning maxMatches count");
        return maxMatches + "";
//        return "10";
    }
}
