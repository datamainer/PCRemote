package com.example.pcremote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

class WolManager {
    suspend fun sendMagicPacket(macAddress: String) {
        withContext(Dispatchers.IO) {
            try {
                val macBytes = getMacBytes(macAddress)

                val bytes = ByteArray(6 + 16 * macBytes.size)
                for (i in 0..5) bytes[i] = 0xff.toByte()
                for (i in 6 until bytes.size step macBytes.size) {
                    System.arraycopy(macBytes, 0, bytes, i, macBytes.size)
                }

                val address = InetAddress.getByName("255.255.255.255")
                val packet = DatagramPacket(bytes, bytes.size, address, 7)
                DatagramSocket().use {
                    it.send(packet)
                    it.broadcast = true
                }
            } catch (e: Exception) { e.printStackTrace() }
        }
    }

    private fun getMacBytes(macStr: String): ByteArray {
        val bytes = ByteArray(6)
        val hex = macStr.split(":", "-")
        for (i in 0..5) bytes[i] = hex[i].toInt(16).toByte()
        return bytes
    }
}