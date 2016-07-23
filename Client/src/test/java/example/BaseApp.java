package example;

import web.searcher.GoogleSearcher;
import web.searcher.Query;
import web.Page;
import web.searcher.Result;

import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class BaseApp {
    public static void main(String[] args) {
        String currentDirectory = System.getProperty("user.dir");
        String outPutFileDirectory = currentDirectory + "/Client/src/main/resources/out.txt";

        FileWriter out;
        try {
            out = new FileWriter(outPutFileDirectory);
        } catch(IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        GoogleSearcher searcher = new GoogleSearcher();
        Result urls = searcher.search(new Query("sample_keyword"));
        try {
            for (int i = 0; urls.hasNext(); i++) {
                Page page = new Page(urls.next());
                out.write(page.mainArticle().withoutTags().toString());
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        try {
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
