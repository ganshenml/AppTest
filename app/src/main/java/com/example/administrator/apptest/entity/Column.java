package com.example.administrator.apptest.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by liqiang on 2016/3/15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Column {
    boolean id() default false;
    String name() default "";
    ColumnType type() default ColumnType.UNKNOWN;
    boolean autofresh() default false;
    public enum ColumnType{
    TONE, TOMANY, SERIALIZABLE, UNKNOWN
    }
}
