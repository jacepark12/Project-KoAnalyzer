package text.korean.DataClass;

import com.twitter.penguin.korean.TwitterKoreanProcessorJava;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer;
import scala.collection.Seq;
import scala.collection.convert.WrapAsJava$;
import text.korean.PosDiscriminator;
import text.korean.SearchCorpusData;
import text.korean.fileio.WordInfoCSVWriter;
import text.korean.managerclass.WordDensityManager;
import text.korean.managerclass.WordInfoManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by parkjaesung on 2016. 7. 5..
 */
public class TextData implements SentimentTypeInterface{

    private String textData;
    private int textLength;
    private SentimentType sentimentType;

    //TODO HashMap으로 바꿔야할듯
    //단어당 하나의 wordDensity 객체가 있어야함
    //ArrayList를 순차적으로 검색하기엔 퍼포먼스 문제가 있을듯
    private ArrayList<WordDensity> tempWords = new ArrayList<>();

    //TODO Remove all Manager object
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

    public SentimentType getSentimentType() {
        return sentimentType;
    }

    public void setSentimentType(SentimentType sentimentType) {
        this.sentimentType = sentimentType;
    }

    //Getter & Setter ------------------------------------------------
    public void setSentitment(){
        SentimentType tempSentiment = SentimentType.NODATA;
        //SearchCorpusData object for searching word in corpus data
        Seq<KoreanTokenizer.KoreanToken> tokens = getKoreanTokensFromText(this.textData);

        System.out.println(TwitterKoreanProcessorJava.tokensToJavaStringList(tokens));
        // [한국어, 를, 처리, 하는, 예시, 입니, 다, ㅋㅋ, #한국어]
        System.out.println(TwitterKoreanProcessorJava.tokensToJavaKoreanTokenList(tokens));
        // [한국어(Noun: 0, 3), 를(Josa: 3, 1),  (Space: 4, 1), 처리(Noun: 5, 2), 하는(Verb: 7, 2),  (Space: 9, 1), 예시(Noun: 10, 2), 입니(Adjective: 12, 2), 다(Eomi: 14, 1), ㅋㅋ(KoreanParticle: 15, 2),  (Space: 17, 1), #한국어(Hashtag: 18, 4)]

        int textIndex = 1;
        List textTokens = convertToList(tokens);
        for (Object textToken: textTokens) {

            KoreanTokenizer.KoreanToken token = (KoreanTokenizer.KoreanToken)textToken;
            if(PosDiscriminator.isSentimentWord(token)){
                WordDensity wordDensity = new WordDensity();

                String text = token.text();
                wordDensity.setWord(text);

                try {
                    tempSentiment = searchCorpusData.getWordSentimentType(text);
                    wordDensity.setSentimentType(tempSentiment);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                wordDensity.addDataToPositionArrayList(textIndex);

                //%를 구한뒤 1의 자리에서 반올림
                wordDensity.setPosAtTextPerCentage(changeAsMultipleOfTen(getPercentageOfPosition(textIndex, textLength)));
                textIndex += text.length();

                tempWords.add(wordDensity);
            }else{//save wordInfo as Neutral Word

                WordDensity wordDensity = new WordDensity();

                String text = token.text();
                wordDensity.setWord(text);
                wordDensity.setSentimentType(SentimentType.NEUT);
                wordDensity.setPosAtTextPerCentage(changeAsMultipleOfTen(getPercentageOfPosition(textIndex, textLength)));
                wordDensity.addDataToPositionArrayList(textIndex);
                textIndex += text.length();

                tempWords.add(wordDensity);
            }
        }

        System.out.println("Finished Searching data");
        //write csv
        wordInfoCSVWriter.exportWordInfoToCVS(tempWords);


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

    private java.util.List<KoreanTokenizer.KoreanToken> convertToList(scala.collection.Seq<KoreanTokenizer.KoreanToken> seq) {
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
