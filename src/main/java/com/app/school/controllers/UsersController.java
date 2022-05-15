package com.app.school.controllers;

import com.app.school.services.AppUserServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UsersController {

   private final AppUserServices userServices;

}
