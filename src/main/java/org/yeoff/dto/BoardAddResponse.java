package org.yeoff.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardAddResponse {

  private String token;

  private Long boardId;
}