package com.example.pcremote

class UdpSender(private val ip: String, private val port: Int) {
    // Сокет НЕ создается при старте. Он "спит", пока не вызовешь socket.send
    private val socket by lazy { java.net.DatagramSocket() }

    fun send(msg: String) {
        Thread {
            try {
                // Все сетевые действия (DNS и отправка) теперь гарантированно в фоне
                val address = java.net.InetAddress.getByName(ip)
                val buf = msg.toByteArray()
                val packet = java.net.DatagramPacket(
                    buf,
                    buf.size,
                    address,
                    port
                )
                socket.send(packet)
            } catch (e: Exception) {
                // Если не получилось отправить (например, комп выключен),
                // приложение не вылетит, а просто выведет ошибку в лог
                android.util.Log.e("UDP_DEBUG", "Error sending: ${e.message}")
            }
        }.start()
    }
}