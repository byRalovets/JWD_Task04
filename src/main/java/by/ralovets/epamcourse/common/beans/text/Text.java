package by.ralovets.epamcourse.common.beans.text;

import by.ralovets.epamcourse.common.beans.text.element.TextElement;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Text implements Serializable {

    private static final long serialVersionUID = 1L;

    List<TextElement> elements;

    public Text() {
        elements = new LinkedList<>();
    }

    public Text(List<TextElement> elements) {
        this.elements = elements;
    }

    public List<TextElement> getElements() {
        return elements;
    }

    public void setElements(List<TextElement> elements) {
        this.elements = elements;
    }

    @Override
    public int hashCode() {
        return elements.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Text)) return false;

        Text text = (Text) obj;
        return elements.equals(text.elements);
    }

    @Override
    public String toString() {
        String[] strings = elements.stream()
                .map(Object::toString)
                .collect(Collectors.toList())
                .toArray(new String[]{});

        return String.join("\n", strings);
    }
}
