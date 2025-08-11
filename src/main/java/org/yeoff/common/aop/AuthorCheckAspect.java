package org.yeoff.common.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.yeoff.common.response.BusinessException;
import org.yeoff.common.response.ResponseCode;

@Aspect
@Component
public class AuthorCheckAspect {

  @Before("@annotation(org.yeoff.common.annotation.AuthorCheck) && args(boardId,..)")
  public void authorCheck(Long boardId) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    int userBoardId = (int) authentication.getPrincipal();

    if (userBoardId != boardId) {
      throw new BusinessException(ResponseCode.FORBIDDEN);
    }
  }
}
