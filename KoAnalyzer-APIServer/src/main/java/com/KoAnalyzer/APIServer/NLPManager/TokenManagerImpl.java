package com.KoAnalyzer.APIServer.NLPManager;

import com.KoAnalyzer.APIServer.Phrase;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer;
import scala.collection.Seq;
import scala.collection.convert.WrapAsJava$;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parkjaesung on 2016. 9. 22..
 */
public class TokenManagerImpl implements TokenMangerInterface {
    //TODO convertTokens 메서드와 convertPhrase 메서드로 하나로 묶어서 상위 인터페이스에 정의한담에 걍 재정의할까나 고민되네
    @Override
    public ArrayList<Phrase> convertTokens(Seq<KoreanTokenizer.KoreanToken> tokens, String task) {

        ArrayList<Phrase> converted = new ArrayList<Phrase>();

        for(KoreanTokenizer.KoreanToken token : convertToList(tokens)){
            Phrase convertedToken = new Phrase();

            convertedToken.setText(token.text());
            convertedToken.setPos(token.pos().toString());
            convertedToken.setOffset(token.offset());
            convertedToken.setLength(token.length());
            convertedToken.setTask(task);

            converted.add(convertedToken);
        }

        return converted;
    }

    @Override
    public List<KoreanTokenizer.KoreanToken> convertToList(Seq<KoreanTokenizer.KoreanToken> seq) {
        return WrapAsJava$.MODULE$.seqAsJavaList(seq);
    }
}
