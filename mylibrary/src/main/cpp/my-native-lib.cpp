#include <jni.h>
#include <string>
#include <NativeSubmodule.h>

extern "C" JNIEXPORT void JNICALL
Java_com_example_mylibrary_MyLibraryManager_onSurfaceChanged(JNIEnv *env, jclass type, jint width,
                                                             jint height) {

    on_surface_changed(width, height);

}

extern "C" JNIEXPORT void JNICALL
Java_com_example_mylibrary_MyLibraryManager_onDrawFrame(JNIEnv *env, jclass type) {

    on_draw_frame();

}

extern "C" JNIEXPORT void JNICALL
Java_com_example_mylibrary_MyLibraryManager_onSurfaceCreated(JNIEnv *env, jclass type) {

    on_surface_created();

}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_mylibrary_MyLibraryManager_getMsgFromNative(JNIEnv *env, jobject instance) {

    // To test debugging, try stepping through
    int a = 2, b = 5;
    int c = a * b;

    std::string msg = "Hello From Native";

    // test native submodule
    msg.append(getMsgFromNativeSubmodule());

    return env->NewStringUTF(msg.c_str());
}
