package newYearChaosTest;

import newYearChaos.Solution;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void shouldWork() {
        String solution = Solution.minimumBribes(new int[]{2, 1, 5, 3, 4});
        Assertions.assertThat(solution).isEqualTo("3");
    }

    @Test
    public void shouldWork1() {
        String solution = Solution.minimumBribes(new int[]{2, 5, 1, 3, 4});
        Assertions.assertThat(solution).isEqualTo("Too chaotic");
    }

    @Test
    public void shouldWork2() {
        String solution = Solution.minimumBribes(new int[]{5, 1, 2, 3, 7, 8, 6, 4});
        Assertions.assertThat(solution).isEqualTo("Too chaotic");
    }

    @Test
    public void shouldWork3() {
        String solution = Solution.minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4});
        Assertions.assertThat(solution).isEqualTo("7");
    }

    @Test
    public void shouldWork4() {
        String solution = Solution.minimumBribes(new int[]{1, 2, 5, 3, 4, 7, 8, 6});
        Assertions.assertThat(solution).isEqualTo("4");
    }

}
