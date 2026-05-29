package com.dupas.fy.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import java.lang.reflect.Method;

public class CheckMethodStatus {

  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.RUNTIME)
  public @interface IsLogged {
    boolean logStatus() default false;
  }

  public boolean checkLogin(Method m) {
    if (m.isAnnotationPresent(IsLogged.class)) {
      IsLogged stats = m.getAnnotation(IsLogged.class);
      return stats.logStatus();
    }
    return false;
  }

}
