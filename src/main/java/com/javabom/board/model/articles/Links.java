package com.javabom.board.model.articles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class Links {

    private String self;

    public Links() {}

    public Links(String self) {
        this.self = self;
    }

    public String getSelf() {
        return self;
    }
    public void setSelf(String self) {
        this.self = self;
    }

//    public LinksBuilder builder() {
//        return new LinksBuilder();
//    }
//
//    public class LinksBuilder {
//        private String self;
//
//        public Links build() {
//            Links links = new Links();
//            links.setSelf(this.self);
//            return links;
//        }
//
//        public LinksBuilder self(String self) {
//            this.self = self;
//            return this;
//        }
//    }
}
