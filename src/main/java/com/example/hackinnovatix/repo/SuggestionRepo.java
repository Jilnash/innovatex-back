package com.example.hackinnovatix.repo;

import com.example.hackinnovatix.model.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestionRepo extends JpaRepository<Suggestion, Long> {
}
