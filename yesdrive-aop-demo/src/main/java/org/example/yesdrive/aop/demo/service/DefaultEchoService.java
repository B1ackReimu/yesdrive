package org.example.yesdrive.aop.demo.service;

public class DefaultEchoService implements EchoService{
    @Override
    public String echo(String msg) {
        return msg;
    }
}
