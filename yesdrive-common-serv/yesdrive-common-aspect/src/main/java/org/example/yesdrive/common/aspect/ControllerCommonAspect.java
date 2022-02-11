package org.example.yesdrive.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.yesdrive.common.util.vo.CRVCodeEnum;

import java.lang.annotation.Annotation;

@Aspect
public class ControllerCommonAspect {

    @Around(value = "@within(org.example.yesdrive.common.annotation.ControllerCut)")
    public CRVCodeEnum.ControllerResultVo cut(ProceedingJoinPoint joinPoint) {
        try {
            joinPoint.proceed();
            return CRVCodeEnum.crateCRV(CRVCodeEnum.SUCCESS, null);
        } catch (Throwable e) {
            e.printStackTrace();
            return CRVCodeEnum.crateCRV(CRVCodeEnum.FAIL, null);
        }
    }

}
