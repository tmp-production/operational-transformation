package ot.internal;

/**
 * Created by Stas on 3/12/16.
 */
public class Retain extends TextChange {
    private final int length;

    public Retain(int length) {
        this.length = length;
    }

    @Override
    Text apply(int pos, Text text) throws ValidationException {
        return text;
    }

    @Override
    int offset() {
        return length;
    }

    @Override
    public String toString() {
        return "SKIP: " + length;
    }
}
