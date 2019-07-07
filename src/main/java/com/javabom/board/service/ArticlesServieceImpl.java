package com.javabom.board.service;

import com.javabom.board.entity.ArticlesEntity;
import com.javabom.board.exception.ResourceNotFoundException;
import com.javabom.board.repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticlesServieceImpl implements ArticlesService {

    @Autowired
    private ArticlesRepository articlesRepository;

    @Override
    public List<ArticlesEntity> findAll() {
        List<ArticlesEntity> articlesEntities = new ArrayList<>();
        articlesRepository.findAll().forEach(e->articlesEntities.add(e));
        return articlesEntities;
    }

    @Override
    public ArticlesEntity findById(Long id) {
        ArticlesEntity articlesEntity = articlesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ArticlesEntity", "id", id));
        return articlesEntity;
    }

    @Override
    public void deleteById(long id) {
        articlesRepository.deleteById(id);
    }

    @Override
    public ArticlesEntity save(ArticlesEntity articlesEntity) {
        articlesRepository.save(articlesEntity);
        return articlesEntity;
    }

    @Override
    public void updateById(Long id, ArticlesEntity articlesEntity) {
        ArticlesEntity updateEntity = articlesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ArticlesEntity", "id", id));
        updateEntity.setTitle(articlesEntity.getTitle());
        updateEntity.setContent(articlesEntity.getContent());

        articlesRepository.save(articlesEntity);
    }

}
