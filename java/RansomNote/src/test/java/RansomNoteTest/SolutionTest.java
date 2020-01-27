package RansomNoteTest;

import RansomNote.Solution;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void should_work(){
        String[] magazine = new String[]{"give", "me", "one", "grand", "today", "night"};
        String[] note = new String[]{"give", "one", "grand", "today"};
        String solution = Solution.checkMagazine(magazine, note);
        Assertions.assertThat(solution).isEqualTo("Yes");
    }

    @Test
    public void should_work1(){
        String[] magazine = new String[]{"o", "l", "x", "imjaw", "bee", "khmla", "v", "o", "v", "o", "imjaw", "l", "khmla", "imjaw", "x"};
        String[] note = new String[]{"imjaw", "l", "khmla", "x", "imjaw", "o", "l", "l", "o", "khmla", "v", "bee", "o", "o", "imjaw", "imjaw", "o",};
        String solution = Solution.checkMagazine(magazine, note);
        Assertions.assertThat(solution).isEqualTo("No");
    }
}
