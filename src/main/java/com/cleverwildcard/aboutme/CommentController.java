package com.cleverwildcard.aboutme;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private final CommentRepository commentRepository;

    CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @PostMapping("/comments")
    public ResponseEntity<Comment> postComment(Comment comment) {
//        if (comment.getComment() == "") {
//            comment.setComment("I had no words for how wonderful this was.");
//        }
//        if (comment.getAuthor() == "") {
//            comment.setAuthor("Anonymous");
//        }
        return ResponseEntity.ok(commentRepository.save(comment));
    }

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getAllComments() {
        return ResponseEntity.ok(this.commentRepository.findAll());
    }
    @PutMapping("/comments/{id}")
    ResponseEntity<Comment> editComment(@RequestBody Comment newComment, @PathVariable Long id) {
        commentRepository.findById(id).map(comment -> {
            comment.setAuthor(newComment.getAuthor());
            comment.setComment(newComment.getComment());
            return ResponseEntity.ok(commentRepository.save(comment));
        });
        return ResponseEntity.ok(commentRepository.save(newComment));
    }

    @DeleteMapping("/employees/{id}")
    ResponseEntity<String> deleteComment(@PathVariable Long id) {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
            return ResponseEntity.ok(String.valueOf("Comment " + id + " deleted."));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(String.valueOf("Comment " + id + " not found."));
    }

//        ).orElseGet(() -> {
//            return ResponseEntity.ok(commentRepository.save(newComment));
//        });



//    @GetMapping("/comments")
//    List<Comment> getComments() {
//        return commentRepository.findAll();
//    }
//    @PutMapping("/comments/{id}}")
//    Comment editComment(@RequestBody Comment newComment, @PathVariable Long id) {
//        return commentRepository.findById(id).map(comment -> {
//            comment.setAuthor(newComment.getAuthor());
//            comment.setComment(newComment.getComment());
//            return commentRepository.save(comment);
//        }).orElseGet(() -> {
//        return commentRepository.save(newComment);
//        });
//    }

//    @DeleteMapping("/employees/{id}")
//    void deleteComment(@PathVariable Long id) {
//        commentRepository.deleteById(id);
//    }

//    @PostMapping("/comment/new")
//    public ResponseEntity<Comment> postComment(Comment comment) {
//        return ResponseEntity.ok(this.commentRepository.save(comment));
//    }
//    @GetMapping("/comment/get-all")
//    public ResponseEntity<List<Comment>> getAllComments() {
//        return ResponseEntity.ok(this.commentRepository.findAll());
//    }
//    @PutMapping("/comment/edit")
//    public ResponseEntity<Comment> editComment(Comment comment) {
//        commentRepository.findAllById(comment.id).set =
//    }
}
