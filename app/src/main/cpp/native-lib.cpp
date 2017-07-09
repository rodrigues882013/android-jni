#include <jni.h>
#include "native.h"

JNIEXPORT jdouble JNICALL
Java_com_example_felipe_myapplication_services_ProcessValueTask_callbackToNative(JNIEnv *env,
                                                                                jobject obj,
                                                                                jdouble num1) {
    //Doing something
    return num1;
}
