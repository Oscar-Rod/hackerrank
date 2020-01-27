package ArrayManipulationTest;

import ArrayManipulation.Solution;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void should_work() {
        long solution = Solution.arrayManipulation(5, new int[][]{{1, 2, 100}, {2, 5, 100}, {3, 4, 100}});
        Assertions.assertThat(solution).isEqualTo(200);
    }

    @Test
    public void should_work1() {
        long solution = Solution.arrayManipulation(4, new int[][]{{2, 3, 603}, {1, 1, 286}, {4, 4, 882}});
        Assertions.assertThat(solution).isEqualTo(882);
    }
}
