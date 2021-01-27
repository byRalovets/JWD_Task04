package by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.impl;

import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.SentenceElement;

public class Word implements SentenceElement {

    private static final long serialVersionUID = 1L;

    private String content;

    public Word() {
    }

    public Word(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Word)) return false;

        Word word = (Word) obj;
        return content.equals(word.content);
    }

    @Override
    public String toString() {
        return content;
    }
}
