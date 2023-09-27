package com.tucine.comments.Services;

import com.tucine.comments.Models.CineclubComments;

import java.util.List;

public interface CineclubCommentsService {
    List<CineclubComments> getAllCineclubComments();

    CineclubComments getCineclubCommentById(Long id);

    CineclubComments createCineclubComment(CineclubComments cineclubComment);

    CineclubComments updateCineclubComment(Long id, CineclubComments cineclubComment);

    void deleteCineclubComment(Long id);

}
