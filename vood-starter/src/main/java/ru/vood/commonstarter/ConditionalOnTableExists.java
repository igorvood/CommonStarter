package ru.vood.commonstarter;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnTableExistsConditional.class)
public @interface ConditionalOnTableExists {
}
