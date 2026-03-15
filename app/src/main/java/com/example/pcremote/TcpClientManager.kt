package com.example.pcremote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.PrintWriter
import java.net.Socket

class TcpClientManager(private val ip: String, private val port: Int) {

    suspend fun sendCommand(command: String) {
        withContext(Dispatchers.IO) {
            try {

                Socket(ip, port).use { socket ->
                    val out = PrintWriter(socket.getOutputStream(), true)
                    out.println(command)
                }
            } catch (e: Exception) {
                e.printStackTrace() // Здесь можно добавить логирование ошибок
            }
        }
    }
}