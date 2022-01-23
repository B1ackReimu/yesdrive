package org.example.yesdrive.aop.demo.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicProxyDemo {

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Object proxyInstance = Proxy.newProxyInstance(classLoader, new Class[]{EchoService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                ProxyEchoService proxyEchoService = new ProxyEchoService(new DefaultEchoService());
                return proxyEchoService.echo((String) args[0]);
            }
        });
        EchoService echoService = (EchoService) proxyInstance;
        String aaa = echoService.echo("aaa");
        System.out.println(aaa);
    }

}
