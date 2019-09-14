package core;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @Author: Jingxing Xu
 * @Date: 2019/9/13 19:49
 */
class InheritanceTest {

    final Logger logger = LoggerFactory.getLogger(InheritanceTest.class);

    abstract static class A {
        Class<? extends A> clazz = this.getClass();

        A() {
            assertEquals(clazz.getName(), clazz.getTypeName());
        }

        final String getName() {
            return clazz.getName();
        }

        final String getSimpleName() {
            return clazz.getSimpleName();
        }
    }

    private static class B extends A {
    }

    private static class C extends A {
    }

    @Test
    void subClassNameFromSuperClass() {
        B b = new B();
        C c = new C();
        assertEquals(b.getName(), "core.InheritanceTest$B");
        assertEquals(c.getName(), "core.InheritanceTest$C");
        assertEquals(b.getSimpleName(), "B");
        assertEquals(c.getSimpleName(), "C");
    }
}
