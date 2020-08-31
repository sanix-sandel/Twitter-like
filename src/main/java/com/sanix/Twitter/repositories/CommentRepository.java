package com.sanix.Twitter.repositories;

import com.sanix.Twitter.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
