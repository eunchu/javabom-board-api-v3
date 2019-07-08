package com.javabom.board.model.articles;

import lombok.*;

@Builder
public class Articles {

    private long id;
    private String type;
    private Attributes attributes;
    private Links links;

    public Articles() {}

    public Articles(String type, Attributes attributes, Links links) {
        this.type = type;
        this.attributes = attributes;
        this.links = links;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void  setType(String type) {
        this.type = type;
    }

    public Attributes getAttributes() {
        return attributes;
    }
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Links getLinks() {
        return links;
    }
    public void setLinks(Links links) {
        this.links = links;
    }

//    public ArticlesBuilder builder() {
//        return new ArticlesBuilder();
//    }
//
//    public class ArticlesBuilder {
//        private long id;
//        private String type;
//        private Attributes attributes;
//        private Links links;
//
//        public Articles build() {
//            Articles articles = new Articles();
//            articles.setType(this.type);
//            articles.setAttributes(this.attributes);
//            articles.setLinks(this.links);
//            return articles;
//        }
//
//        public ArticlesBuilder type(String type) {
//            this.type = type;
//            return this;
//        }
//
//        public ArticlesBuilder attribute(Attributes attributes) {
//            this.attributes = attributes;
//            return this;
//        }
//
//        public ArticlesBuilder links(Links links) {
//            this.links = links;
//            return this;
//        }
//    }
}
