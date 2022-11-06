package com.miTrabajo.mt.controllers;

import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Controller
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	
	@Override
	public void configureMessageBroker (MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry ) {
		registry.addEndpoint("/Endpoint1").withSockJS();
		registry.addEndpoint("/Endpoint2").withSockJS();
		registry.addEndpoint("/Endpoint3").withSockJS();
		registry.addEndpoint("/Endpoint4").withSockJS();
		registry.addEndpoint("/EndpointConnectedUser").withSockJS();
		
		registry.addEndpoint("/EndpointMessageInputServer").withSockJS();
		
	}

}
