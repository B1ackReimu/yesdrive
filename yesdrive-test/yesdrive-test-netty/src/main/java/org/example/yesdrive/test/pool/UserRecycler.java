package org.example.yesdrive.test.pool;

import io.netty.util.Recycler;

public class UserRecycler {

    private static final Recycler<User> RECYCLER =  new Recycler<User>() {
        @Override
        protected User newObject(Handle<User> handle) {
            return new User(handle);
        }
    };

    public static User get(){
        return RECYCLER.get();
    }

}
