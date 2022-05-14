package com.app.school.config.permission;

public enum ApplicationUserPermission {
   SUBJECT_WRITE("subject:write"),
   SUBJECT_READ("subject:read"),
   SCHOOL_WRITE("school:write"),
   SCHOOL_READ("school:read");

   private final String permission;

   ApplicationUserPermission(String permission) {
      this.permission = permission;
   }

   String getPermission() {return permission;}
}
