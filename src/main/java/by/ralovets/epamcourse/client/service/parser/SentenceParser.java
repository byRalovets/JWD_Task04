package by.ralovets.epamcourse.client.service.parser;

import by.ralovets.epamcourse.client.service.parser.util.Patterns;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.Sentence;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.SentenceElement;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.impl.PunctuationMark;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.impl.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser {

    private SentenceParser() {
    }

    public static Sentence parseSentence(String sourceText) {
        Sentence sentence = new Sentence();
        List<SentenceElement> sentenceElements = new ArrayList<>();

        for (String s : splitIntoSentenceElements(sourceText)) {
            if (Patterns.getInstance().getPunctuationMarkPattern().matcher(s).matches()) {
                sentenceElements.add(new PunctuationMark(s));
            } else {
                sentenceElements.add(new Word(s));
            }
        }

        sentence.setElements(sentenceElements);
        return sentence;
    }

    private static List<String> splitIntoSentenceElements(String s) {
        Matcher matcher = Patterns.getInstance().getSentenceElementPattern().matcher(s);

        Pattern p = Pattern.compile("([,;:«»()?!.-])|([^\\s,;:«»()?!.-]*)");
        matcher = p.matcher(s);

        List<String> sentenceElements = new ArrayList<>();
        while (matcher.find()) {
            String sentenceElement = matcher.group();

            if (!sentenceElement.isBlank()) {
                sentenceElements.add(sentenceElement);
            }
        }

        return sentenceElements;
    }
}
