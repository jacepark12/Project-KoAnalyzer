package com.KoAnalyzer.APIServer.NLPManager;

import com.KoAnalyzer.APIServer.NLPManager.NLPManagerInterface;
import com.KoAnalyzer.APIServer.Phrase;
import com.twitter.penguin.korean.phrase_extractor.KoreanPhraseExtractor;

import java.util.List;

/**
 * Created by parkjaesung on 2016. 9. 22..
 */
public interface PhraseManagerInterface extends NLPManagerInterface {

    public List<Phrase> convertKoreanPhrase(List<KoreanPhraseExtractor.KoreanPhrase> phrases, String task);
}
