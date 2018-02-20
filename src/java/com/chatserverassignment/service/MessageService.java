/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatserverassignment.service;

import com.chatserverassignment.model.Message;
import java.util.List;

/**
 *
 * @author Marine Harutyunyan
 */
public interface MessageService extends ServiceCreator<Message>{
    public List<Message> getConversationMessages(int conId);
}
