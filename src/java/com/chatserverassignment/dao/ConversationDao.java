/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatserverassignment.dao;

import com.chatserverassignment.model.Conversation;
import com.chatserverassignment.model.Message;

/**
 *
 * @author Marine Harutyunyan
 */
public interface ConversationDao extends DaoCreator<Conversation>{
    public Long getUsersConversation(Long u1Id, Long u2Id);
    public Conversation addNewConversation(Long from_id, Long to_id);
}
