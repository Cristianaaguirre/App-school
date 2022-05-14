package com.app.school.services;

import com.app.school.models.entities.Subject;
import com.app.school.models.repositories.SubjectRepository;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectServices {

   private final SubjectRepository subjectRepository;

   private Subject getSubject(Long id) throws Exception {
      return subjectRepository
         .findById(id)
         .orElseThrow(() -> new Exception("the subject don't exist"));
   }

   private List<Subject> getAll() {
      return subjectRepository.findAll();
   }

   private Subject save(Subject aux) {
      return subjectRepository.save(aux);
   }

   private void delete(Long id) {
      subjectRepository.deleteById(id);
   }
}
