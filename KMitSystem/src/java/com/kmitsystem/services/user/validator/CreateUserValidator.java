package com.kmitsystem.services.user.validator;

import com.kmitsystem.services.user.input.CreateUserInput;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 * @author Alex, Malte
 */
public class CreateUserValidator {
    
    public boolean validate(CreateUserInput input) {
        boolean result = true;
        
        // check if the email is already taken
        if(DBUserQueries.isEMailExisting(input.getEmail())) {
            ErrorHandler.handle(Errors.NAME_ALREADY_TAKEN_ERROR, DBUserQueries.class.getName() + ": isEmailExisting");
            return false;
        }
        
        // check if the username is already taken
        if(DBUserQueries.isUsernameExisting(input.getName())) {
            ErrorHandler.handle(Errors.EMAIL_ALREADY_TAKEN_ERROR, DBUserQueries.class.getName() + ": isUsernameExisting");
            return false;
        }
        
        return result;
    }
    
} 