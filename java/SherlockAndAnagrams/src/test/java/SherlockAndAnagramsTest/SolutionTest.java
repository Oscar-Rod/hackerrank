package SherlockAndAnagramsTest;

import SherlockAndAnagrams.Solution;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class SolutionTest {

    private static Stream<Arguments> testProvider() {
        return Stream.of(
                Arguments.of("abba", 4),
                Arguments.of("abcd", 0),
                Arguments.of("ifailuhkqq", 3),
                Arguments.of("kkkk", 10),
                Arguments.of("cdcd", 5),
                Arguments.of("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 166650),
                Arguments.of("bbcaadacaacbdddcdbddaddabcccdaaadcadcbddadababdaaabcccdcdaacadcababbabbdbacabbdcbbbbbddacdbbcdddbaaa", 4832),
                Arguments.of("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 166650),
                Arguments.of("cacccbbcaaccbaacbbbcaaaababcacbbababbaacabccccaaaacbcababcbaaaaaacbacbccabcabbaaacabccbabccabbabcbba", 13022),
                Arguments.of("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 166650),
                Arguments.of("bbcbacaabacacaaacbbcaabccacbaaaabbcaaaaaaaccaccabcacabbbbabbbbacaaccbabbccccaacccccabcabaacaabbcbaca", 9644),
                Arguments.of("cbaacdbaadbabbdbbaabddbdabbbccbdaccdbbdacdcabdbacbcadbbbbacbdabddcaccbbacbcadcdcabaabdbaacdccbbabbbc", 6346),
                Arguments.of("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 166650),
                Arguments.of("babacaccaaabaaaaaaaccaaaccaaccabcbbbabccbbabababccaabcccacccaaabaccbccccbaacbcaacbcaaaaaaabacbcbbbcc", 8640),
                Arguments.of("bcbabbaccacbacaacbbaccbcbccbaaaabbbcaccaacaccbabcbabccacbaabbaaaabbbcbbbbbaababacacbcaabbcbcbcabbaba", 11577)
        );
    }

    @ParameterizedTest
    @MethodSource("testProvider")
    public void should_work1(String input, int correctSolution) {
        int solution = Solution.sherlockAndAnagrams(input);
        Assertions.assertThat(solution).isEqualTo(correctSolution);
    }
}
