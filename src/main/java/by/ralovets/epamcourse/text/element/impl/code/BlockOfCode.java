package by.ralovets.epamcourse.entity.element.impl.code;

import by.ralovets.epamcourse.entity.element.TextElement;

public class BlockOfCode implements TextElement {

    private static final long serialVersionUID = 1L;

    private String content;

    public BlockOfCode() {
    }

    public BlockOfCode(String content) {
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

        if (!(obj instanceof BlockOfCode)) return false;

        BlockOfCode blockOfCode = (BlockOfCode) obj;
        return content.equals(blockOfCode.content);
    }

    @Override
    public String toString() {
        return content;
    }
}
