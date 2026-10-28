package com.springai.service;

import com.springai.entity.Tut;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatClient chatClient;

    ChatServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }


    @Override
    public Tut chat(String query) {

        //String prompt="Tell me about virat kohli";

        //call the llm for response
//        String content=chatClient
//                .prompt()
//                .user(prompt)
//                .system("As an expert in cricket")
//                .call()
//                .content();

        Prompt prompt1=new Prompt(query);
        Tut content=chatClient
                .prompt(prompt1)
                .call()
                .entity(Tut.class);



        return content;
    }
}
