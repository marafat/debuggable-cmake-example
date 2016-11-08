package com.example.mylibrary;

/**
 * Created by mhdarafat on 11/8/16.
 */

public class MyLibraryManager {
    private static MyLibraryManager ourInstance = new MyLibraryManager();

    public static MyLibraryManager getInstance() {
        return ourInstance;
    }

    private MyLibraryManager() {
    }

    static {
        System.loadLibrary("my-native-lib");
    }

    public native String getMsgFromNative();
}
