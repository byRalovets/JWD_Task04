package by.ralovets.epamcourse.server.service.command.impl;

import by.ralovets.epamcourse.common.beans.text.element.TextElement;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.Sentence;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.SentenceElement;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.impl.Word;
import by.ralovets.epamcourse.server.service.command.Command;
import by.ralovets.epamcourse.common.beans.text.Text;
import by.ralovets.epamcourse.server.service.command.util.TextUtils;

import java.util.Arrays;
import java.util.Collections;

public class Task14 implements Command {

    @Override
    public String execute(Text text, Object additional) {
        int maxWordLenhgth = 0;
        Word resultWord = new Word("");

        for (TextElement tElem : TextUtils.getSentences(text)) {
            if (tElem instanceof Sentence) {
                Sentence sentence = (Sentence) tElem;
                for (SentenceElement sElem : TextUtils.getWords(sentence)) {
                    if (sElem instanceof Word) {
                        Word word = (Word) sElem;
                        String wordContent = word.getContent();

                        if (isPalindrome(wordContent)) {
                            if (wordContent.length() > maxWordLenhgth) {
                                maxWordLenhgth = wordContent.length();
                            }
                        }
                    }
                }
            }
        }
        return resultWord.getContent() + maxWordLenhgth;
    }

    private boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < (n/2); ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
