package web.searcher;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ResultTest {
    @Test
    public void equals() {
        String expected = "https://www.hello.com/";
        GoogleSearcher googleSearcher = new GoogleSearcher();
        Result actual = googleSearcher.search(new Query("Hello"));
        Assert.assertEquals(expected, actual.get(0));
    }

    @Test
    public void has() {
        ArrayList<String> data = new ArrayList<String>();
        data.add("1");
        Result result = new Result(data);
        Assert.assertFalse(result.has(1));
    }
}
