package org.example.yesdrive.common.util.vo;

public class Test {

    public static void main(String[] args) {
        CRVCodeEnum.ControllerResultVo controllerResultVo
                = CRVCodeEnum.crateCRV(CRVCodeEnum.SUCCESS, null);
        System.out.println(controllerResultVo);
    }

}
