package org.example.yesdrive.test.pool;

import io.netty.util.Recycler;

public class PooledProcessBuilder {

    private final Recycler.Handle<PooledProcessBuilder> handle;
    private final ProcessBuilder processBuilder;

    public PooledProcessBuilder(Recycler.Handle<PooledProcessBuilder> handle) {
        this.handle = handle;
        this.processBuilder =  new ProcessBuilder();
    }

    public void recycle(){
        handle.recycle(this);
    }

    public ProcessBuilder getProcessBuilder() {
        return processBuilder;
    }
}
