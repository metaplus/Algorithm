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

    Class<?> solution() default Object.class;

    String description() default "";

    String title() default "";
}