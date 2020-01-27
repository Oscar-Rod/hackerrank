package utilsTest;

import org.junit.jupiter.api.Test;
import utils.Utils;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {

    @Test
    public void should_generate_substrings() {
        Set<String> substrings = Utils.generateAllSubStrings("abc", 1);
        assertThat(substrings).containsExactlyInAnyOrder("a", "b", "c");
    }

    @Test
    public void should_generate_substrings1() {
        Set<String> substrings = Utils.generateAllSubStrings("abc", 2);
        assertThat(substrings).containsExactlyInAnyOrder("a", "b", "c", "ab", "bc");
    }

    @Test
    public void should_generate_substrings2() {
        Set<String> substrings = Utils.generateAllSubStrings("abc", 3);
        assertThat(substrings).containsExactlyInAnyOrder("a", "b", "c", "ab", "bc", "abc");
    }

    @Test
    public void should_generate_substrings3() {
        Set<String> substrings = Utils.generateAllSubStrings("abc", 4);
        assertThat(substrings).containsExactlyInAnyOrder("a", "b", "c", "ab", "bc", "abc");
    }
}
