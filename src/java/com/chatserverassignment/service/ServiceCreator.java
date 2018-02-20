/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatserverassignment.service;

import java.util.List;

/**
 *
 * @author Marine Harutyunyan
 */
public interface ServiceCreator<S> {
    public S getByID(int id);
    
    public void add(S s);
    
    public List<S> getAll();
    
    public void update(S s);
    
    public void delete(S s);
}
