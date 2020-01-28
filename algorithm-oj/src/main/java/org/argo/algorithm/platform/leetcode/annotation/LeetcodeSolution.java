package org.argo.algorithm.platform.leetcode.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Component
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface LeetcodeSolution {
    long order();
}
