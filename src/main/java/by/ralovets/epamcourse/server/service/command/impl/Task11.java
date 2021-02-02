package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.Sentence;
import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.common.beans.text.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static by.ralovets.epamcourse.server.service.command.util.TextUtils.*;

public class Task11 implements Command {

    @Override
    public String execute(Text text, Object additional) {
        HashMap<String, Character> paramsMap = (HashMap<String, Character>) additional;
        char begin = paramsMap.get("start");
        char end = paramsMap.get("end");

        List<Sentence> sentences = getSentences(text);
        List<String> result = new ArrayList<>();

        for (Sentence sentence : sentences) {
            String sent = sentence.toString();
            int b = sent.indexOf(begin);
            int e = sent.lastIndexOf(end);
            if (e != -1 && b != -1) {
                result.add(sent.substring(0, b) + sent.substring(e));
            } else {
                result.add(sent);
            }
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (String s : result) {
            resultBuilder.append(s);
            resultBuilder.append(System.lineSeparator());
        }

        return resultBuilder.toString();
    }
}
