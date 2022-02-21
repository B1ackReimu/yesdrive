package org.example.yesdrive.mount.impl.executor;

import org.example.yesdrive.mount.impl.pooled.PooledProcessBuilder;
import org.example.yesdrive.mount.impl.pooled.ProcessBuilderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Component
public class CommandExecutor {

    private PooledProcessBuilder pooledProcessBuilder;

    @Autowired
    public void setPooledProcessBuilder(PooledProcessBuilder pooledProcessBuilder) {
        this.pooledProcessBuilder = pooledProcessBuilder;
    }

    public InputStream executeStd(String... command) throws IOException {
        ProcessBuilderHandler processBuilderHandler = pooledProcessBuilder.getProcessBuilderHandler();
        ProcessBuilder processBuilder = processBuilderHandler.getProcessBuilder();
        Process process = processBuilder.command(command).start();
        pooledProcessBuilder.recycler(processBuilderHandler);
        return process.getInputStream();
    }


}
