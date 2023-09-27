package com.tucine.comments.Repositories;

import com.tucine.comments.Models.MovieComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCommentsRepository extends JpaRepository<MovieComments, Long> {
}
