package com.app.school.controllers;

import com.app.school.models.DTOs.UserDTO;
import com.app.school.models.entities.RegistrationRequest;
import com.app.school.models.entities.User;
import com.app.school.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
@AllArgsConstructor
public class RegistrationController {

   private final RegistrationService registrationService;

   @PostMapping
   public ResponseEntity<UserDTO> registration(@RequestBody RegistrationRequest request) {
      return ResponseEntity.status(HttpStatus.CREATED).body(registrationToDTO(
         registrationService.registration(request)
      ));
   }

   private UserDTO registrationToDTO(@NotNull User user)
   {
      return UserDTO.builder()
         .firstName(user.getFirstName())
         .lastName(user.getLastName())
         .email(user.getEmail())
         .userRol(user.getApplicationUserRol().name())
         .build();
   }
}
