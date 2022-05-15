package com.app.school.models.entities;

import com.app.school.config.permission.ApplicationUserRol;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;

@Entity
@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class User implements UserDetails

{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String firstName;
   private String lastName;
   private String username;
   private String email;
   private String password;
   private ApplicationUserRol applicationUserRol;
   private Boolean locked = false;
   private Boolean enable = false;

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return applicationUserRol.getAuthorities();
   }

   @Override
   public String getPassword() {
      return password;
   }

   @Override
   public String getUsername() {
      return username;
   }

   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      return enable;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override
   public boolean isEnabled() {
      return enable;
   }
}
