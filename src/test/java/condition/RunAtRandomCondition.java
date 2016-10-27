package condition;
import static org.junit.platform.commons.util.AnnotationUtils.findAnnotation;

import java.lang.reflect.AnnotatedElement;
import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ContainerExecutionCondition;
import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionCondition;
import org.junit.jupiter.api.extension.TestExtensionContext;

public class RunAtRandomCondition implements ContainerExecutionCondition, TestExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluate(ContainerExtensionContext context) {
        return evaluate(context.getElement());
    }

    @Override
    public ConditionEvaluationResult evaluate(TestExtensionContext context) {
        return evaluate(context.getElement());
    }

    private ConditionEvaluationResult evaluate(Optional<AnnotatedElement> element) {

        Optional<RunAtRandom> runAtRandom = findAnnotation(element, RunAtRandom.class);
        if (runAtRandom.isPresent() && new Random().nextBoolean()) {
            return ConditionEvaluationResult.disabled("Randomly disabling test");
        }

        return ConditionEvaluationResult.enabled("@RunAtRandom is not present");
    }
}
