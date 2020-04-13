package com.jjw.springboot.jvm;

import java.lang.ref.WeakReference;

public class SoftRefence {

    public static class User {
        public int id = 0;
        public String name = "";
        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        User user = new User(18, "jjw");
        //弱引用
        WeakReference<User> weakReference = new WeakReference<>(user);
        user = null;
        System.out.println(weakReference.get());
        System.gc();//代码中尽量不要调用
        System.out.println(user);

    }
}
