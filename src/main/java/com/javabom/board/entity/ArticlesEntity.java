package com.javabom.board.entity;

import javax.persistence.*;

@Entity
public class ArticlesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column
    private String content;

    public ArticlesEntity() {}

    public ArticlesEntity(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    // Builder
//    public ArticlesEntityBuilder builder() {
//        return new ArticlesEntityBuilder();
//    }
//
//    public class ArticlesEntityBuilder {
//        private String title;
//        private String content;
//
//        ArticlesEntityBuilder() {}
//
//        public ArticlesEntity build() {
//            ArticlesEntity articlesEntity = new ArticlesEntity();
//            articlesEntity.setTitle(this.title);
//            articlesEntity.setContent(this.content);
//            return articlesEntity;
//        }
//
//        public ArticlesEntity.ArticlesEntityBuilder title(String title) {
//            this.title = title;
//            return this;
//        }
//        public ArticlesEntity.ArticlesEntityBuilder content(String content) {
//            this.content = content;
//            return this;
//        }
//    }

    @Override
    public String toString() {
        return "[" + id + "] title = " + title + ", content = " + content;
    }

}
