package com.springai.controllers;

import com.springai.entity.Tut;
import com.springai.service.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ChatClientFluentApiController {

    //private ChatClient chatClient;



//    ChatClientFluentApiController(ChatClient.Builder chatClientBuilder) {
//        this.chatClient = chatClientBuilder.build();
//    }

    private ChatService chatService;
    ChatClientFluentApiController(ChatService chatService) {
        this.chatService = chatService;
    }


    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(value="q", required = true) String q) {

        return ResponseEntity.ok(chatService.chatTemplate(q));
    }

}
