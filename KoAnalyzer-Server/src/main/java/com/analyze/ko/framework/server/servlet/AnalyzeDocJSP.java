package com.analyze.ko.framework.server.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.analyze.ko.framework.korean.*;
import com.analyze.ko.framework.korean.DataClass.Document;
import com.analyze.ko.framework.korean.DataClass.SentimentTypeInterface;
import com.analyze.ko.framework.korean.DataClass.WordInfo;
import com.analyze.ko.framework.korean.managerclass.WordInfoManager;
import com.analyze.ko.framework.server.util.FileIO;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by parkjaesung on 2016. 7. 24..
 */
public class AnalyzeDocJSP extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FileIO fileIO = FileIO.getInstance();
        String currentDirectory = System.getProperty("user.dir");
        String idx = req.getParameter("idx");
        String outPutFileDirectory = currentDirectory + "/KoAnalyzer-server/src/main/resources/DataDocuments/"+ idx +".txt";
        StringBuilder sb = new StringBuilder();
        String docText = "";

        System.out.println("AnalyzeDocJSP doGet");
        System.out.println(req.getParameter("idx : "+ idx));

        docText = fileIO.readFile(outPutFileDirectory);

        //Create Document Object and analzye
        Document document = new Document();
        document.setTextData(docText);
        document.removeSpecialChar();
        document.setTextLength();
        document.setSentiment();

        WordInfoManager wordInfoManager = document.getWordInfoManager();

        ArrayList wordInfos = wordInfoManager.mapToArrayList();

        //Redirect JSP
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/AnalyzeDocument.jsp");

        //setAttribute to JSP
        System.out.println("doctText : " + docText);
        req.setAttribute("docText", docText);
        req.setAttribute("docLength", docText.length());
        req.setAttribute("densityWordsJSON", densitySortWordsToJSON(wordInfos));
        req.setAttribute("posWordsPositionJSON", posWordPositionsToJSON(wordInfos));
        req.setAttribute("negWordsPositionJSON", negWordPositionsToJSON(wordInfos));

        rd.forward(req, resp);
    }

    private String posWordPositionsToJSON(ArrayList<WordInfo> wordInfos){
        JSONObject posWordPositionJSON = new JSONObject();
        JSONObject posWordPositionChartJSON = new JSONObject();
        JSONArray posWordPositionDataJSON = new JSONArray();

        posWordPositionChartJSON.put("caption", "Positive KeyWord");
        posWordPositionChartJSON.put("theme", "ocean");
        posWordPositionJSON.put("chart", posWordPositionChartJSON);

        int posCount[] = new int[11];

        for (WordInfo wordInfo : wordInfos) {
            if(wordInfo.getSentimentType().equals(SentimentTypeInterface.SentimentType.POS)) {
                posCount[wordInfo.getPosAtTextPerCentage() / 10]++;
            }
        }

        for(int i = 0; i<posCount.length; i++){
            JSONObject positionDataJSON = new JSONObject();

            positionDataJSON.put("label", i*10 + "%");
            positionDataJSON.put("value", posCount[i]);

            posWordPositionDataJSON.put(positionDataJSON);
        }

        posWordPositionJSON.put("data", posWordPositionDataJSON);

        return posWordPositionJSON.toString();
    }

    private String negWordPositionsToJSON(ArrayList<WordInfo> wordInfos){
        JSONObject negWordPositionJSON = new JSONObject();
        JSONObject negWordPositionChartJSON = new JSONObject();
        JSONArray negWordPositionDataJSON = new JSONArray();

        negWordPositionChartJSON.put("caption", "Positive KeyWord");
        negWordPositionChartJSON.put("theme", "ocean");
        negWordPositionJSON.put("chart", negWordPositionChartJSON);

        int negCount[] = new int[11];

        for (WordInfo wordInfo : wordInfos) {
            if(wordInfo.getSentimentType().equals(SentimentTypeInterface.SentimentType.NEG)) {
                negCount[wordInfo.getPosAtTextPerCentage() / 10]++;
            }
        }

        for(int i = 0; i<negCount.length; i++){
            JSONObject positionDataJSON = new JSONObject();

            positionDataJSON.put("label", i*10 + "%");
            positionDataJSON.put("value", negCount[i]);

            negWordPositionDataJSON.put(positionDataJSON);
        }

        negWordPositionJSON.put("data", negWordPositionDataJSON);

        return negWordPositionJSON.toString();
    }

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

    }
}
