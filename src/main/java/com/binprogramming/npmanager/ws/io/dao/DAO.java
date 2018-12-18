/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.binprogramming.npmanager.ws.io.dao;

/**
 *
 * @author Bilal Siddiqui
 */
public interface DAO {
    /**
     * Method to open connection to database
     */
    public void openConnection(); 
    
    /**
     * Method to connection to database
     */
    public void closeConnection(); 
}
