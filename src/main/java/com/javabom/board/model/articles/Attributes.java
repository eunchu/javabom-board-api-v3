package com.javabom.board.model.articles;

import lombok.*;

@Builder
public class Attributes {

    private String title;
    private String content;

    public Attributes() {}

    public Attributes(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

//    public AttributesBuilder builder() {
//        return new AttributesBuilder();
//    }
//
//    public class AttributesBuilder {
//        private String title;
//        private String content;
//
//        public Attributes build() {
//            Attributes attributes = new Attributes();
//            attributes.setTitle(this.title);
//            attributes.setContent(this.content);
//            return attributes;
//        }
//
//        public AttributesBuilder title(String title) {
//            this.title = title;
//            return this;
//        }
//
//        public AttributesBuilder content(String content) {
//            this.content = content;
//            return this;
//        }
//    }
}
