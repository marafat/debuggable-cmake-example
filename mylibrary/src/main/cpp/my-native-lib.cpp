#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_mylibrary_MyLibraryManager_getMsgFromNative(JNIEnv *env, jobject instance) {

    // To test debugging, try stepping through
    int a = 2, b = 5;
    int c = a * b;

    std::string msg = "Hello From Native";

    return env->NewStringUTF(msg.c_str());
}
