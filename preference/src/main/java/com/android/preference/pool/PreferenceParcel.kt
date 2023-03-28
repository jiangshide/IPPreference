package com.android.preference.pool

/**
 * @author: jiangshide
 * @date: 2023/3/28
 * @email: 18311271399@163.com
 * @description:
 */
class PreferenceParcel private constructor(
    /**
     * 上层保存底层的preference.cpp对象地址
     */
    private var mNativePtr: Long
) {
    init {
        mNativePtr = nativeCreate()
    }

    fun setDataPosition(pos: Int) {
        nativeSetDataPosition(mNativePtr, pos)
    }

    public object MyObject {
        val PARCEL = PreferenceParcel(0)
    }

    fun writeInt(`val`: Int) {
        nativeWriteInt(mNativePtr, `val`)
    }

    fun readInt(): Int {
        return nativeReadInt(mNativePtr)
    }

    /**
     * A native method that is implemented by the 'preference' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    /**
     * 在native层构建preference.cpp对象指针地址
     * @return
     */
    private external fun nativeCreate(): Long

    /**
     * 写入int值到指针上
     * @param nativePtr
     * @param val
     */
    private external fun nativeWriteInt(nativePtr: Long, `val`: Int)

    /**
     * 设置mDataPos = 0为了下次从0的位置开始读
     * @param nativePtr
     * @param pos
     */
    private external fun nativeSetDataPosition(nativePtr: Long, pos: Int)

    /**
     * 指针上读取int值
     * @param nativePtr
     * @return
     */
    private external fun nativeReadInt(nativePtr: Long): Int

    companion object {
        init {
            System.loadLibrary("preference")
        }

        fun obtain(): PreferenceParcel {
            return MyObject.PARCEL
        }
    }
}