package com.erdemiryigit.mychatapp.controller;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.erdemiryigit.mychatapp.ChatMessage;
import com.erdemiryigit.mychatapp.Greeting;

@Controller
public class GreetingController {

	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@MessageMapping("/secured/room")
	public void sendSpecific(
			@Payload Message<ChatMessage> msg,
			Principal user,
			@Header("simpSessionId") String sessionId) throws Exception {
		ChatMessage out = new ChatMessage(
				"sa",
				"as",
				msg.getPayload().toString(),
				new Date());
				messagingTemplate.convertAndSendToUser(
				"as", "/secured/user/queue/specific-user", out);
	}

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(ChatMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.from()) + "!");
	}

}
