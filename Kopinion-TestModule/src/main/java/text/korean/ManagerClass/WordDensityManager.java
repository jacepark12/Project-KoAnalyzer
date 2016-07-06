package text.korean.managerclass;

import text.korean.DataClass.WordDensity;

import java.util.HashMap;

/**
 * Created by parkjaesung on 2016. 7. 2..
 */
public class WordDensityManager {

    //String key == WordDistibution memeber variable word
    private HashMap<String, WordDensity> densityHashMap = new HashMap<>();

    public WordDensity getWordDensityClass(String key){
        return this.densityHashMap.get(key);
    }

    public void updateWordDensity(WordDensity wordDensity){
        densityHashMap.put(wordDensity.getWord(), wordDensity);
    }

    public boolean isDensityInfoExists(String key){
        return densityHashMap.containsKey(key);
    }

    public void printDensityInfo(){

        for (Object key : densityHashMap.keySet()) {
            WordDensity wordDensity = densityHashMap.get(key);

            System.out.println("단어 : " + wordDensity.getWord());

            //분산도 계산
            wordDensity.calculateDistribution();

            System.out.println("분산도 :" + wordDensity.getDensity());

        }
    }

    //Getter & Setter
    public HashMap<String, WordDensity> getDensityHashMap() {
        return densityHashMap;
    }

    public void setDensityHashMap(HashMap<String, WordDensity> densityHashMap) {
        this.densityHashMap = densityHashMap;
    }
}
