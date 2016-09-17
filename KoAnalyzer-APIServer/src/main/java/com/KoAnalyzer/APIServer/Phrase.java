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

    private String text;
    private String pos;
    private String task;
    private int length;
    private int offset;
    private int count; //자연어 처리 결과로 사용된 횟수

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

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
