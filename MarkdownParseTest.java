import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() {
        String toTest =
        "[link](https://rando.org/file-name) [link2](https://google.com) [link3](rando.gov)";
 
        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://rando.org/file-name");
        expected.add("https://google.com");
        expected.add("rando.gov");
        ArrayList<String> result = MarkdownParse.getLinks(toTest);
        assertEqual(expected,result);
    }

}

