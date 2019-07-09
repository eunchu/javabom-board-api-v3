package com.javabom.board.controller;

import com.javabom.board.model.articles.Articles;
import com.javabom.board.model.response.ArticlesWrapper;
import com.javabom.board.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.javabom.board.constant.ArticlesConstans.BASE_URL;

@RestController
@RequestMapping(BASE_URL)
public class ArticlesController {

    @Autowired
    private ArticlesService articlesService;

    @GetMapping("/articles")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<ArticlesWrapper> getAllArticles() {
        return new ResponseEntity<ArticlesWrapper>((ArticlesWrapper) articlesService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticlesWrapper> getArticle(@PathVariable("id") long id) {
        return new ResponseEntity<ArticlesWrapper>(articlesService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") long id) {
        articlesService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/articles/{id}")
    public ResponseEntity<Articles> updateArticle(@PathVariable("id") long id, @RequestBody Articles articles) {
        articlesService.updateById(id, articles);
        return new ResponseEntity<Articles>(articles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ArticlesWrapper> save(@RequestBody Articles articles) {
        return new ResponseEntity<ArticlesWrapper>(articlesService.save(articles), HttpStatus.OK);
    }

}
