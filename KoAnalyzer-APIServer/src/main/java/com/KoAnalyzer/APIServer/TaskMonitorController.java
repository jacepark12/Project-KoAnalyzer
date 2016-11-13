package com.KoAnalyzer.APIServer;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

/**
 * Created by parkjaesung on 2016. 11. 11..
 */
@Controller
public class TaskMonitorController {

    @Autowired
    PhraseService phraseService;

    @GetMapping("/tasks")
    public String showTaskMonitor(Map<String, Object> model){

        String phraseTextDataJson = getPhraseTextJSON();
        String phrasePosDataJson = getPhrasePosJSON();

        System.out.println("phrasePosDataJSON : " + phrasePosDataJson);
        System.out.println("phraseTextDataJSON : " + phraseTextDataJson);

        model.put("phraseTextData", phraseTextDataJson);
        model.put("phrasePosData", phrasePosDataJson);
        model.put("phraseArrayList", removeDuplicate(phraseService.findAll()));

        return "TaskMonitor";
    }

    public List<Phrase> removeDuplicate(List<Phrase> input){
        ArrayList<Phrase> phraseList = new ArrayList<>();

        for(Phrase phrase : input){
            if(!containsPhraseText(phraseList, phrase))
                phraseList.add(phrase);
        }

        return phraseList;
    }

    private boolean containsPhraseText(List<Phrase> phraseList, Phrase phraseInput){
        boolean result = false;

        for(Phrase phrase : phraseList){
            if(phrase.getText().equals(phraseInput.getText())){
                result = true;
                break;
            }
        }
        return result;
    }

    public String getPhrasePosJSON(){
        List<Phrase> phraseList = phraseService.findAll();

        JSONObject posJSON = new JSONObject();
        JSONObject posChartJSON = new JSONObject();
        JSONArray posDataJSONArray = new JSONArray();

        posChartJSON.put("caption", "Phrase Statistics");
        posChartJSON.put("theme", "ocean");
        posJSON.put("chart", posChartJSON);

        HashMap<String, Integer> posCount = (HashMap<String, Integer>) getPhrasePosCount(phraseList);

        Set<String> keySet = posCount.keySet();
        Iterator<String> keyIterator = keySet.iterator();

        while(keyIterator.hasNext()){
            JSONObject dataJSON = new JSONObject();
            String key = keyIterator.next();

            dataJSON.put("label" , key);
            dataJSON.put("value", posCount.get(key));

            posDataJSONArray.put(dataJSON);
        }

        posJSON.put("data", posDataJSONArray);


        System.out.println(phraseList.size());

        return posJSON.toString();
    }

    public String getPhraseTextJSON(){
        List<Phrase> phraseList = phraseService.findAll();

        JSONObject phraseJSON = new JSONObject();
        JSONObject phraseChartJSON = new JSONObject();
        JSONArray phraseDataJSONArray = new JSONArray();

        phraseChartJSON.put("caption", "Phrase Statistics");
        phraseChartJSON.put("theme", "ocean");
        phraseJSON.put("chart", phraseChartJSON);

        HashMap<String, Integer> phraseCount = (HashMap<String, Integer>) getPhraseTextCount(phraseList);

        Set<String> keySet = phraseCount.keySet();
        Iterator<String> keyIterator = keySet.iterator();

        while(keyIterator.hasNext()){
            JSONObject dataJSON = new JSONObject();
            String key = keyIterator.next();

            dataJSON.put("label" , key);
            dataJSON.put("value", phraseCount.get(key));

            phraseDataJSONArray.put(dataJSON);
        }

        phraseJSON.put("data", phraseDataJSONArray);


        System.out.println(phraseList.size());

        return phraseJSON.toString();
    }

    public Map<String, Integer> getPhrasePosCount(List<Phrase> phraseList){
        HashMap<String, Integer> posCount = new HashMap<>();

        for(Phrase phrase : phraseList){
            String pos = phrase.getPos();

            if(posCount.containsKey(pos)){
                posCount.put(pos, posCount.get(pos)+1);
            }else{
                posCount.put(pos, 1);
            }
        }

        return posCount;
    }

    public Map<String, Integer> getPhraseTextCount(List<Phrase> phraseList){
        HashMap<String, Integer> phraseCount = new HashMap<>();

        for(Phrase phrase : phraseList){
            String phraseText = phrase.getText();
            if(phraseCount.containsKey(phraseText)){
                phraseCount.put(phraseText, phraseCount.get(phraseText)+1);
            }else{
                phraseCount.put(phraseText,1);
            }
        }

        return phraseCount;
    }

/*
    private String densitySortWordsToJSON(ArrayList wordInfos){
        //Convert density word arraylist to JSON
        JSONObject densityJSON = new JSONObject();
        JSONObject densityChartJSON = new JSONObject();
        JSONArray densityDataJSONArray = new JSONArray();

        densityChartJSON.put("caption", "DensityKeyWord");
        densityChartJSON.put("theme", "ocean");
        densityJSON.put("chart", densityChartJSON);

        for (int i = 0; i < wordInfos.size(); i++) {
            WordInfo wordInfo = (WordInfo) wordInfos.get(i);

            SentimentTypeInterface.SentimentType sentimentType = wordInfo.getSentimentType();
            if(sentimentType != SentimentTypeInterface.SentimentType.NEUT && sentimentType != SentimentTypeInterface.SentimentType.NODATA){
                JSONObject densityDataJSON = new JSONObject();

                densityDataJSON.put("label", wordInfo.getWord());
                densityDataJSON.put("value", wordInfo.getDensity());

                densityDataJSONArray.put(densityDataJSON);
            }
        }

        densityJSON.put("data", densityDataJSONArray);

        return densityJSON.toString();

    }*/
}
