package condition;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class RandomTest {

    @RunAtRandom
    @Test
    public void runMe() {
        assertThat(true).isFalse();
    }
}
