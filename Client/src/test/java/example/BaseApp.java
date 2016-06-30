package example;

import web.searcher.GoogleSearcher;
import web.searcher.Query;
import web.Page;
import web.searcher.Result;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BaseApp {
    public static void main(String[] args) {
        GoogleSearcher searcher = new GoogleSearcher();

        Scanner scan = new Scanner(System.in);
        String keyword = scan.nextLine();
        Result urls = searcher.search(new Query(keyword));

        String currentDirectory = System.getProperty("user.dir");
        String outPutFileDirectory = currentDirectory + "/Client/src/resource/out.txt";

        FileWriter out;
        try {
            out = new FileWriter(outPutFileDirectory);
        } catch(IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        for (int i = 0; urls.hasNext(); i++) {
            String url = urls.next();
            Page page = new Page(url);
            try {
                out.write(page.mainArticle().get("content").toString());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }

        try {
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
