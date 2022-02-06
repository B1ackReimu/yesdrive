package org.example.yesdrive.directory.dao;

import org.example.yesdrive.directory.dao.entity.DirectoryMetadata;

public interface DirectoryMetadataDao {
    int deleteByPrimaryKey(Integer id);

    int insert(DirectoryMetadata record);

    int insertSelective(DirectoryMetadata record);

    DirectoryMetadata selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DirectoryMetadata record);

    int updateByPrimaryKey(DirectoryMetadata record);
}