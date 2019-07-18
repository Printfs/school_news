package com.feifan.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class News {
   private Integer newsId;
   private Integer parentId;
   private String title;
   private String publisher;
   private String author;
   private String content;
   private String publishTime;
   private int statusId;
   private String images;
   private int commentId;
   private int like;



}
