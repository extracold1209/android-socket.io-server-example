# android-socket.io-server-example
socket.io server in android app example using netty-socketio

## how to connect to app server on emulator (on windows 10)

### Turn on android emulator

just turn on emulator. if you are not install HAXM, install it and re-run emulator

### IP forwarding

in this app, socket.io server is using port 9092.
so to connect server on emulator, port forward to emulator

```shell
cd `[ANDROID SDK PATH]`/platform-tools/
adb forward tcp:9092 tcp:9092
```

### Run application

application is run server automatically. (server initialize code is in MainActivity. it is just example code XD)
and if you are terminate emulator, re-forward port is required.

## Simple Socket.io client

client is required npm library.

- execute yarn (or npm install) to install socket.io library
- command `node client` will return echo chatevent argument.
