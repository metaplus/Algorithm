package annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Problem {

    int index();

    Class<?> solution();

    String description() default "";

    String category() default "";
}
