package com.analyze.ko.framework.korean.DataClass;


import com.analyze.ko.framework.korean.PosDiscriminator;
import com.analyze.ko.framework.korean.SearchCorpusData;
import com.analyze.ko.framework.korean.fileio.WordInfoCSVWriter;
import com.analyze.ko.framework.korean.DataClass.WordInfo;
import com.analyze.ko.framework.korean.managerclass.WordInfoManager;
import com.twitter.penguin.korean.TwitterKoreanProcessorJava;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer;
import scala.collection.Seq;
import scala.collection.convert.WrapAsJava$;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by parkjaesung on 2016. 7. 5..
 */

/*
Document Class Usage

 */
public class Document implements SentimentTypeInterface{

    private String textData;
    private int textLength;
    private SentimentType calculatedSentiment;
    //For comparing original sentiment and calculated sentiments
    private SentimentType originalSentiment;

    private WordInfoManager wordInfoManager = new WordInfoManager();

    //Singleton Objects
    private SearchCorpusData searchCorpusData = SearchCorpusData.getInstance();
    private WordInfoCSVWriter wordInfoCSVWriter = WordInfoCSVWriter.getInstance();

    //TODO Refactor code using REGEX
    public void removeSpecialChar(){

        this.textData = this.textData.replaceAll("\"", "");
        this.textData = this.textData.replaceAll("<", "");
        this.textData = this.textData.replaceAll(">", "");
        this.textData = this.textData.replaceAll("\n", "");
    }

    public void setTextLength(){
        this.textLength = textData.length();
    }

    //Getter & Setter ------------------------------------------------
    public int getTextLength(){
        return this.textLength;
    }

    public String getTextData(){
        return this.textData;
    }

    public void setTextData(String input){
        this.textData = input;
    }

    public SentimentType getCalculatedSentiment() {
        return calculatedSentiment;
    }

    public void setCalculatedSentiment(SentimentType calculatedSentiment) {
        this.calculatedSentiment = calculatedSentiment;
    }

    public SentimentType getOriginalSentiment() {
        return originalSentiment;
    }

    public void setOriginalSentiment(SentimentType originalSentiment) {
        this.originalSentiment = originalSentiment;
    }

    public WordInfoManager getWordInfoManager(){
        return wordInfoManager;
    }
    //Getter & Setter ------------------------------------------------
    public void setSentiment(){
        SentimentType tempSentiment = SentimentType.NODATA;

        //SearchCorpusData object for searching word in corpus data
        Seq<KoreanTokenizer.KoreanToken> tokens = getKoreanTokensFromText(this.textData);

        System.out.println(TwitterKoreanProcessorJava.tokensToJavaStringList(tokens));
        // [한국어, 를, 처리, 하는, 예시, 입니, 다, ㅋㅋ, #한국어]
        System.out.println(TwitterKoreanProcessorJava.tokensToJavaKoreanTokenList(tokens));
        // [한국어(Noun: 0, 3), 를(Josa: 3, 1),  (Space: 4, 1), 처리(Noun: 5, 2), 하는(Verb: 7, 2),  (Space: 9, 1), 예시(Noun: 10, 2), 입니(Adjective: 12, 2), 다(Eomi: 14, 1), ㅋㅋ(KoreanParticle: 15, 2),  (Space: 17, 1), #한국어(Hashtag: 18, 4)]

        int textIndex = 1;
        List<KoreanTokenizer.KoreanToken> textTokens = convertToList(tokens);

        for (KoreanTokenizer.KoreanToken textToken: textTokens) {

            KoreanTokenizer.KoreanToken token = textToken;

            String tokenText;
            tokenText = token.text();

            WordInfo wordInfo;
            if(wordInfoManager.isWordInfoExists(tokenText)){
                wordInfo = wordInfoManager.getWordInfoClass(tokenText);
            }else{
                wordInfo = new WordInfo();
            }

            if(PosDiscriminator.isSentimentWord(token)){
                wordInfo.setWord(tokenText);

                try {
                    tempSentiment = searchCorpusData.getWordSentimentType(tokenText);
                    wordInfo.setSentimentType(tempSentiment);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                wordInfo.addDataToPositionArrayList(textIndex);

                //%를 구한뒤 1의 자리에서 반올림
                wordInfo.setPosAtTextPerCentage(changeAsMultipleOfTen(getPercentageOfPosition(textIndex, textLength)));
                textIndex += tokenText.length();

                wordInfoManager.updateWordInfo(wordInfo);
            }else{//save wordInfo as Neutral Word

                wordInfo.setWord(tokenText);
                wordInfo.setSentimentType(SentimentType.NEUT);
                wordInfo.setPosAtTextPerCentage(changeAsMultipleOfTen(getPercentageOfPosition(textIndex, textLength)));
                wordInfo.addDataToPositionArrayList(textIndex);
                textIndex += tokenText.length();

                wordInfoManager.updateWordInfo(wordInfo);
            }
        }

        System.out.println("Finished Searching data");

        //Calculate Word's Density
        wordInfoManager.calculateWordsDensity();

        //TODO 최종적으로 글에 대한 Sentiment를 설정해줘야 함
       //write csv
        wordInfoCSVWriter.exportPositionToCSV(wordInfoManager.mapToArrayList());

    }

    public void calculateTextSentiment(){

        int Theta = 5000;
        //지금은 가중치고 뭐고 그런거 없음
        int posCount = 0;
        int negCount = 0;
        ArrayList<WordInfo> wordInfos = wordInfoManager.mapToArrayList();

        for (WordInfo wordInfo: wordInfos) {

            switch (wordInfo.getSentimentType().toString()){
                case "POS" :
                    posCount+= (int)Theta * wordInfo.getDensity();
                    break;
                case "NEG" :
                    negCount+= (int)Theta * wordInfo.getDensity();
                    break;
            }
            System.out.println(wordInfo.getSentimentType().toString());

        }

        if(posCount > negCount){
            calculatedSentiment = SentimentType.POS;
        }else if(posCount < negCount){
            calculatedSentiment = SentimentType.NEG;
        }else if(negCount == posCount){
            calculatedSentiment = SentimentType.NEUT;
        }else{
            calculatedSentiment = SentimentType.NODATA;
        }
    }

    public boolean compareOriginalAndCalculated(){
        if(calculatedSentiment.equals(originalSentiment)){
            return true;
        }else{
            return false;
        }
    }

    //TODO Move these methods to util package
    private long getPercentageOfPosition(int wordPosition, int totalLength){

        return Math.round((long)(wordPosition * 100)/totalLength);
    }

    //1의 자리에서 반올림
    //ex) 13 -> 10
    //ex) 17 -> 20
    private int changeAsMultipleOfTen(long input){
        return (int) ((input+5)/10 * 10);
    }

    private List<KoreanTokenizer.KoreanToken> convertToList(scala.collection.Seq<KoreanTokenizer.KoreanToken> seq) {
        return WrapAsJava$.MODULE$.seqAsJavaList(seq);
    }

    private Seq<KoreanTokenizer.KoreanToken> getKoreanTokensFromText(String text){
        // Normalize
        CharSequence normalized = TwitterKoreanProcessorJava.normalize(text);
        System.out.println(normalized);

        Seq<KoreanTokenizer.KoreanToken> tokens = TwitterKoreanProcessorJava.tokenize(normalized);

        return tokens;
    }

}
