package text.korean.DataClass;

import java.util.ArrayList;

/**
 * Created by parkjaesung on 2016. 7. 2..
 */
public class WordDistribution {

    private String word;
    private double positionAvg;
    private ArrayList positionArrayList = new ArrayList();
    private double distribute;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public double getPositionAvg() {
        return positionAvg;
    }

    public void setPositionAvg(double positionAvg) {
        this.positionAvg = positionAvg;
    }

    public ArrayList getPositionArrayList() {
        return positionArrayList;
    }

    public void setPositionArrayList(ArrayList positionArrayList) {
        this.positionArrayList = positionArrayList;
    }

    public double getDistribute() {
        return distribute;
    }

    public void setDistribute(double distribute) {
        this.distribute = distribute;
    }
}
