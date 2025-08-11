package org.yeoff.common.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CommonResponse {

  private Object data;
  private String code;
  private String message;

  public static CommonResponse of(Object data, ResponseCode responseCode) {
    return CommonResponse.builder()
      .data(data)
      .code(responseCode.name())
      .message(responseCode.getMessage())
      .build();
  }
}
