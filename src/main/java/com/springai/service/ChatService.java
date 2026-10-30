package com.springai.service;

import com.springai.entity.Tut;

public interface ChatService {
    public Tut chat(String query);
    String chatTemplate(String query);
}
