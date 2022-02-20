package org.example.yesdrive.test.pool;

import io.netty.util.Recycler;

public class ProcessBuilderRecycler {

    private static final Recycler<PooledProcessBuilder> RECYCLER = new Recycler<PooledProcessBuilder>() {
        @Override
        protected PooledProcessBuilder newObject(Handle<PooledProcessBuilder> handle) {
            return new PooledProcessBuilder(handle);
        }
    };

    public static PooledProcessBuilder get(){
        return RECYCLER.get();
    }

}
