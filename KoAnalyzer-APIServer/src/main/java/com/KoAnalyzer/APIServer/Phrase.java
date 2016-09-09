package com.KoAnalyzer.APIServer;

/**
 * Created by parkjaesung on 2016. 9. 9..
 * Phrase class is used for Stemming, Extraction
 */
public class Phrase {

    private String text;
    private String pos;
    private int length;
    private int offset;

    //getter & setter

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
