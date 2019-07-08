package com.javabom.board.model.response;

import lombok.*;

//@Data
@Builder
public class ArticlesWrapper<T> {

    private T data;

    public ArticlesWrapper() {}

    public ArticlesWrapper(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

//    public static ArticlesWrapperBuilder builder() {
//        return new ArticlesWrapperBuilder();
//    }
//
//    public static class ArticlesWrapperBuilder {
//        private T data;
//
//        public ArticlesWrapper build() {
//            ArticlesWrapper articlesWrapper = new ArticlesWrapper();
//            articlesWrapper.setData(this.data);
//            return articlesWrapper;
//        }
//
//        public ArticlesWrapperBuilder data(T data) {
//            this.data = data;
//            return this;
//        }
//    }

}
