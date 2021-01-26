package by.ralovets.epamcourse.entity.element.impl.sentence.element.impl;

import by.ralovets.epamcourse.entity.element.impl.sentence.element.SentenceElement;

public class PunctuationMark implements SentenceElement {

    private static final long serialVersionUID = 1L;

    private String value;

    public PunctuationMark() {
    }

    public PunctuationMark(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof PunctuationMark)) return false;

        PunctuationMark mark = (PunctuationMark) obj;
        return value.equals(mark.value);
    }

    @Override
    public String toString() {
        return value;
    }
}
