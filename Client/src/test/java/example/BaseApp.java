package example;

import web.searcher.GoogleSearcher;
import web.searcher.Query;
import web.Page;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BaseApp {
    public static void main(String[] args) {
        //Todo: Proper Exception Handling, or just throw exception.
        GoogleSearcher searcher = new GoogleSearcher();

        Scanner scan = new Scanner(System.in);
        String keyword = scan.nextLine();
        List<List<String>> urls = searcher.search(new Query(keyword));

        String currentDirectory = System.getProperty("user.dir");
        String outPutFileDirectory = currentDirectory + "/Client/src/resource/out.txt";

        FileWriter out = null;
        try {
            out = new FileWriter(outPutFileDirectory);
        } catch(IOException e) {
            System.out.println(e);
            return;
        }

        for (String url : urls.get(0)) {
            Page page = new Page(url);
            try {
                out.write(page.mainArticle().get("content").toString());
            } catch (Exception e) {
                System.out.println(e);
                break;
            }
        }

        try {
            out.close();
        } catch (IOException e) {
            System.out.println(e);
            return;
        }

    }
}
