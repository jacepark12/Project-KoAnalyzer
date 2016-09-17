package com.KoAnalyzer.APIServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parkjaesung on 2016. 9. 16..
 */
@Service
public class PhraseImpl implements PhraseService {

    @Resource
    PhraseRepository phraseRepository;

    public void savePhrase(Phrase phrase) {
        //TODO 일단은 그냥 저장
        //그런데 만약 phrase의 text로 count값을 누적시킬수없을 경우에는
        //text로 검색을 하고 count값을 누적시키도록 쿼리를 짜야함
        System.out.println("This is PhraseImpl class save Phrase method");
        phraseRepository.save(phrase);
    }

    public List<Phrase> findAll() {

        return phraseRepository.findAll();

    }

    //TODO Update findByTask Method
    public List<Phrase> findByTask() {
        return null;
    }

    public void deletePhrase(Phrase phrase) {
        phraseRepository.delete(phrase);
    }
}
