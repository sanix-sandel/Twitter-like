package com.sanix.Twitter.repositories;

import com.sanix.Twitter.models.LikeAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<LikeAction, Long> {
}
