package web;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DocumentTest {
    @Test
    public void fromString() {
        String expected = "Hello, World!";
        Document result = Document.fromString("Hello, World!");
        assertEquals(expected, result.raw());
    }

    @Test
    public void withoutTags() {
        //TODO: Replace <br> with \n.
        Document expected = Document.fromString("Sentence 1Sentence 2");
        Document with = Document.fromString(
            "<div id=\"id\"><p>Sentence 1<br>Sentence 2</p></div>"
        );
        Document without = with.withoutTags();
        assertEquals(expected.raw(), without.raw());
    }
}
