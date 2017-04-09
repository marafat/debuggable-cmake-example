package com.example.mylibrary;

/**
 * Created by mhdarafat on 11/8/16.
 */

public class MyLibraryManager {
    static {
        System.loadLibrary("my-native-lib");
    }

    public static native String getMsgFromNative();

    public static native void onSurfaceCreated();

    public static native void onSurfaceChanged(int width, int height);

    public static native void onDrawFrame();
}
