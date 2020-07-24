#include <jni.h>
#include <stdio.h>
/*
Java에서  c언어를
*/
JNIEXPORT jstring JNICALL
Java_com_example_demo_nativeinterface_test_HelloSpring_print(JNIEnv *env, jobject obj)
{
    char msg[60] = "Hello C Language with Java!";쓸
//    jstring : 자바와 C가 함께 사용하는 문자열
    jstring result;

    result = (*env)->NewStringUTF(env, msg);
    return result;
}