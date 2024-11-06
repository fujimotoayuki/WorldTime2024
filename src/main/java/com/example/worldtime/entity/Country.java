package com.example.worldtime.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table(name = "country")
//エンティティ　idをintegerからlong型に変更。ほかはそのまま。
//この項目のうちgoodsImg、captialImg、captialは項目は存在しているが使用していない。可能ならあとからつかう
public class Country {
        @Id
    private Long id;
    private String name;
    private Integer localTime;
    private String nationalFlag;
    private String map;
    private String nameEnglish;
    private Integer area;
    private Integer population;
    private String captial;
    private String captialImg;
    private String goods;
    private String goodsImg;
    private String overview;
    private String trivia;
}
