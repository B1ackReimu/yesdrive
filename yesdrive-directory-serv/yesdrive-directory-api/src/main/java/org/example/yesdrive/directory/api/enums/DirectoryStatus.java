package org.example.yesdrive.directory.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum DirectoryStatus {
    UNKNOWN(0b1, "未知"), NORMAL(0b10, "正常"), STAR(0b100, "星标"),
    RECYCLE_BIN(0b1000, "回收站"), SHARE(0b10000, "分享"),
    STAR_AND_SHARE(STAR.code + SHARE.code, "星标+分享");

    private final int code;
    private final String description;

    public static DirectoryStatus convert(int code) {
        return Stream.of(values()).filter(bean -> bean.code == code).findFirst().orElse(UNKNOWN);
    }

}
