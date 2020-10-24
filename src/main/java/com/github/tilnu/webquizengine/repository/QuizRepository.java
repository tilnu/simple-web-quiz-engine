package com.github.tilnu.webquizengine.repository;

import com.github.tilnu.webquizengine.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
