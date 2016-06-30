package web.searcher;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ResultTest {
    private List<String> expected;

    @Before
    public void setUp() {
        expected = new ArrayList<>();
        expected.add("A");
        expected.add("B");
    }

    @Test
    public void next() {
        Result result = new Result(expected);
        Assert.assertEquals(expected.get(0), result.next());
        Assert.assertEquals(expected.get(1), result.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void nextException() {
        Result result = new Result(expected);
        for (int i = 0; i <= expected.size(); i++) {
            result.next();
        }
    }

    @Test
    public void hasNext() {
        Result result = new Result(expected);
        result.next();
        result.next();

        Assert.assertFalse(result.hasNext());
    }
}
