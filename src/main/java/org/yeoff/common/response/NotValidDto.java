package org.yeoff.common.response;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class NotValidDto {

  private final List<ValidationInfo> validationInfos;

  public NotValidDto() {
    validationInfos = new ArrayList<>();
  }

  public void add(String field, String message) {
    validationInfos.add(new ValidationInfo(field, message));
  }

  @Getter
  @AllArgsConstructor
  private static class ValidationInfo {

    private String field;
    private String message;
  }
}
