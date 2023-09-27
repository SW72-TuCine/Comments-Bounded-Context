package com.tucine.comments.Models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "cineclub_comments")
public class CineclubComments extends Comment {
    @Field("cineclub_name")
    private String cineclub;

    private List<Comment> replies;
}
