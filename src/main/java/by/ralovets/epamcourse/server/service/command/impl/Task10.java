package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.impl.Word;
import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.common.beans.text.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static by.ralovets.epamcourse.server.service.command.util.TextUtils.*;

public class Task10 implements Command {

    @Override
    public String execute(Text text, Object additional) {
        List<String> words = (List<String>) additional;

//        HashMap<String, Integer> wordsMap = new HashMap<>();
//        List<String> wordsFromText = getWords(text);
//        for (String word : words) {
//            wordsMap.put(word, getWordCount(word, wordsFromText));
//        }

        StringBuilder wordsBuilder = new StringBuilder();
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, 1);
        }
        for (Word word : getWords(text)) {
            Integer numberOfWords = wordMap.get(word.getContent());
            if (numberOfWords != null) {
                wordMap.put(word.getContent(), numberOfWords + 1);
            }
        }
        List<Map.Entry<String, Integer>> sortedList = wordMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());

        for (Map.Entry<String, Integer> m : sortedList) {
            wordsBuilder.append(m.getKey()).append(" ");
        }
        return wordsBuilder.toString();
    }
}
