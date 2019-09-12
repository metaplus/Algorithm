package core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.*;

import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: Jingxing Xu
 * @Date: 2019/9/13 17:12
 */
@DisplayName("AnnotationTestDisplayInDebugWindow")
class AnnotationTest {

    @Target(ElementType.ANNOTATION_TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Category {
        AnnotationCategory[] category();
    }

    public enum AnnotationCategory {
        GENERAL,
        SEMANTICS,
        VALIDATION,
        ETC
    }

    @Category(category = {AnnotationCategory.GENERAL, AnnotationCategory.SEMANTICS})
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface Problem {
        long index();

        String title() default "bunny";
    }

    @Problem(index = 354)
    static class LeetcodeInstance {
    }

    @Test
    void typeAnnotation() {
        Problem problem = LeetcodeInstance.class.getAnnotation(Problem.class);
        assertNotNull(problem);
        assertEquals(354, problem.index());
        assertEquals("bunny", problem.title());
    }

    @Test
    @DisplayName("typeMetaAnnotations 😱")
    void typeMetaAnnotations() {
        Problem problem = LeetcodeInstance.class.getAnnotation(Problem.class);
        assertNotNull(problem);
        Class<? extends Problem> clazzChild = problem.getClass();
        Class<? extends Annotation> clazzAnnotation = problem.annotationType();     // mark
        assertNull(clazzChild.getAnnotation(Category.class));
        {
            Category category = clazzAnnotation.getAnnotation(Category.class);
            assertNotNull(category);
            assertEquals(category.category().length, 2);
            assertArrayEquals(category.category(),
                    new AnnotationCategory[]{AnnotationCategory.GENERAL, AnnotationCategory.SEMANTICS});
        }
        Class<Problem> clazz = Problem.class;
        Category category = clazz.getAnnotation(Category.class);
        assertNotNull(category);
    }
}
