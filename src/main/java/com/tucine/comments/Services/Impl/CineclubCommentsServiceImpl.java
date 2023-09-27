package com.tucine.comments.Services.Impl;

import com.tucine.comments.Models.CineclubComments;
import com.tucine.comments.Repositories.CineclubCommentsRepository;
import com.tucine.comments.Services.CineclubCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CineclubCommentsServiceImpl implements CineclubCommentsService {
    private final CineclubCommentsRepository cineclubCommentsRepository;

    @Autowired
    public CineclubCommentsServiceImpl(CineclubCommentsRepository cineclubCommentsRepository) {
        this.cineclubCommentsRepository = cineclubCommentsRepository;
    }

    @Override
    public List<CineclubComments> getAllCineclubComments() {
        return cineclubCommentsRepository.findAll();
    }

    @Override
    public CineclubComments getCineclubCommentById(Long id) {
        return cineclubCommentsRepository.findById(id).orElse(null);
    }

    @Override
    public CineclubComments createCineclubComment(CineclubComments cineclubComment) {
        return cineclubCommentsRepository.save(cineclubComment);
    }

    @Override
    public CineclubComments updateCineclubComment(Long id, CineclubComments cineclubComment) {
        // Verificar si el comentario existe
        CineclubComments existingComment = cineclubCommentsRepository.findById(id).orElse(null);
        if (existingComment == null) {
            return null; // Comentario no encontrado
        }

        // Actualizar los campos relevantes del comentario existente
        existingComment.setContent(cineclubComment.getContent());
        existingComment.setCalification(cineclubComment.getCalification());

        return cineclubCommentsRepository.save(existingComment);
    }

    @Override
    public void deleteCineclubComment(Long id) {
        cineclubCommentsRepository.deleteById(id);
    }
}
