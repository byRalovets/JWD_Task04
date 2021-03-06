package by.ralovets.epamcourse.client.service.parser;

import by.ralovets.epamcourse.client.service.parser.util.Patterns;
import by.ralovets.epamcourse.common.beans.text.Text;
import by.ralovets.epamcourse.common.beans.text.element.TextElement;
import by.ralovets.epamcourse.common.beans.text.element.impl.code.BlockOfCode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    private TextParser() {
    }

    public static Text parseText(String sourceText) {
        Text text = new Text();
        List<TextElement> textElements = new ArrayList<>();

        for (String s : splitIntoTextElements(sourceText)) {
            if (Patterns.getInstance().getBlockOfCodePattern().matcher(s).matches()) {
                textElements.add(new BlockOfCode(s));
            } else {
                textElements.add(SentenceParser.parseSentence(s));
            }
        }

        text.setElements(textElements);
        return text;
    }

    private static List<String> splitIntoTextElements(String s) {
        Matcher matcher = Patterns.getInstance().getTextElementPattern().matcher(s);

        List<String> textElements = new ArrayList<>();
        while (matcher.find()) {
            String textElement = matcher.group();

            if (!textElement.isBlank()) {
                textElements.add(textElement);
            }
        }

        return textElements;
    }
}
