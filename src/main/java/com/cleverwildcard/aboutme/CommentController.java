package com.cleverwildcard.aboutme;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private final CommentRepository commentRepository;

    CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    @PostMapping("/comments")
    Comment newComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @GetMapping("/comments")
    List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @PutMapping("/comments/{id}}")
    Comment editComment(@RequestBody Comment newComment, @PathVariable Long id) {
        return commentRepository.findById(id).map(comment -> {
            comment.setAuthor(newComment.getAuthor());
            comment.setContent(newComment.getContent());
            return commentRepository.save(comment);
        }).orElseGet(() -> commentRepository.save(newComment));
    }

    @DeleteMapping("/comments/{id}")
    void deleteComment(@PathVariable Long id) {
        commentRepository.deleteById(id);
    }
}
