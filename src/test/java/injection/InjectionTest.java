package injection;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@UseResolvers
public class InjectionTest {

    @Test
    @DisplayName("Myself")
    public void testMe(TestInfo testInfo) {
        assertThat(testInfo.getDisplayName()).isEqualTo("Myself");
    }

    @Test
    public void defaultUser(User user) {
        assertThat(user.getName()).isEqualTo("Foo Bar");
        assertThat(user.getPhoneNumer()).isNull();
    }

    @Test
    public void fullUser(@Full User user) {
        assertThat(user.getName()).isEqualTo("Foo Bar");
        assertThat(user.getPhoneNumer()).isEqualTo("123456789");
    }
}
