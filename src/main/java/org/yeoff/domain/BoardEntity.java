package org.yeoff.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.yeoff.dto.BoardAddRequest;

@Entity(name = "board")
@Table(name = "board")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long boardId;
  private String title;
  private String content;
  private String name;

  public static BoardEntity of(BoardAddRequest dto) {
    return BoardEntity.builder()
      .title(dto.getTitle())
      .content(dto.getContent())
      .name(dto.getName())
      .build();
  }

  public void updateBoard(BoardAddRequest dto) {
    this.title = dto.getTitle();
    this.content = dto.getContent();
    this.name = dto.getName();
  }
}
