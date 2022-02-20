package org.example.yesdrive.test.pool;

import io.netty.util.Recycler;

public class User {

    private final Recycler.Handle<User> handle;

    public User(Recycler.Handle<User> handle) {
        this.handle = handle;
    }

    public void recycle() {
        handle.recycle(this);
    }

    public void sout(){
        System.out.println(Thread.currentThread().getName());
    }
}
