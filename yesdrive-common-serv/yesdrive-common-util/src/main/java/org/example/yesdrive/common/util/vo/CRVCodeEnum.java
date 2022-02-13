package org.example.yesdrive.common.util.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
public enum CRVCodeEnum {

    SUCCESS(0b1, "success"), FAIL(0b10, "fail"),
    AUTH_FAIL(0b100, "auth_check_fail");
    private final int code;
    private final String description;

    public static ControllerResultVo crateCRV(CRVCodeEnum crvCodeEnum, Object o) {
        return new ControllerResultVo(crvCodeEnum.code, crvCodeEnum.description, o);
    }

    @AllArgsConstructor
    @Getter
    @ToString
    public static class ControllerResultVo {
        private int code;
        private String msg;
        private Object data;
    }

}
