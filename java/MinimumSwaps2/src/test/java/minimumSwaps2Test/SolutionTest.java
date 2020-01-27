package minimumSwaps2Test;

import minimumSwaps2.Solution;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void should_work() {
        int solution = Solution.minimumSwaps(new int[]{4, 3, 1, 2});
        assertThat(solution).isEqualTo(3);
    }

    @Test
    public void should_work1() {
        int solution = Solution.minimumSwaps(new int[]{2, 3, 4, 1, 5});
        assertThat(solution).isEqualTo(3);
    }

    @Test
    public void should_work2() {
        int solution = Solution.minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 7});
        assertThat(solution).isEqualTo(3);
    }

}
