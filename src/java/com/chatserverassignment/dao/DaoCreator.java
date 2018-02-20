/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatserverassignment.dao;

import java.util.List;

/**
 *
 * @author Marine Harutyunyan
 * @param <G> - Type for generating below methods
 */
public interface DaoCreator<G> {
    
    public void add(G g);
    
    public List<G> getAll();
    
    public G getByID(int id);
    
    public void update(G g);
    
    public void delete(G g);
    
}
