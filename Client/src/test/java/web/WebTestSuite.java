package web;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import web.searcher.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        GoogleSearcherTest.class,
        QueryTest.class,
        DocumentTest.class,
        ResultTest.class,
})

/**
 * Created by JunHo Seo on 2016-06-28.
 */
public class WebTestSuite {
}
