package com.android.preference.pool

/**
 * @author: jiangshide
 * @date: 2023/3/28
 * @email: 18311271399@163.com
 * @description:
 */
class Pools<T> private constructor() {
    interface Pool<T> {
        /**
         * 从对象池中取出对象
         * @return
         */
        fun acquire(): T

        /**
         * 释放对象并放入对象池中
         * @param instance
         * @return true表示释放的对象成功放入对象池
         * @throws
         */
        fun release(instance: T): Boolean
    }

    open class SimplePool<T>(maxPoolSize: Int) : Pool<T> {
        /**
         * 存放对象的数组
         */
        private val mPool: Array<Any?>

        /**
         * 对象池内对象个数
         */
        private var mPoolSize = 0

        /**
         * 对象池的最大容量
         * @param maxPoolSize
         */
        init {
            require(maxPoolSize > 0) { "The max pool size must be > 0" }
            mPool = arrayOfNulls(maxPoolSize)
        }

        /**
         * 从mPool数组中取出mPoolSize-1位置的对象
         * @return
         */
        override fun acquire(): T {
            if (mPoolSize > 0) {
                val lastPooledIndex = mPoolSize - 1
                val instance = mPool[lastPooledIndex] as T
                mPool[lastPooledIndex] = null
                mPoolSize--
                return instance
            }
            return null!!
        }

        /**
         * 回收的对象放入mPool数组的mPoolSize位置上
         * @param instance
         * @return
         */
        override fun release(instance: T): Boolean {
            check(!isInPool(instance)) { "Already in the pool!" }
            if (mPoolSize < mPool.size) {
                mPool[mPoolSize] = instance
                mPoolSize++
                return true
            }
            return false
        }

        /**
         * 是否存在对象池中
         * @param instance
         * @return
         */
        private fun isInPool(instance: T): Boolean {
            for (i in 0 until mPoolSize) {
                if (mPool[i] === instance) {
                    return true
                }
            }
            return false
        }
    }

    class SynchronizedPool<T>
    /**
     * 对象池的最大容量
     *
     * @param maxPoolSize
     */ @JvmOverloads constructor(
        maxPoolSize: Int,
        /**
         * 同步加锁对象
         */
        private val mLock: Any = Any()
    ) :
        SimplePool<T>(maxPoolSize) {
        override fun acquire(): T {
            synchronized(mLock) { return super.acquire() }
        }

        override fun release(instance: T): Boolean {
            synchronized(mLock) { return super.release(instance) }
        }
    }
}