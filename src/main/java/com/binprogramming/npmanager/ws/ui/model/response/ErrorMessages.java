/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.binprogramming.npmanager.ws.ui.model.response;

/**
 *
 * @author Bilal Siddiqui
 */
public enum ErrorMessages {    
    MISSING_REQUIRED_FIELDS("Missing Required Fields."), 
    RECORD_ALREADY_EXISTS("Record Already Exists"), 
    INTERNAL_SERVER_ERROR("Internal server error"); 
    
    private String errorMessage; 

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage; 
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
}
