package by.ralovets.epamcourse.client.service.parser.util;

import java.io.*;
import java.util.Properties;
import java.util.regex.Pattern;

public class Patterns {

    private Pattern textElementPattern;
    private Pattern blockOfCodePattern;
    private Pattern sentenceElementPattern;
    private Pattern punctuationMarkPattern;

    private static Patterns instance;

    public static Patterns getInstance() {
        if (instance == null) {
            instance = new Patterns();
        }

        return instance;
    }

    public Pattern getTextElementPattern() {
        return textElementPattern;
    }

    public Pattern getBlockOfCodePattern() {
        return blockOfCodePattern;
    }

    public Pattern getSentenceElementPattern() {
        return sentenceElementPattern;
    }

    public Pattern getPunctuationMarkPattern() {
        return punctuationMarkPattern;
    }

    private Patterns() {
        initialize();
    }

    private void initialize() {
        Properties props = null;

        try {
            InputStream in = getClass().getClassLoader().getResourceAsStream("regexp.properties");
            props = new Properties();
            props.load(in);
            in.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

        if (props == null) return;
        // ToDo: Throw Exception

        String textFlags = props.getProperty("textFlags");
        String sentence = props.getProperty("sentence");
        String blockOfCode = props.getProperty("blockOfCode");
        String sentenceFlags = props.getProperty("sentenceFlags") ;
        String punctuationMark = props.getProperty("punctuationMark");
        String word = props.getProperty("word");

        // ToDo: Throw Exception
        if (sentence == null
                || blockOfCode == null
                || punctuationMark == null
                || word == null) {
            return;
        }

        sentenceFlags = sentenceFlags == null ? "" : sentenceFlags;
        textFlags = textFlags == null ? "" : textFlags;

        punctuationMarkPattern = Pattern.compile(punctuationMark);
        blockOfCodePattern = Pattern.compile(blockOfCode);
        sentenceElementPattern = Pattern.compile(
                sentenceFlags + '(' + word + ")|(" + punctuationMark + ')'
        );
        textElementPattern = Pattern.compile(
                textFlags + '(' + blockOfCode + ")|(" + sentence + ')'
        );
    }


}