package com.javabom.board.model.articles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder

public class Articles {

    private Long id;
    private String type;
    private Attributes attributes;
    private Links links;

}
