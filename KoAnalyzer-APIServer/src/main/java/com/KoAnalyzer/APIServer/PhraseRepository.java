package com.KoAnalyzer.APIServer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by parkjaesung on 2016. 9. 16..
 */
public interface PhraseRepository extends JpaRepository<Phrase, Long>{

    List<Phrase> findByTask(String task);
}
