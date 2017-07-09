#include <jni.h>

extern "C" {

#ifndef MYAPPLICATION_NATIVE_H
#define MYAPPLICATION_NATIVE_H

JNIEXPORT jdouble JNICALL
Java_com_example_felipe_myapplication_services_ProcessValueTask_callbackToNative(JNIEnv *,
                                                                                 jobject,
                                                                                 jdouble);

#endif //MYAPPLICATION_NATIVE_H
}
