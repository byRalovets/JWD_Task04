package by.ralovets.epamcourse;

import by.ralovets.epamcourse.entity.Text;
import by.ralovets.epamcourse.entity.element.TextElement;
import by.ralovets.epamcourse.entity.element.impl.sentence.Sentence;
import by.ralovets.epamcourse.entity.element.impl.sentence.element.SentenceElement;
import by.ralovets.epamcourse.entity.element.impl.sentence.element.impl.PunctuationMark;
import by.ralovets.epamcourse.entity.element.impl.sentence.element.impl.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tasks {

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

    public static int getCharacterCount(Word word, char character) {
        int counter = 0;
        for (char c : word.getContent().toCharArray()) {
            if (character == c) {
                counter++;
            }
        }
        return counter;
    }

    //--------------------------------------------------------------------------

    public static long Task01(Text text) {
        List<Word> uniqueWords = getUniqueWords(getWords(text));

        long maxMatches = 0;
        for (Word word : uniqueWords) {
            long matches = sentencesContainsWordCount(getSentences(text), word);
            if (matches > maxMatches) {
                maxMatches = matches;
            }
        }

        return maxMatches;
    }

    public static List<Sentence> Task02(Text text) {
        return getSentences(text).stream()
                .sorted((a, b) -> {
                    int aWordsCount = getWordsCount(a);
                    int bWordsCount = getWordsCount(b);

                    if (aWordsCount > bWordsCount) {
                        return 1;
                    } else if (aWordsCount == bWordsCount) {
                        return 0;
                    }
                    return -1;
                })
                .collect(Collectors.toList());
    }

    public static Word Task03(Text text) {
        List<Sentence> sentences = getSentences(text);

        if (sentences.size() < 2) return null;

        Sentence firstSentence = sentences.get(0);
        sentences = sentences.subList(1, sentences.size());

        for (Word word : getWords(firstSentence)) {
            if (!sentences.contains(word)) return word;
        }

        return null;
    }

    public static List<Word> Task04(Text text, int length) {
        final PunctuationMark questionMark = new PunctuationMark();
        questionMark.setValue("?");

        List<Sentence> questionSentences = getSentences(text).stream()
                .filter(s -> s.getElements().get(s.getElements().size() - 1).equals(questionMark))
                .collect(Collectors.toList());

        return getWords(questionSentences).stream()
                .filter(w -> w.getContent().length() == length)
                .distinct()
                .collect(Collectors.toList());
    }

    public static Text Task05(Text text) {
        List<Word> words;
        Word w1, w2;
        for (Sentence sentence : getSentences(text)) {
            words = getWords(sentence);

            if (words.size() > 1) {
                w1 = words.get(0);
                w2 = words.get(words.size() - 1);

                words.remove(0);
                words.add(0, w2);
                words.add(w1);
            }
        }
        return text;
    }

    public static String Task06(Text text) {
        List<Word> words = getWords(text).stream()
                .sorted((w1, w2) -> {
                    char c1 = getFirstChar(w1);
                    char c2 = getFirstChar(w2);

                    if (c1 > c2) {
                        return 1;
                    } else if (c1 == c2) {
                        return 0;
                    }
                    return -1;
                })
                .distinct()
                .collect(Collectors.toList());

        StringBuilder builder = new StringBuilder();

        char currentChar = 0;
        for (Word word : words) {
            if (currentChar != getFirstChar(word)) {
                currentChar = getFirstChar(word);
                builder.append("\n\t");
            }

            builder.append(word).append("; ");
        }

        return builder.toString();
    }

    public static List<Word> Task07(Text text) {
        return getWords(text).stream()
                .distinct()
                .sorted((w1, w2) -> {
                    double w1VowelsPercent = getVowelsPercent(w1);
                    double w2VowelsPercent = getVowelsPercent(w2);

                    if (w1VowelsPercent > w2VowelsPercent) {
                        return 1;
                    } else if (w1VowelsPercent == w2VowelsPercent) {
                        return 0;
                    }
                    return -1;
                })
                .collect(Collectors.toList());
    }

    public static List<Word> Task08(Text text) {
        return getWords(text).stream()
                .distinct()
                .filter(w -> Arrays.binarySearch(VOWEL_LETTERS, getFirstChar(w)) < 0)
                .sorted((w1, w2) -> {
                    char c1 = getFirstChar(w1);
                    char c2 = getFirstChar(w2);

                    if (c1 > c2) {
                        return 1;
                    } else if (c1 == c2) {
                        return 0;
                    }
                    return -1;
                })
                .collect(Collectors.toList());
    }

    public static List<Word> Task09(Text text, char c) {
        List<Word> words = getWords(text).stream()
                .sorted((w1, w2) -> {
                    int w1CharCount = getCharacterCount(w1, c);
                    int w2CharCount = getCharacterCount(w2, c);

                    if (w1CharCount > w2CharCount) {
                        return 1;
                    } else if (w1CharCount == w2CharCount) {
                        return 0;
                    }
                    return -1;
                })
                .collect(Collectors.toList());
    }
}
