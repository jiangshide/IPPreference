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
     * 真实连接的ip地址：来源于DNS源
     */
    val ip:String,

    /**
     * 探测优先级
     * 优先级按1～9递增，值越大优先级越高
     * 可根据业务来动态调整优先级
     */
    val level:Int=1,

    /**
     * 探测类型
     * 根据业务来约束定义即可，默认为1：通用类型
     */
    val type:Int=1,

    /**
     * 探测结果综合分数
     * 需要多维度进行综合计算后获得的一个综合评分，可根据此评分做相关排序
     */
    val score:Int=0,

    /**
     * 所在位置经度
     */
    val longitude:Float=0F,

    /**
     * 所在位置维度
     */
    val latitude:Float=0F,

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
