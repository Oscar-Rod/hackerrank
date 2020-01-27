package TwoStringsTest;

import TwoStrings.Solution;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void should_return_yes() {
        String solution = Solution.twoStrings("hello", "world");
        assertThat(solution).isEqualTo("YES");
    }

    @Test
    public void should_return_now() {
        String solution = Solution.twoStrings("hi", "world");
        assertThat(solution).isEqualTo("NO");
    }
}
