package org.example.yesdrive.aop.demo.service;

public class ProxyEchoService implements EchoService{

    private final EchoService echoService;

    public ProxyEchoService(EchoService echoService) {
        this.echoService = echoService;
    }

    @Override
    public String echo(String msg) {
        System.out.println("proxy start");
        echoService.echo(msg);
        return msg;
    }
}
