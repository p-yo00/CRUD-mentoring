package org.yeoff.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ResponseCode {
  SUCCESS("요청이 성공적으로 완료됐습니다.", HttpStatus.OK),
  BOARD_NOT_FOUND("존재하지 않는 게시글입니다.", HttpStatus.NOT_FOUND),
  FORBIDDEN("요청 권한이 없습니다.", HttpStatus.FORBIDDEN),
  SERVER_ERROR("서버 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR),
  INVALID_INPUT("잘못된 입력값입니다.", HttpStatus.BAD_REQUEST);

  private final String message;
  private final HttpStatus httpStatus;
}
