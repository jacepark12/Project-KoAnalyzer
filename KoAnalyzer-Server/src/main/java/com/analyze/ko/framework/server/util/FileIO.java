package com.analyze.ko.framework.server.util;

import com.analyze.ko.framework.server.manager.DocumentFile;
import com.analyze.ko.framework.server.manager.FileManager;

import java.io.*;
import java.util.UUID;

/**
 * Created by parkjaesung on 2016. 7. 24..
 */
//singleton
public class FileIO {
    private static FileIO instance = new FileIO();

    //private constructor
    private FileIO(){

    }

    public static FileIO getInstance(){
        return instance;
    }

    public String readFile(String path) throws IOException {

        //Read from resources
        StringBuffer sb = new StringBuffer();

        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }

        return sb.toString();
    }

    public String savetoDoc(String doc){
        String currentDirectory = System.getProperty("user.dir");
        String idx = UUID.randomUUID().toString();
        String outPutFileDirectory = currentDirectory + "/KoAnalyzer-Server/src/main/resources/DataDocuments/"+ idx +".txt";

        FileManager fileManager = FileManager.getInstance();
        FileWriter fw;

        FileWriter out = null;
        try {
            out = new FileWriter(outPutFileDirectory);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            out.write(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        DocumentFile docFile = new DocumentFile();
        docFile.setIdx(idx);
        docFile.setText(doc);

        fileManager.addDocumentFile(docFile);

        return idx;
    }

}
