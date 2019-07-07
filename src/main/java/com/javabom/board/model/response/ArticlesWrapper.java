package com.javabom.board.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder

public class ArticlesWrapper<T> {

    private T data;

}
