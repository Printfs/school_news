package com.feifan.Pojo;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class News {
   private Integer newsId;
   private Integer typeId;
   private String title;
   private LocalDate publishedDate;
   private String contents;

}
