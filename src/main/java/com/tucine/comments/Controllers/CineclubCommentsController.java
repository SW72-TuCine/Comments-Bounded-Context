package com.tucine.comments.Controllers;

import com.tucine.comments.Models.CineclubComments;
import com.tucine.comments.Services.CineclubCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
//cineclub-comments
@RequestMapping("/api/TuCine/v1/comments/cineclub")
public class CineclubCommentsController {
    private final CineclubCommentsService cineclubCommentsService;

    @Autowired
    public CineclubCommentsController(CineclubCommentsService cineclubCommentsService) {
        this.cineclubCommentsService = cineclubCommentsService;
    }

    @GetMapping
    public ResponseEntity<List<CineclubComments>> getAllCineclubComments() {
        List<CineclubComments> cineclubComments = cineclubCommentsService.getAllCineclubComments();
        return new ResponseEntity<>(cineclubComments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CineclubComments> getCineclubCommentById(@PathVariable String id) {
        CineclubComments cineclubComment = cineclubCommentsService.getCineclubCommentById(id);
        if (cineclubComment != null) {
            return new ResponseEntity<>(cineclubComment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CineclubComments> createCineclubComment(@RequestBody CineclubComments cineclubComment) {
        CineclubComments createdComment = cineclubCommentsService.createCineclubComment(cineclubComment);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CineclubComments> updateCineclubComment(@PathVariable String id, @RequestBody CineclubComments cineclubComment) {
        CineclubComments updatedComment = cineclubCommentsService.updateCineclubComment(id, cineclubComment);
        if (updatedComment != null) {
            return new ResponseEntity<>(updatedComment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCineclubComment(@PathVariable String id) {
        cineclubCommentsService.deleteCineclubComment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
