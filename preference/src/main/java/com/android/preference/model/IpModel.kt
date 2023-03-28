package com.android.preference.model

/**
 * @author: jiangshide
 * @date: 2023/3/28
 * @email: 18311271399@163.com
 * @description:
 */
data class IpModel(

    /**
     * 主机地址
     */
    val host:String,

    /**
     * 探测优先级
     */
    val level:Int,

    /**
     * 探测类型
     */
    val type:Int,

    /**
     * 探测结果综合分数
     *
     */
    val score:Int,

    /**
     * 真实连接的ip地址：来源于DNS源
     */
    val ip:String,

    /**
     * 探测开始时间
     */
    val startTime:Long=0,

    /**
     * 探测结束时间
     */
    val endTime:Long=0,

    /**
     * 探测所用时间
     */
    val rtt:Int=0
){
    override fun toString(): String {
        return super.toString()
    }
}
