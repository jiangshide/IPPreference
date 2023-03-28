package com.android.preference.dns

import com.android.preference.model.IpModel
import okhttp3.Dns
import java.net.InetAddress

/**
 * @author: jiangshide
 * @date: 2023/3/28
 * @email: 18311271399@163.com
 * @description:用于探测时模拟DNS真实环境支持
 */
internal class ProbeDns(private val ipModel: IpModel): Dns {
    override fun lookup(hostname: String): List<InetAddress> {
        val inetAddressList = ArrayList<InetAddress>()
        inetAddressList.add(
            InetAddress.getByAddress(
                ipModel.host,InetAddress.getByName(ipModel.ip).address
            )
        )
        return inetAddressList
    }
}