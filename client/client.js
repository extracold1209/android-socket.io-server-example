const io = require("socket.io-client");
const ioClient = io.connect("http://127.0.0.1:9092");

ioClient.emit('chatevent', {
    userName: 'hello',
    message: 'world'
});

ioClient.on('chatevent', console.log);

console.log(ioClient);