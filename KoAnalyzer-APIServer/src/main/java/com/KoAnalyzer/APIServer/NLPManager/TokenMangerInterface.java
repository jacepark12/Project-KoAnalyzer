package com.KoAnalyzer.APIServer.NLPManager;

import com.KoAnalyzer.APIServer.NLPManager.NLPManagerInterface;
import com.KoAnalyzer.APIServer.Phrase;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer;
import scala.collection.Seq;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parkjaesung on 2016. 9. 22..
 */
public interface TokenMangerInterface extends NLPManagerInterface {

    public ArrayList<Phrase> convertTokens(Seq<KoreanTokenizer.KoreanToken> tokens, String task);
    public List<KoreanTokenizer.KoreanToken> convertToList(scala.collection.Seq<KoreanTokenizer.KoreanToken> seq);
}
