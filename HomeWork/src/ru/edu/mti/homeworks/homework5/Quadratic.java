package ru.edu.mti.homeworks.homework5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация говорит, что матрица квадратная
 * @author Белых Евгений
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.CONSTRUCTOR)
public @interface Quadratic {
	boolean isQuadratic() default true;
	int m() default 3;
	int n() default 3;
}
