package org.example.yesdrive.directory.api.beans;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.yesdrive.common.api.page.Page;

import java.util.Date;

@Setter
@Getter
public class DirectoryInfo extends Page<DirectoryInfo,DirectoryInfo> {

    private Integer id;
    private Integer userId;
    private String directoryName;
    private Integer pid;
    private Integer status;
    private Date creteTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "DirectoryInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", directoryName='" + directoryName + '\'' +
                ", pid=" + pid +
                ", status=" + status +
                ", creteTime=" + creteTime +
                ", updateTime=" + updateTime +
                "} " + super.toString();
    }
}
