package com.example.hackinnovatix.repo;

import com.example.hackinnovatix.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
