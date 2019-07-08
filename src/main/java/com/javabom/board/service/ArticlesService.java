package com.javabom.board.service;

import com.javabom.board.model.articles.Articles;
import com.javabom.board.model.response.ArticlesWrapper;

public interface ArticlesService {

    ArticlesWrapper findAll();

    ArticlesWrapper findById(long id);

    void deleteById(long id);

    ArticlesWrapper save(Articles articles);

    void updateById(long id, Articles articles);
}
