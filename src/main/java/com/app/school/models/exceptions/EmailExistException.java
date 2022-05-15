package com.app.school.models.exceptions;

public class EmailExistException extends IllegalStateException{
   public EmailExistException(String message) {
      super(message);
   }
}
