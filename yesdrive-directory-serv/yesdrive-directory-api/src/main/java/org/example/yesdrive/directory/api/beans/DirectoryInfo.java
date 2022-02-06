package org.example.yesdrive.directory.api.beans;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class DirectoryInfo {

    private int directoryId;
    private int userId;
    private String directoryName;
    private int parentId;
    private int status;
    private Date creteTime;
    private Date updateTime;

}
