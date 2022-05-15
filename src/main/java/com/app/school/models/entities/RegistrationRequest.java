package com.app.school.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class RegistrationRequest {
   private String name;
   private String lastName;
   private String email;
   private String password;
}
