package com.jianghaike.ddd.controller;

import java.lang.annotation.*;

/**
 * @author jianghaike
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface ResponseResult {
}
