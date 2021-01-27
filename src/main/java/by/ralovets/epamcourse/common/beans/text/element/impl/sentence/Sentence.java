package by.ralovets.epamcourse.common.beans.text.element.impl.sentence;

import by.ralovets.epamcourse.common.beans.text.element.TextElement;
import by.ralovets.epamcourse.common.beans.text.element.impl.sentence.element.SentenceElement;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Sentence implements TextElement {

    private static final long serialVersionUID = 1L;

    List<SentenceElement> elements;

    public Sentence() {
        elements = new LinkedList<>();
    }

    public Sentence(List<SentenceElement> elements) {
        this.elements = elements;
    }

    public List<SentenceElement> getElements() {
        return elements;
    }

    public void setElements(List<SentenceElement> elements) {
        this.elements = elements;
    }

    @Override
    public int hashCode() {
        return elements.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Sentence)) return false;

        Sentence sentence = (Sentence) obj;
        return elements.equals(sentence.elements);
    }

    @Override
    public String toString() {

        String[] strings = elements.stream()
                .map(Object::toString)
                .collect(Collectors.toList())
                .toArray(new String[]{});

        return String.join(" ", strings);
    }
}
