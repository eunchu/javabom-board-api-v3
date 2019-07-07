package com.javabom.board.service;

import com.javabom.board.entity.ArticlesEntity;

import java.util.List;

public interface ArticlesService {

    List<ArticlesEntity> findAll();

    ArticlesEntity findById(Long id);

    void deleteById(long id);

    ArticlesEntity save(ArticlesEntity articlesEntity);

    void updateById(Long id, ArticlesEntity articlesEntity);
}
