package com.cleverwildcard.aboutme;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {
    private final CommentRepository commentRepository;
    public ViewController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    @GetMapping("/")
    public String commentForm(Model model) {
        model.addAttribute("comment", commentRepository.findAll());
        return "index";
    }

    @PostMapping("/")
    public String commentSubmit(@ModelAttribute Comment comment, Model model) {
        commentRepository.save(comment);
        model.addAttribute("comment", comment);
        return "index";
    }
}
