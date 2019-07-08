package com.javabom.board.controller;

import com.javabom.board.model.articles.Articles;
import com.javabom.board.model.response.ArticlesWrapper;
import com.javabom.board.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class ArticlesController {

    @Autowired
    private ArticlesService articlesService;

//    @GetMapping("/articles")
//    public ResponseEntity<List<ArticlesEntity>> getAllArticles() {
//        List<ArticlesEntity> articlesEntities = articlesService.findAll();
//        return new ResponseEntity<List<ArticlesEntity>>(articlesEntities, HttpStatus.OK);
//    }
    @GetMapping("/articles")
    public ResponseEntity<ArticlesWrapper> getAllArticles() {
//        List<Articles> articles = articlesService.findAll();

        return new ResponseEntity<ArticlesWrapper>((ArticlesWrapper) articlesService.findAll(), HttpStatus.OK);
    }
//
//    @GetMapping("/articles/{id}")
//    public ResponseEntity<ArticlesEntity> getArticle(@PathVariable("id") long id) {
//        return new ResponseEntity<ArticlesEntity>(articlesService.findById(id), HttpStatus.OK);
//    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticlesWrapper> getArticle(@PathVariable("id") long id) {
        return new ResponseEntity<ArticlesWrapper>(articlesService.findById(id), HttpStatus.OK);
    }
//
//    @DeleteMapping("/articles/{id}")
//    public ResponseEntity<Void> deleteArticle(@PathVariable("id") long id) {
//        articlesService.deleteById(id);
//        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") long id) {
        articlesService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
//
//    @PutMapping("articles/{id}")
//    public ResponseEntity<ArticlesEntity> updateArticle(@PathVariable("id") long id, @RequestBody ArticlesEntity articlesEntity) {
//        articlesService.updateById(id, articlesEntity);
//        return new ResponseEntity<ArticlesEntity>(articlesEntity, HttpStatus.OK);
//    }

    @PutMapping("/articles/{id}")
    public ResponseEntity<Articles> updateArticle(@PathVariable("id") long id, @RequestBody Articles articles) {
        articlesService.updateById(id, articles);
        return new ResponseEntity<Articles>(articles, HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<ArticlesEntity> save(@RequestBody ArticlesEntity articlesEntity) {
//        return new ResponseEntity<ArticlesEntity>(articlesService.save(articlesEntity), HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<ArticlesWrapper> save(@RequestBody Articles articles) {
        return new ResponseEntity<ArticlesWrapper>(articlesService.save(articles), HttpStatus.OK);
    }

}
