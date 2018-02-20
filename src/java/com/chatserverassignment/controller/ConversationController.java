/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatserverassignment.controller;

import com.chatserverassignment.model.Conversation;
import com.chatserverassignment.model.Message;
import com.chatserverassignment.model.User;
import com.chatserverassignment.service.ConversationService;
import com.chatserverassignment.service.MessageService;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Marine Harutyunyan
 */

@Controller
@Scope("session")
public class ConversationController {
    
    private ConversationService conversationService;
    private MessageService messageService;
    
    User fromUser;
    User toUser;
    Conversation conversation;

    public void setConversationService(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
    

    
    public List<Message> loadingConversations() {
        Map<String, String> params = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession httpSession = request.getSession(true);
        fromUser = (User) httpSession.getAttribute("userId1");
        toUser = (User) httpSession.getAttribute("userId2");
        Long id = conversationService.getUsersConversation(fromUser.getId(), toUser.getId());
        conversation.setId(id); conversation.setUser1(fromUser); conversation.setUser2(toUser);
        if(conversation.equals(null)){
            conversation = conversationService.addNewConversation(fromUser.getId(), toUser.getId());
        }
        return conversationService.getUsersConversationMessages(id);
    }
    
    public void sendMessege(Message message){
        message.setConversation(conversation);
        message.setText("["+ fromUser.getFirstname()+ " " + fromUser.getLastname() + "] " + message.getText());
        messageService.add(message);
    }
}
