/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apps.developerblog.app.ws.utils;

import com.apps.developerblog.app.ws.exceptions.MissingRequiredFieldException;
import com.apps.developerblog.app.ws.shared.dto.UserDTO;
import com.apps.developerblog.app.ws.ui.model.response.ErrorMessages;

/**
 *
 * @author Bilal Siddiqui
 */
public class UserProfileUtils {
    
        public void validateRequiredFields(UserDTO userDto) throws MissingRequiredFieldException {
        if (userDto.getFirstName() == null
                || userDto.getFirstName().isEmpty()
                || userDto.getLastName() == null
                || userDto.getLastName().isEmpty()
                || userDto.getEmail() == null
                || userDto.getEmail().isEmpty()
                || userDto.getPassword() == null
                || userDto.getPassword().isEmpty()) {
            throw new MissingRequiredFieldException(
                    ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage());
        }

    }
}
