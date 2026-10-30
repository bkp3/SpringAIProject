package com.springai.service;

import com.springai.entity.Tut;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatClient chatClient;

    @Value("classpath:prompts/user-message.st")
    private Resource userMessageTemplate;

    @Value("classpath:prompts/system-message.st")
    private Resource systemMessageTemplate;

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

    @Override
    public String chatTemplate(String query){

//        //first step
//        PromptTemplate build = PromptTemplate.builder().template("What is {techName}? tell me example of {exampleName}").build();
//
//        //renderer the template
//        String render = build.render(Map.of(
//           "techName","Spring",
//           "exampleName","Spring Boot"
//        ));
//
//        Prompt prompt=new Prompt(render);
//
//        var content=chatClient
//                .prompt(prompt)
//                .call()
//                .content();


//        //System Prompt Template
//        var systemPromptTemplate= SystemPromptTemplate.builder()
//                .template("You are a helpful coding assistant. You are an expert in coding.").build();
//        var systemMessage=systemPromptTemplate.createMessage();
//        var userPromptTemplate= PromptTemplate.builder()
//                .template("What is {techName}? tell me example of {exampleName}").build();
//        var userMessage=userPromptTemplate.createMessage(Map.of(
//                "techName","Spring",
//                "exampleName","Spring Boot"
//        ));
//        Prompt prompt1=new Prompt(systemMessage,userMessage);
//        var content=chatClient
//                .prompt(prompt1)
//                .call()
//                .content();
//
//        return content;

        //Chat Fluent API

        return this.chatClient
                .prompt()
                .system(
                        system->system.text(systemMessageTemplate)
                )
                .user(
                        user->user.text(userMessageTemplate)
                                .param("concept","Python Framework")
                )
                .call()
                .content();


    }
}
