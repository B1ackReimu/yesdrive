package org.example.yesdrive.mount.impl.executor;

import org.example.yesdrive.mount.impl.pooled.PooledProcessBuilder;
import org.example.yesdrive.mount.impl.pooled.ProcessBuilderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandExecutor {

    private PooledProcessBuilder pooledProcessBuilder;

    @Autowired
    public void setPooledProcessBuilder(PooledProcessBuilder pooledProcessBuilder) {
        this.pooledProcessBuilder = pooledProcessBuilder;
    }

    public void execute(String... command) throws IOException {
        ProcessBuilderHandler processBuilderHandler = pooledProcessBuilder.getProcessBuilderHandler();
        processBuilderHandler.getProcessBuilder().command(command).start();
    }
}
