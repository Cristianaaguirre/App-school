package com.app.school.services;

import com.app.school.models.entities.RegistrationRequest;
import com.app.school.models.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.app.school.config.permission.ApplicationUserRol.USER;

@Service
@AllArgsConstructor
public class RegistrationService {

   private final AppUserServices appUserServices;

   @Transactional
   public User registration(RegistrationRequest request) {
      if (!validateEmail(request.getEmail())) throw new IllegalStateException("ERROR");
      else return
         appUserServices.singUpUser(
            User.builder()
               .firstName(request.getName())
               .lastName(request.getLastName())
               .email(request.getEmail())
               .password(request.getPassword())
               .applicationUserRol(USER)
               .build()
         );
   }

   private boolean validateEmail(String email) {
      return true;
   }
}
