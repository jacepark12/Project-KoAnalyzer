package com.analyze.ko.framework.korean.managerclass;


import com.analyze.ko.framework.korean.DataClass.WordInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Collectors;

/**
 * Created by parkjaesung on 2016. 7. 2..
 */
public class WordInfoManager {

    //String key == Classs WordInfo memeber variable word
    private HashMap<String, WordInfo> infoHashMap = new HashMap<>();

    public WordInfo getWordInfoClass(String key){
        return this.infoHashMap.get(key);
    }

    public void updateWordInfo(WordInfo wordInfo){
        infoHashMap.put(wordInfo.getWord(), wordInfo);
    }

    public boolean isWordInfoExists(String key){
        return infoHashMap.containsKey(key);
    }

    public ArrayList mapToArrayList() {
        ArrayList result = infoHashMap.keySet().stream().map(o -> infoHashMap.get(o)).collect(Collectors.toCollection(ArrayList::new));

        //Sort WordInfos by density(double)
        Collections.sort(result);

        return result;
    }

    public void calculateWordsDensity(){
        Iterator keys = infoHashMap.keySet().iterator();

        while(keys.hasNext()){
            infoHashMap.get(keys.next()).calculateDensity();
        }
    }

    //Getter & Setter
    public HashMap<String, WordInfo> getInfoHashMap() {
        return infoHashMap;
    }

    public void setInfoHashMap(HashMap<String, WordInfo> infoHashMap) {
        this.infoHashMap = infoHashMap;
    }
}
