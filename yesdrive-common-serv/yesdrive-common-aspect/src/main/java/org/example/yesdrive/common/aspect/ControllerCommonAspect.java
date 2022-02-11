package org.example.yesdrive.common.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.lang.annotation.Annotation;

@Aspect
public class ControllerCommonAspect {


    @Around(value = "@within(withinAnnotation)")
    public void cut(){

    }

}
