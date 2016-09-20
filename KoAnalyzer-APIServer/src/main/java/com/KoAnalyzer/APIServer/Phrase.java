package com.KoAnalyzer.APIServer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by parkjaesung on 2016. 9. 9..
 * Phrase class is used for Stemming, Extraction
 */
@Entity
public class Phrase {

    @Id
    @GeneratedValue
    private long id;

    private String phraseText;
    private String phrasePos;
    private String phraseTask;
    private int phraseLength;
    private int phraseOffset;

    private int phraseCount = 0; //자연어 처리 결과로 사용된 횟수

    //getter & setter

    public String getText() {
        return phraseText;
    }

    public void setText(String text) {
        this.phraseText = text;
    }

    public String getPos() {
        return phrasePos;
    }

    public void setPos(String pos) {
        this.phrasePos = pos;
    }

    public int getLength() {
        return phraseLength;
    }

    public void setLength(int length) {
        this.phraseLength = length;
    }

    public int getOffset() {
        return phraseOffset;
    }

    public void setOffset(int offset) {
        this.phraseOffset = offset;
    }

    public String getTask() {
        return phraseTask;
    }

    public void setTask(String task) {
        this.phraseTask = task;
    }

    public int getCount() {
        return phraseCount;
    }

    public void setCount(int count) {
        this.phraseCount = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
