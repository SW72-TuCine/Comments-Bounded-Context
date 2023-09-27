package com.tucine.comments.Models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "cineclub_comments")
public class CineclubComments extends Comment {
    @Column(name = "cineclub_name")
    private String cineclub;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replies;
}
