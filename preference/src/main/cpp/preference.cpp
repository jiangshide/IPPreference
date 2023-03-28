#include <jni.h>
#include <string>

//extern "C" JNIEXPORT jstring JNICALL
//Java_com_android_preference_NativeLib_stringFromJNI(
//        JNIEnv* env,
//        jobject /* this */) {
//    std::string hello = "Hello from C++";
//    return env->NewStringUTF(hello.c_str());
//}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_android_preference_pool_PreferenceParcel_stringFromJNI(JNIEnv *env, jobject thiz) {
    std::string hello = "The IP Preference From C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jlong JNICALL
Java_com_android_preference_pool_PreferenceParcel_nativeCreate(JNIEnv *env, jobject thiz) {
    // TODO: implement nativeCreate()
}
extern "C"
JNIEXPORT void JNICALL
Java_com_android_preference_pool_PreferenceParcel_nativeWriteInt(JNIEnv *env, jobject thiz,
                                                                 jlong native_ptr, jint val) {
    // TODO: implement nativeWriteInt()
}
extern "C"
JNIEXPORT void JNICALL
Java_com_android_preference_pool_PreferenceParcel_nativeSetDataPosition(JNIEnv *env, jobject thiz,
                                                                        jlong native_ptr,
                                                                        jint pos) {
    // TODO: implement nativeSetDataPosition()
}
extern "C"
JNIEXPORT jint JNICALL
Java_com_android_preference_pool_PreferenceParcel_nativeReadInt(JNIEnv *env, jobject thiz,
                                                                jlong native_ptr) {
    // TODO: implement nativeReadInt()
}
