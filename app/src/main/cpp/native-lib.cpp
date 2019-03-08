#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_zhxh_xsourcstudy_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "源码学习总结";
    return env->NewStringUTF(hello.c_str());
}
