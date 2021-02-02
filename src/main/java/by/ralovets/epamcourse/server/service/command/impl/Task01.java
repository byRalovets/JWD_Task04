package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.common.beans.text.Text;
import by.ralovets.epamcourse.server.service.command.Command;
import org.apache.log4j.Logger;

import static by.ralovets.epamcourse.server.service.command.util.TextUtils.*;

public class Task01 implements Command {

    private final static Logger log = Logger.getLogger(Task01.class);

    @Override
    public String execute(Text text, Object additional) {

        return getUniqueWords(getWords(text)).stream()
                .map(w -> sentencesContainsWordCount(getSentences(text), w))
                .max(Long::compareTo)
                .orElse(0L)
                .toString();
    }
}
