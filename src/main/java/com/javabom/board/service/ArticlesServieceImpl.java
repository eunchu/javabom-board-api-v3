package com.javabom.board.service;

import com.javabom.board.entity.ArticlesEntity;
import com.javabom.board.exception.ResourceNotFoundException;
import com.javabom.board.model.articles.Articles;
import com.javabom.board.model.articles.Attributes;
import com.javabom.board.model.articles.Links;
import com.javabom.board.model.response.ArticlesWrapper;
import com.javabom.board.repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticlesServieceImpl implements ArticlesService {

    @Autowired
    private ArticlesRepository articlesRepository;

//    @Override
//    public List<ArticlesEntity> findAll() {
//        List<ArticlesEntity> articlesEntities = new ArrayList<>();
//        articlesRepository.findAll().forEach(e->articlesEntities.add(e));
//        return articlesEntities;
//    }

    @Override
    public ArticlesWrapper findAll() {
        List<Articles> articlesList = new ArrayList<>();
        List<ArticlesEntity> articlesEntityList = articlesRepository.findAll();

        for (ArticlesEntity articlesEntity : articlesEntityList) {
            Articles articles = new Articles();
            articles.setId(articlesEntity.getId());
            articles.setType("articles");
//          // [TODO] 못가져옴..
            articles.setAttributes(new Attributes(articlesEntity.getTitle(), articlesEntity.getContent()));
            articles.setLinks(new Links("https://board-api/api/v1/articles/" + articlesEntity.getId()));

            articlesList.add(articles);
        }

        ArticlesWrapper articlesWrapper = new ArticlesWrapper(articlesList);
        return articlesWrapper;
    }
//
//    @Override
//    public ArticlesEntity findById(Long id) {
//        ArticlesEntity articlesEntity = articlesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ArticlesEntity", "id", id));
//        return articlesEntity;
//    }

    @Override
    public ArticlesWrapper findById(long id) {
        ArticlesEntity foundArticle = articlesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ArticlesEntity", "id", id));

        ArticlesEntity articlesEntity = new ArticlesEntity();
        Articles articles = new Articles();

        articles.setId(id);
        articles.setType("articles");
        articles.setAttributes(new Attributes(articlesEntity.getTitle(), articlesEntity.getContent()));
        articles.setLinks(new Links("https://board-api/api/v1/articles/" + id));

        ArticlesWrapper articlesWrapper = new ArticlesWrapper(articles);

        return articlesWrapper;
    }
//
//    @Override
//    public void deleteById(long id) {
//        articlesRepository.deleteById(id);
//    }

    @Override
    public void deleteById(long id) {
        articlesRepository.deleteById(id);
    }

//    @Override
//    public ArticlesEntity save(ArticlesEntity articlesEntity) {
//        articlesRepository.save(articlesEntity);
//        return articlesEntity;
//    }

    @Override
    public ArticlesWrapper save(Articles articles) {

        ArticlesEntity articlesEntity = new ArticlesEntity();
        // [TODO] 아래코드 지우고, ENTITY에서 가져오도록 변경해야함
//        articlesEntity.setTitle(articles.getAttributes().getTitle());
//        articlesEntity.setContent(articles.getAttributes().getContent());
        articlesEntity.setTitle("title");
        articlesEntity.setContent("content");
        articlesRepository.save(articlesEntity);
//        Attributes attributes = new Attributes()
//                .builder()
//                .title(articlesEntity.getTitle())
//                .content(articlesEntity.getContent())
//                .build();

//        Links links = new Links()
//                .builder()
//                .self("https://board-api/api/v1/articles" + articlesEntity.getId())
//                .build();

//        Articles articles = new Articles().builder()
//                .type("articles")
//                .attribute(attributes)
//                .links(links)
//                .build();
        Attributes attributes = new Attributes();
//        attributes.setTitle(articles.getAttributes().getTitle());
//        attributes.setContent(articles.getAttributes().getContent());
        attributes.setTitle(articlesEntity.getTitle());
        attributes.setContent(articlesEntity.getContent());

        Links links = new Links();
        links.setSelf("https://board-api/api/v1/articles/" + articlesEntity.getId());

        Articles result = new Articles();
        result.setId(articlesEntity.getId());
        result.setType("articles");
        result.setAttributes(attributes);
        result.setLinks(links);

        ArticlesWrapper articlesWrapper = new ArticlesWrapper(result);

        return articlesWrapper;
    }

//    @Override
//    public void updateById(Long id, ArticlesEntity articlesEntity) {
//        ArticlesEntity updateEntity = articlesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ArticlesEntity", "id", id));
//        updateEntity.setTitle(articlesEntity.getTitle());
//        updateEntity.setContent(articlesEntity.getContent());
//
//        articlesRepository.save(articlesEntity);
//    }

    @Override
    public void updateById(long id, Articles articles) {
        ArticlesEntity updateEntity = articlesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ArticlesEntity", "id", id));

        updateEntity.setTitle(articles.getAttributes().getTitle());
        updateEntity.setContent(articles.getAttributes().getContent());

        articlesRepository.save(updateEntity);
    }

}
