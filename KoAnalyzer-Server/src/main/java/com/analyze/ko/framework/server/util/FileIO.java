package com.analyze.ko.framework.server.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
}
