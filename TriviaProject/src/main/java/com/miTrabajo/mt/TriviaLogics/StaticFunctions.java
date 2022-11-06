package com.miTrabajo.mt.TriviaLogics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.util.HtmlUtils;

import com.miTrabajo.mt.controllers.TriviaBotZ;

public class StaticFunctions {
	
	
	//load all questions and answers
	public static void chargeQandA() {
		StaticVariables.chargeQ();
		StaticVariables.chargeA();
	}
	
	//delete questions and answers from memory
	public static void emptyQandA() {
		StaticVariables.questions.clear();
		StaticVariables.answers.clear();
	}
	
	//get a random question and answer from memory
	public static void getRandomQandA() {
		
		int qSize = StaticVariables.questions.size()-1;
		Random rand = new Random();
		StaticVariables.randomZ = rand.nextInt((qSize - 0) +1)+0;
		
	}
	
	//See which question is
	public static void activeQuestion() {
		System.out.println(StaticVariables.questions.get(StaticVariables.randomZ));
	}
	
	//See which answer is
	public static void activeAnswer() {
		System.out.println(StaticVariables.answers.get(StaticVariables.randomZ));
	}
	
	
	//cancel all timers when the game is stopped
	public static void cancelGame() {
		StaticVariables.activeGame = false;
	}
	
	//activate game
	public static void startGame() {
		StaticVariables.activeGame = true;	
	}

	//static list of info to HashMap infoUsersDictionary
		public void listInfoUser(String nickname, String xp, String tPoints, String fPoints, String timePoints, String fastestTimeTrivia, String fastestTimeFastMode, String averageTimeTrivia) {
			
			StaticVariables.infoUsersDictionary.put(nickname, Arrays.asList(xp, tPoints, fPoints, timePoints, fastestTimeTrivia, fastestTimeFastMode, averageTimeTrivia));
			
		}

	//send message to chat
		//---->
		@Autowired
	    public SimpMessageSendingOperations messagingTemplate;
		
		@EventListener
		public void sendMessageToChat(SessionDisconnectEvent event) {
			String sessionId = event.getUser().getName();
			messagingTemplate.convertAndSend("/topic/showUser", new TriviaBotZ(HtmlUtils.htmlEscape(sessionId), HtmlUtils.htmlEscape("s"), Integer.valueOf(1)), Collections.singletonMap(SimpMessageHeaderAccessor.SESSION_ID_HEADER, "aaa"));

			
		}
		//----<

}
