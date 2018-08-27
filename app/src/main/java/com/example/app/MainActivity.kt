package com.example.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.corundumstudio.socketio.Configuration
import com.corundumstudio.socketio.SocketIOServer

class MainActivity : AppCompatActivity() {
	private val config = Configuration()
	private val server: SocketIOServer

	init {
		config.hostname = "localhost"
		config.port = 9092
		server = SocketIOServer(config)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		server.addEventListener("chatevent", ChatObject::class.java) { _, data, _ ->
			data?.apply {
				println(this.message)
				server.broadcastOperations.sendEvent("chatevent", this)
			}
		}
	}

	override fun onResume() {
		Thread {
			server.start()
		}.start()
		super.onResume()
	}

	override fun onStop() {
		server.stop()
		super.onStop()
	}
}
