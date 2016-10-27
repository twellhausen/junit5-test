package injection;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.platform.commons.util.AnnotationUtils;

public class UserParameterResolver implements ParameterResolver {

    @Override
    public boolean supports(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == User.class;
    }

    @Override
    public Object resolve(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        User user = new User();
        user.setName("Foo Bar");
        if (AnnotationUtils.isAnnotated(parameterContext.getParameter(), Full.class)) {
            user.setPhoneNumer("123456789");
        }
        return user;
    }
}
