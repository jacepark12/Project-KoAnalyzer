package web.searcher;

import org.junit.Assert;
import org.junit.Test;

public class ResultTest {
    @Test
    public void equals() {
        String expected = "https://www.hello.com/";
        GoogleSearcher googleSearcher = new GoogleSearcher();
        Result actual = new Result(googleSearcher.search(new Query("Hello")));
        Assert.assertEquals(expected, actual.get(0));
    }
}
