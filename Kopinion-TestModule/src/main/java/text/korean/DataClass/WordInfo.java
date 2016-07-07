package text.korean.DataClass;

import java.util.ArrayList;

/**
 * Created by parkjaesung on 2016. 7. 2..
 */
public class WordInfo implements SentimentTypeInterface{

    private String word;
    //Variable positionAvg's value is only est by private method calculateDistribution
    private double positionAvg;
    private ArrayList<Double> positionArrayList = new ArrayList();

    //Variable density's value is only est by private method calculateDistribution
    private double density;
    private int posAtTextPerCentage; //save as percentage by multiples of 10
    private SentimentType sentimentType;

    public void addDataToPositionArrayList(double input){
        positionArrayList.add(input);
    }

    public int getPosAtTextPerCentage() {
        return posAtTextPerCentage;
    }

    public void setPosAtTextPerCentage(int posAtTextPerCentage) {
        this.posAtTextPerCentage = posAtTextPerCentage;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public double getPositionAvg() {
        return positionAvg;
    }

    public ArrayList getPositionArrayList() {
        return positionArrayList;
    }

    public double getDensity() {
        return density;
    }

    public SentimentType getSentimentType() {
        return sentimentType;
    }

    public void setSentimentType(SentimentType sentimentType) {
        this.sentimentType = sentimentType;
    }

    public void calculateDensity(){

        //Get Average
        double sum = 0;
        for (Double position : this.positionArrayList) {
            sum+=position;
        }
        this.positionAvg = sum / this.positionArrayList.size()+1;

        //Calculate Distribution
        double distributionSum = 0;
        for (Double position : this.positionArrayList) {
            distributionSum += Math.pow(this.positionAvg - position,2);
        }

        this.density = distributionSum / this.positionArrayList.size()+1;
    }
}
