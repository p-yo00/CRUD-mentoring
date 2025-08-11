package org.yeoff.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import org.yeoff.domain.BoardEntity;

@Getter
@Builder
public class BoardGetResponse {

  private Long boardId;
  private String title;
  private String content;
  private String name;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createdAt;

  public static BoardGetResponse of(BoardEntity entity) {
    return BoardGetResponse.builder()
      .boardId(entity.getBoardId())
      .title(entity.getTitle())
      .content(entity.getContent())
      .name(entity.getName())
      .createdAt(entity.getCreatedAt())
      .build();
  }
}
