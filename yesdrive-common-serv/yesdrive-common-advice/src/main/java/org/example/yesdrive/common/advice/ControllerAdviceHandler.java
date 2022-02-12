package org.example.yesdrive.common.advice;

import org.example.yesdrive.common.advice.annotation.ControllerAdv;
import org.example.yesdrive.common.advice.annotation.NotAdv;
import org.example.yesdrive.common.api.page.Page;
import org.example.yesdrive.common.util.vo.CRVCodeEnum;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

@RestControllerAdvice(annotations = ControllerAdv.class)
public class ControllerAdviceHandler implements ResponseBodyAdvice<Object>, RequestBodyAdvice {

    private final Method pageAfterSet = Page.class.getMethod("afterSet");

    public ControllerAdviceHandler() throws NoSuchMethodException {
    }

    @ExceptionHandler(Exception.class)
    public CRVCodeEnum.ControllerResultVo errHandler(Exception e) {
        e.printStackTrace();
        return CRVCodeEnum.crateCRV(CRVCodeEnum.FAIL, null);
    }

    @ResponseStatus(HttpStatus.OK)
    public CRVCodeEnum.ControllerResultVo okHandler(Object o) {
        return CRVCodeEnum.crateCRV(CRVCodeEnum.SUCCESS, o);
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return !methodParameter.hasMethodAnnotation(NotAdv.class);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return CRVCodeEnum.crateCRV(CRVCodeEnum.SUCCESS, o);
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return methodParameter.getParameter().getType().getSuperclass() == Page.class;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        try {
            return doPageAfterSet(body);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            return body;
        }
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    private Object doPageAfterSet(Object page) throws InvocationTargetException, IllegalAccessException {
        pageAfterSet.invoke(page);
        return page;
    }
}
