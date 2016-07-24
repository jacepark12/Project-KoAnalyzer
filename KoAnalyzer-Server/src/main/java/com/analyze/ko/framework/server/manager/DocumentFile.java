package com.analyze.ko.framework.server.manager;

/**
 * Created by parkjaesung on 2016. 7. 24..
 */
//Used at FileManager Object
public class DocumentFile {

    private String text;
    private String idx;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }
}
