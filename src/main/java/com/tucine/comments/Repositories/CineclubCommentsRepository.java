package com.tucine.comments.Repositories;

import com.tucine.comments.Models.CineclubComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CineclubCommentsRepository extends JpaRepository<CineclubComments, Long> {
}
