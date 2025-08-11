package org.yeoff.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardAddRequest {

  @Size(max = 100) @NotEmpty
  private String title;

  @NotEmpty
  private String content;

  @NotEmpty
  private String name;
}
