package com.app.school.services;

import com.app.school.models.DTOs.UserDTO;
import com.app.school.models.entities.User;
import com.app.school.models.exceptions.EmailExistException;
import com.app.school.models.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppUserServices implements UserDetailsService {

   private final UserRepository userRepository;
   private final BCryptPasswordEncoder bCryptPasswordEncoder;

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      return userRepository.findByEmail(username);
   }

   public User singUpUser(User user) {
      if (userRepository.findByEmail(user.getEmail()) != null)
         throw new EmailExistException("the email has already taken");
      user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
      return userRepository.save(user);
   }
}
