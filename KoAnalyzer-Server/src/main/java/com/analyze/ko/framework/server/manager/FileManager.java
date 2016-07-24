package com.analyze.ko.framework.server.manager;

import java.util.ArrayList;

/**
 * Created by parkjaesung on 2016. 7. 24..
 */

//Manages docment files saved in resources folder
public class FileManager {
    private static FileManager instance = new FileManager();
    private ArrayList<DocumentFile> documentFiles = new ArrayList<>();
    //private constructor
    private FileManager(){

    }

    public static FileManager getInstance(){
        return instance;
    }

    public void addDocumentFile(DocumentFile input){
        documentFiles.add(input);
    }

    public ArrayList getDocumentFiles(){
        return documentFiles;
    }

}
