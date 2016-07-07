package text.korean.DataClass;

import java.util.ArrayList;

/**
 * Created by parkjaesung on 2016. 7. 2..
 */
//TODO Refactor WordDensity Class name
//최종적으로 textData의 sentiment type을 결정하는 객체는 WordDensity를 사용하기 때문
//그렇다면 아예 WordInfo 클래스를 삭제하는 것은 어떨까?
//WordDensity + WordInfo 클래스를 통합하는 방향으로 가자
public class WordDensity implements SentimentTypeInterface{

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

    public void calculateDistribution(){

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
