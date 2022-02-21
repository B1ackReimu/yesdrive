package org.example.yesdrive.mount.impl.pooled;

import io.netty.util.Recycler;

public class PooledProcessBuilder {

    private final Recycler<ProcessBuilderHandler> recycler;

    PooledProcessBuilder(String[] preCommand) {
        recycler = new Recycler<ProcessBuilderHandler>() {
            @Override
            protected ProcessBuilderHandler newObject(Handle<ProcessBuilderHandler> handle) {
                return new ProcessBuilderHandler(handle, preCommand);
            }
        };
    }

    public void recycler(ProcessBuilderHandler processBuilderHandler) {
        processBuilderHandler.getProcessBuilder().command().clear();
        processBuilderHandler.recycle();
    }

    public ProcessBuilderHandler getProcessBuilderHandler() {
        return recycler.get();
    }

}
