package annotation;

import java.lang.annotation.*;

/**
 * @Author: Jingxing Xu
 * @Date: 2019/9/13 20:06
 */


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Problem {

    int index();

    Class<?> solution();

    String description() default "";

    String category() default "";
}