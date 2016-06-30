package text.korean;

import com.twitter.penguin.korean.TwitterKoreanProcessorJava;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer;
import scala.collection.Iterable;
import scala.collection.Seq;
import scala.collection.convert.WrapAsJava;
import scala.collection.convert.WrapAsJava$;
import scala.collection.mutable.StringBuilder;
import text.korean.DataClass.WordInfo;
import text.korean.DataClass.WordInfoManager;

import java.io.IOException;
import java.util.List;

/**
 * Created by parkjaesung on 2016. 6. 29..
 */
public class KoreanTextTokenizer {

    private static String text ="박근혜는 살인 범죄 의혹을 받고 있다\n";
    public static void main(String[] args){

        //SearchCorpusData object for searching word in corpus data
        SearchCorpusData searchCorpusData = SearchCorpusData.getInstance();

        // Normalize
        CharSequence normalized = TwitterKoreanProcessorJava.normalize(text);
        System.out.println(normalized);

        // Tokenize
        Seq<KoreanTokenizer.KoreanToken> tokens = TwitterKoreanProcessorJava.tokenize(normalized);
        System.out.println(TwitterKoreanProcessorJava.tokensToJavaStringList(tokens));
        // [한국어, 를, 처리, 하는, 예시, 입니, 다, ㅋㅋ, #한국어]
        System.out.println(TwitterKoreanProcessorJava.tokensToJavaKoreanTokenList(tokens));
        // [한국어(Noun: 0, 3), 를(Josa: 3, 1),  (Space: 4, 1), 처리(Noun: 5, 2), 하는(Verb: 7, 2),  (Space: 9, 1), 예시(Noun: 10, 2), 입니(Adjective: 12, 2), 다(Eomi: 14, 1), ㅋㅋ(KoreanParticle: 15, 2),  (Space: 17, 1), #한국어(Hashtag: 18, 4)]

        List textTokens = convertToList(tokens);
        for (Object textToken: textTokens) {

            KoreanTokenizer.KoreanToken token = (KoreanTokenizer.KoreanToken)textToken;
            if(PosDiscriminator.isSentimentWord(token)){
                WordInfo wordInfo = new WordInfo();


                StringBuffer text = new StringBuffer().append(token.text());
                wordInfo.setWord(text);

                try {
                    wordInfo.setPositive(searchCorpusData.isWordPositive(text));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                WordInfoManager.wordInfoArrayList.add(wordInfo);
            }
        }

        System.out.println("Finished Searching data");

        for (WordInfo wordInfo: WordInfoManager.wordInfoArrayList) {

            System.out.println("word : "+ wordInfo.getWord().toString());
            System.out.println("pos ? neg? : " + wordInfo.isPositive());

        }
    }

    private static java.util.List<KoreanTokenizer.KoreanToken> convertToList(scala.collection.Seq<KoreanTokenizer.KoreanToken> seq) {
        return WrapAsJava$.MODULE$.seqAsJavaList(seq);
    }

}


