package org.example.yesdrive.directory.dao.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * directory_metadata
 * @author 
 */
@Data
public class DirectoryMetadata implements Serializable {
    private Integer id;

    private Integer userId;

    private String directoryName;

    private Integer pid;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}