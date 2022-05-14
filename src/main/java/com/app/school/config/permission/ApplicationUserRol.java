package com.app.school.config.permission;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationUserRol {
   USER(Sets.newHashSet(ApplicationUserPermission.SUBJECT_READ, ApplicationUserPermission.SUBJECT_WRITE)),
   ADMIN(Sets.newHashSet(ApplicationUserPermission.SUBJECT_WRITE, ApplicationUserPermission.SUBJECT_READ, ApplicationUserPermission.SCHOOL_WRITE, ApplicationUserPermission.SCHOOL_READ));

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
