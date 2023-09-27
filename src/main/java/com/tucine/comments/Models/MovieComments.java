package com.tucine.comments.Models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "movie_comments")
public class MovieComments extends Comment {
    @Field("movie_name")
    private String movie;

    private List<Comment> replies;
}
