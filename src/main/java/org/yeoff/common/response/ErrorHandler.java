package org.yeoff.common.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

  @ExceptionHandler(BusinessException.class)
  private ResponseEntity<CommonResponse> handleBusinessException(BusinessException exception) {
    log.error("{}:{}", exception.getClass(), exception.getMessage());

    return new ResponseEntity<>(
      CommonResponse.of(null, exception.getResponseCode()),
      exception.getResponseCode().getHttpStatus());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  private ResponseEntity<CommonResponse> handleNotValidException(
    MethodArgumentNotValidException exception) {
    NotValidDto notValidList = new NotValidDto();

    for (FieldError error : exception.getBindingResult().getFieldErrors()) {
      notValidList.add(error.getField(), error.getDefaultMessage());
    }

    return new ResponseEntity<>(CommonResponse.of(
      notValidList,
      ResponseCode.INVALID_INPUT
    ), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  private ResponseEntity<CommonResponse> handleException(Exception exception) {
    log.error("{}:{}", exception.getClass(), exception.getMessage());

    return new ResponseEntity<>(
      CommonResponse.of(null, ResponseCode.SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
