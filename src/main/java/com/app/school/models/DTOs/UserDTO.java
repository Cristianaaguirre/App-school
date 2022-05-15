package com.app.school.models.DTOs;

import lombok.*;

@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode
public class UserDTO {
   private String firstName;
   private String lastName;
   private String email;
   private String userRol;
}
