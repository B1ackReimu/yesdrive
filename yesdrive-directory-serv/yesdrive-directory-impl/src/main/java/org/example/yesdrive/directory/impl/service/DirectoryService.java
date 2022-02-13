package org.example.yesdrive.directory.impl.service;

import org.example.yesdrive.common.util.convert.ObjectConvert;
import org.example.yesdrive.directory.api.beans.DirectoryInfo;
import org.example.yesdrive.directory.api.enums.DirectoryStatus;
import org.example.yesdrive.directory.dao.DirectoryMetadataDao;
import org.example.yesdrive.directory.dao.entity.DirectoryMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DirectoryService {

    private final DirectoryMetadataDao directoryMetadataDao;

    private final ObjectConvert<DirectoryInfo, DirectoryMetadata> infoToMetaConvert = directoryInfo ->
            new DirectoryMetadata(directoryInfo.getId(), directoryInfo.getUserId(), directoryInfo.getDirectoryName(),
                    directoryInfo.getPid(), directoryInfo.getStatus(), new Date(), new Date());

    @Autowired
    public DirectoryService(DirectoryMetadataDao directoryMetadataDao) {
        this.directoryMetadataDao = directoryMetadataDao;
    }

    public void createDirectory(DirectoryInfo directoryInfo) {
        DirectoryMetadata directoryMetadata = infoToMetaConvert.convert(directoryInfo);
        directoryMetadata.setStatus(DirectoryStatus.NORMAL.getCode());
        directoryMetadata.setDirectoryName("a" + directoryMetadata.getDirectoryName());
        directoryMetadataDao.insert(directoryMetadata);
    }

}
