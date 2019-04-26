package jmdbtutorial.gitg;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SimpleTest {

    @Test
    public void one_plus_one_should_equal_two() {
        int result = 1 + 1;

        assertThat(result, is(2));
    }
}
