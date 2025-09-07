package iuh.fit.se.websocketdemo.chatEndpoint;


import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "chatEndpoint/{username}",
    encoders = {MessageEncoder.class},
    decoders = {MessageDecoder.class})
public class ChatServerEndpoint  {
}
