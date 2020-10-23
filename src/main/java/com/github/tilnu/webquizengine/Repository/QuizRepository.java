package com.github.tilnu.webquizengine.Repository;

import com.github.tilnu.webquizengine.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
