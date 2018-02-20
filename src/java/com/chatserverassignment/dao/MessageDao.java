/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatserverassignment.dao;

import com.chatserverassignment.model.Message;
import java.util.List;

/**
 *
 * @author MarineHarutyunyan
 */
public interface MessageDao extends DaoCreator<Message>{
    List<Message> getByConversationId(Long id);
}
