package com.wang.httpparam;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface PostFile {

    /**
     *the post file key. the field type is map is invalid
     */
    String key() default "";

}
