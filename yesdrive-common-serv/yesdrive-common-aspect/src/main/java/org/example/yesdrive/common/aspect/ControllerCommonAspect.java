package org.example.yesdrive.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.yesdrive.common.util.vo.CRVCodeEnum;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Aspect
@Component
public class ControllerCommonAspect {

    @Around(value = "@within(org.example.yesdrive.common.aspect.annotation.ControllerCut)")
    public CRVCodeEnum.ControllerResultVo cut(ProceedingJoinPoint joinPoint) {
        System.out.println("cut.........");
        try {
            joinPoint.proceed();
            return CRVCodeEnum.crateCRV(CRVCodeEnum.SUCCESS, null);
        } catch (Throwable e) {
            e.printStackTrace();
            CRVCodeEnum.ControllerResultVo crv = CRVCodeEnum.crateCRV(CRVCodeEnum.FAIL, null);
            System.out.println(crv);
            return crv;
        }
    }

}
