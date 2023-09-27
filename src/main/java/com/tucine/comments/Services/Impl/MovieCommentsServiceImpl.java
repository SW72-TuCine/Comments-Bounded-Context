package com.tucine.comments.Services.Impl;
import com.tucine.comments.Models.MovieComments;
import com.tucine.comments.Repositories.MovieCommentsRepository;
import com.tucine.comments.Services.MovieCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieCommentsServiceImpl implements MovieCommentsService {
    private final MovieCommentsRepository movieCommentsRepository;

    @Autowired
    public MovieCommentsServiceImpl(MovieCommentsRepository movieCommentsRepository) {
        this.movieCommentsRepository = movieCommentsRepository;
    }

    @Override
    public List<MovieComments> getAllMovieComments() {
        return movieCommentsRepository.findAll();
    }

    @Override
    public MovieComments getMovieCommentById(Long id) {
        return movieCommentsRepository.findById(id).orElse(null);
    }

    @Override
    public MovieComments createMovieComment(MovieComments movieComment) {
        return movieCommentsRepository.save(movieComment);
    }

    @Override
    public MovieComments updateMovieComment(Long id, MovieComments movieComment) {
        // Verificar si el comentario existe
        MovieComments existingComment = movieCommentsRepository.findById(id).orElse(null);
        if (existingComment == null) {
            return null; // Comentario no encontrado
        }

        // Actualizar los campos relevantes del comentario existente
        existingComment.setContent(movieComment.getContent());
        existingComment.setCalification(movieComment.getCalification());

        return movieCommentsRepository.save(existingComment);
    }

    @Override
    public void deleteMovieComment(Long id) {
        movieCommentsRepository.deleteById(id);
    }
}
