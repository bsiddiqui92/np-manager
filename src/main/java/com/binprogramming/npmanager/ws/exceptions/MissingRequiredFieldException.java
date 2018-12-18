/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.binprogramming.npmanager.ws.exceptions;

/**
 *
 * @author Bilal Siddiqui
 */
    public class MissingRequiredFieldException extends RuntimeException {

    private static final long serialVersionUID = -2669431961633236351L;
    
    public MissingRequiredFieldException(String message) 
    {
        super(message); 
    }
}
