package com.analyze.ko.framework.korean.managerclass;


import java.util.ArrayList;
import com.analyze.ko.framework.korean.DataClass.*;

/**
 * Created by parkjaesung on 2016. 7. 5..
 */

//Singleton Pattern
public class TextDataManager {

    private static TextDataManager instance = new TextDataManager();

    private ArrayList<Document> documents = new ArrayList<>();

    //private Constructor
    private TextDataManager(){

    }

    public static TextDataManager getInstance(){
        return instance;
    }

    public ArrayList<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<Document> documents) {
        this.documents = documents;
    }

    public void addTextData(Document input){
        this.documents.add(input);
    }
}
