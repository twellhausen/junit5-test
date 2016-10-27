package nested;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@DisplayName("A list")
public class TestingAList {

    private List<String> list;

    @BeforeEach
    public void init() {
        list = new ArrayList<>();
    }

    @Nested
    @DisplayName("when it is created")
    public class WhenNew {

        @Test
        @DisplayName("is empty")
        public void empty() {
            assertThat(list).isEmpty();
        }

        @Test
        @DisplayName("something can be added")
        public void add() {
            list.add("something");
            assertThat(list).containsOnly("something");
        }
    }

    @Nested
    @DisplayName("when it already contains something")
    public class WhenNotEmpty {

        @BeforeEach
        public void setup() {
            list.add("something");
        }

        @Test
        @DisplayName("something can be removed")
        public void remove() {
            list.remove("something");
            assertThat(list).isEmpty();
        }

        @Test
        @DisplayName("anything can be added")
        public void addMore() {
            list.add("anything");
            assertThat(list).containsExactly("something", "anything");
        }
    }
}
