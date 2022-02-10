package org.example.yesdrive.directory.api.beans;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class DirectoryInfo {

    private int id;
    private int userId;
    private String directoryName;
    private int pid;
    private int status;
    private Date creteTime;
    private Date updateTime;

}
