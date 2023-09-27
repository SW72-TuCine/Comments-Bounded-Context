package com.tucine.comments.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "movie_comments")
public class MovieComments extends Comment {
    @Column(name = "movie_name")
    private String movie;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replies;
}
