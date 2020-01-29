package utilsTest;

import org.junit.jupiter.api.Test;
import utils.Utils;

import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {

    @Test
    public void should_generate_substrings() {
        Map<String, Integer> substrings = Utils.generateAllSubStrings("abc", 1);
        assertThat(substrings).containsOnlyKeys("a", "b", "c");
    }

    @Test
    public void should_generate_substrings1() {
        Map<String, Integer> substrings = Utils.generateAllSubStrings("abc", 2);
        assertThat(substrings).containsOnlyKeys("a", "b", "c", "ab", "bc");
    }

    @Test
    public void should_generate_substrings2() {
        Map<String, Integer> substrings = Utils.generateAllSubStrings("abc", 3);
        assertThat(substrings).containsOnlyKeys("a", "b", "c", "ab", "bc", "abc");
    }

    @Test
    public void should_generate_substrings3() {
        Map<String, Integer> substrings = Utils.generateAllSubStrings("abc", 4);
        assertThat(substrings).containsOnlyKeys("a", "b", "c", "ab", "bc", "abc");
    }

    @Test
    public void should_generate_substrings4() {
        Map<String, Integer> substrings = Utils.generateAllSubStrings("aaa", 2);
        assertThat(substrings).containsOnlyKeys("a", "aa");
        assertThat(substrings.get("a")).isEqualTo(3);
        assertThat(substrings.get("aa")).isEqualTo(2);
    }

}
