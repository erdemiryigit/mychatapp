package com.erdemiryigit.mychatapp;



import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class UserInterceptor implements GenericInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        System.out.println("presend " + message);
        return message;
    }

    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
        System.out.println("postsend " + message);
    }

    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
        // Implement afterSendCompletion logic
    }

    @Override
    public boolean preReceive(MessageChannel channel) {
        System.out.println("preReceive " + channel);
        return true;
    }

    @Override
    public Message<?> postReceive(Message<?> message, MessageChannel channel) {
        System.out.println("preReceive message" + message);
        return message;
    }

    @Override
    public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {
        // Implement afterReceiveCompletion logic
    }
}
