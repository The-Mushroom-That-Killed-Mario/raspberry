/*
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: JNI Native Library
 * FILENAME      :  com_pi4j_wiringpi_GpioUtil.h
 * 
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2021 Pi4J
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_pi4j_wiringpi_GpioUtil */

#ifndef _Included_com_pi4j_wiringpi_GpioUtil
#define _Included_com_pi4j_wiringpi_GpioUtil
#ifdef __cplusplus
extern "C" {
#endif
#undef com_pi4j_wiringpi_GpioUtil_DIRECTION_IN
#define com_pi4j_wiringpi_GpioUtil_DIRECTION_IN 0L
#undef com_pi4j_wiringpi_GpioUtil_DIRECTION_OUT
#define com_pi4j_wiringpi_GpioUtil_DIRECTION_OUT 1L
#undef com_pi4j_wiringpi_GpioUtil_DIRECTION_HIGH
#define com_pi4j_wiringpi_GpioUtil_DIRECTION_HIGH 2L
#undef com_pi4j_wiringpi_GpioUtil_DIRECTION_LOW
#define com_pi4j_wiringpi_GpioUtil_DIRECTION_LOW 3L
#undef com_pi4j_wiringpi_GpioUtil_EDGE_NONE
#define com_pi4j_wiringpi_GpioUtil_EDGE_NONE 0L
#undef com_pi4j_wiringpi_GpioUtil_EDGE_BOTH
#define com_pi4j_wiringpi_GpioUtil_EDGE_BOTH 1L
#undef com_pi4j_wiringpi_GpioUtil_EDGE_RISING
#define com_pi4j_wiringpi_GpioUtil_EDGE_RISING 2L
#undef com_pi4j_wiringpi_GpioUtil_EDGE_FALLING
#define com_pi4j_wiringpi_GpioUtil_EDGE_FALLING 3L
/*
 * Class:     com_pi4j_wiringpi_GpioUtil
 * Method:    export
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_pi4j_wiringpi_GpioUtil_export
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_pi4j_wiringpi_GpioUtil
 * Method:    unexport
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_pi4j_wiringpi_GpioUtil_unexport
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_pi4j_wiringpi_GpioUtil
 * Method:    isExported
 * Signature: (I)Z
 */
JNIEXPORT jboolean JNICALL Java_com_pi4j_wiringpi_GpioUtil_isExported
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_pi4j_wiringpi_GpioUtil
 * Method:    setEdgeDetection
 * Signature: (II)Z
 */
JNIEXPORT jboolean JNICALL Java_com_pi4j_wiringpi_GpioUtil_setEdgeDetection
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_pi4j_wiringpi_GpioUtil
 * Method:    getEdgeDetection
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_pi4j_wiringpi_GpioUtil_getEdgeDetection
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_pi4j_wiringpi_GpioUtil
 * Method:    setDirection
 * Signature: (II)Z
 */
JNIEXPORT jboolean JNICALL Java_com_pi4j_wiringpi_GpioUtil_setDirection
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_pi4j_wiringpi_GpioUtil
 * Method:    getDirection
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_pi4j_wiringpi_GpioUtil_getDirection
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_pi4j_wiringpi_GpioUtil
 * Method:    isPinSupported
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_pi4j_wiringpi_GpioUtil_isPinSupported
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_pi4j_wiringpi_GpioUtil
 * Method:    isPrivilegedAccessRequired
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_com_pi4j_wiringpi_GpioUtil_isPrivilegedAccessRequired
  (JNIEnv *, jclass);

/*
 * Class:     com_pi4j_wiringpi_GpioUtil
 * Method:    enableNonPrivilegedAccess
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_pi4j_wiringpi_GpioUtil_enableNonPrivilegedAccess
  (JNIEnv *, jclass);

#ifdef __cplusplus
}
#endif
#endif