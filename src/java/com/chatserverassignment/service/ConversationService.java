/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatserverassignment.service;

import com.chatserverassignment.model.Conversation;
import com.chatserverassignment.model.Message;
import java.util.List;

/**
 *
 * @author Marine Harutyunyan
 */
public interface ConversationService extends ServiceCreator<Conversation>{
    public List<Message> getUsersConversationMessages(Long c);
    public Long getUsersConversation(Long from_id, Long to_id);
    public Conversation addNewConversation(Long from_id, Long to_id);
}
