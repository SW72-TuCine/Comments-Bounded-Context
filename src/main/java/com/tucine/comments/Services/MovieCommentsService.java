package com.tucine.comments.Services;

import com.tucine.comments.Models.MovieComments;

import java.util.List;

public interface MovieCommentsService {
    List<MovieComments> getAllMovieComments();

    MovieComments getMovieCommentById(Long id);

    MovieComments createMovieComment(MovieComments movieComment);

    MovieComments updateMovieComment(Long id, MovieComments movieComment);

    void deleteMovieComment(Long id);
}
