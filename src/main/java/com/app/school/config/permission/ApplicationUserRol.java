package com.app.school.config.permission;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.app.school.config.permission.ApplicationUserPermission.*;

public enum ApplicationUserRol {
   USER(Sets.newHashSet(SUBJECT_READ, SUBJECT_WRITE)),
   ADMIN(Sets.newHashSet(SUBJECT_WRITE, SUBJECT_READ, SCHOOL_WRITE, SCHOOL_READ));

   private final Set<ApplicationUserPermission> authorities;

   ApplicationUserRol(Set<ApplicationUserPermission> authorities) {
      this.authorities = authorities;
   }

   Set<ApplicationUserPermission> getPermission() {return authorities;}

   public Set<SimpleGrantedAuthority> getAuthorities() {
      Set<SimpleGrantedAuthority> list =
         getPermission()
         .stream()
         .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
         .collect(Collectors.toSet());
      list.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
      return list;
   }
}
