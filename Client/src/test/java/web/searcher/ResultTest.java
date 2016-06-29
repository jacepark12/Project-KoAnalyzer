package web.searcher;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ResultTest {
    @Test
    public void next() {
        List<String> data = new ArrayList<String>();
        data.add("A");
        data.add("B");

        Result result = new Result(data);
        Assert.assertEquals(data.get(0), result.next());
        Assert.assertEquals(data.get(1), result.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void nextException() {
        List<String> data = new ArrayList<String>();
        data.add("A");

        Result result = new Result(data);
        result.next();
        result.next();
    }

    @Test
    public void hasNext() {
        List<String> data = new ArrayList<String>();
        data.add("A");

        Result result = new Result(data);
        result.next();

        Assert.assertFalse(result.hasNext());
    }
}
