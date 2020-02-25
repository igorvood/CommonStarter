package ru.vood.commonstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.jdbc.core.JdbcOperations;

public class OnTableExistsConditional implements Condition {

//    @Autowired
//    private final JdbcOperations jdbcOperations;

//    public OnTableExistsConditional(JdbcOperations jdbcOperations) {
//        this.jdbcOperations = jdbcOperations;
//    }

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        jdbcTemplate
        return false;
    }
}
