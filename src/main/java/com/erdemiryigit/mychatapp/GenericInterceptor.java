package com.erdemiryigit.mychatapp;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;

public interface GenericInterceptor extends ChannelInterceptor {

    @Override
    default Message<?> preSend(Message<?> message, MessageChannel channel) {
        // Implement preSend logic
        return message;
    }

    @Override
    default void postSend(Message<?> message, MessageChannel channel, boolean sent) {
        // Implement postSend logic
    }

    @Override
    default void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
        // Implement afterSendCompletion logic
    }

    @Override
    default boolean preReceive(MessageChannel channel) {
        // Implement preReceive logic
        return true;
    }

    @Override
    default Message<?> postReceive(Message<?> message, MessageChannel channel) {
        // Implement postReceive logic
        return message;
    }

    @Override
    default void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {
        // Implement afterReceiveCompletion logic
    }
}
