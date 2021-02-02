package by.ralovets.epamcourse.server.service.command.util;

import by.ralovets.epamcourse.common.beans.text.Text;
import by.ralovets.epamcourse.common.beans.text.element.TextElement;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.Sentence;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.SentenceElement;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.impl.Word;

import java.util.*;
import java.util.stream.Collectors;

public class TextUtils {

    public static final char[] VOWEL_LETTERS = {'А', 'а', 'Я', 'я', 'О', 'о', 'Е', 'е', 'У', 'у', 'Ю', 'ю', 'Ы', 'ы', 'И', 'и', 'Э', 'э', 'Е', 'е', 'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u', 'Y', 'y' };

    static {
        Arrays.sort(VOWEL_LETTERS);
    }

    public static List<Word> getWords(Text text) {
        return new ArrayList<>(getWords(getSentences(text)));
    }

    public static List<Word> getWords(List<Sentence> sentences) {
        List<Word> words = new ArrayList<>();

        for (Sentence sentence : sentences) {
            words.addAll(getWords(sentence));
        }

        return words;
    }

    public static int getCharEntryCount(char c, Word w) {
        int counter = 0;

        for (int i = 0; i < w.getContent().length(); i++) {
            if (w.getContent().charAt(i) == c) counter++;
        }

        return counter;
    }

    public static List<Word> getUniqueWords(List<Word> words) {
        return words.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Word> getWords(Sentence sentence) {
        List<Word> words = new ArrayList<>();

        List<SentenceElement> elements = sentence.getElements()
                .stream()
                .filter(s -> s instanceof Word)
                .collect(Collectors.toList());

        for (SentenceElement sentenceElement : elements) {
            words.add((Word) sentenceElement);
        }

        return words;
    }

    public static int getWordsCount(Sentence sentence) {
        return getWords(sentence).size();
    }

    public static List<Sentence> getSentences(Text text) {

        List<Sentence> sentences = new ArrayList<>();

        List<TextElement> elements = text.getElements()
                .stream()
                .filter(s -> s instanceof Sentence)
                .collect(Collectors.toList());

        for (TextElement textElement : elements) {
            sentences.add((Sentence) textElement);
        }

        return sentences;
    }

    public static boolean sentenceContainsWord(Sentence sentence, Word word) {
        return sentence.getElements().contains(word);
    }

    public static long sentencesContainsWordCount(List<Sentence> sentences, Word word) {
        return sentences.stream()
                .filter(s -> sentenceContainsWord(s, word))
                .count();
    }

    public static char getFirstChar(Word w) {
        return w.getContent().charAt(0);
    }

    public static int getVowelsCount(Word w) {
        int counter = 0;

        for (char c : w.getContent().toCharArray()) {
            if (Arrays.binarySearch(VOWEL_LETTERS, c) < 0) {
                counter++;
            }
        }
        return counter;
    }

    public static double getVowelsPercent(Word w) {
        return 1.0 * getVowelsCount(w) / w.getContent().length();
    }

    public static boolean startsWithConsonant(Word word) {
        String wordContent = word.getContent();
        boolean isVowel = false;

        for (char vowelLetter : VOWEL_LETTERS) {
            isVowel = wordContent.charAt(0) == vowelLetter;

            if (isVowel) break;
        }

        return !isVowel;
    }

    public static int getCharacterCount(Word word, char character) {
        int counter = 0;
        for (char c : word.getContent().toCharArray()) {
            if (character == c) {
                counter++;
            }
        }
        return counter;
    }
}
