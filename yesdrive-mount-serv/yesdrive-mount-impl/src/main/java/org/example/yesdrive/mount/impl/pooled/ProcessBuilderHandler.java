package org.example.yesdrive.mount.impl.pooled;

import io.netty.util.Recycler;

public class ProcessBuilderHandler {

    private final Recycler.Handle<ProcessBuilderHandler> handle;
    private final ProcessBuilder processBuilder;

    public ProcessBuilderHandler(Recycler.Handle<ProcessBuilderHandler> handle, String... preCommand) {
        this.handle = handle;
        this.processBuilder = new ProcessBuilder(preCommand);
    }

    public void recycle() {
        handle.recycle(this);
    }

    public ProcessBuilder getProcessBuilder(){
        return processBuilder;
    }
}
