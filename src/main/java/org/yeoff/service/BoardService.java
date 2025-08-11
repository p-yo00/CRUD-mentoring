package org.yeoff.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yeoff.common.response.BusinessException;
import org.yeoff.common.response.CommonResponse;
import org.yeoff.common.response.ResponseCode;
import org.yeoff.common.security.JwtUtil;
import org.yeoff.domain.BoardEntity;
import org.yeoff.dto.BoardAddRequest;
import org.yeoff.dto.BoardAddResponse;
import org.yeoff.dto.BoardGetResponse;
import org.yeoff.repository.BoardRepository;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;
  private final JwtUtil jwtUtil;

  public CommonResponse addBoard(BoardAddRequest request) {
    BoardEntity boardEntity = boardRepository.save(BoardEntity.of(request));

    String jwtToken = jwtUtil.generateToken(boardEntity.getBoardId());

    return CommonResponse.of(new BoardAddResponse(jwtToken, boardEntity.getBoardId())
                           , ResponseCode.SUCCESS);
  }

  public CommonResponse deleteBoard(Long boardId) {
    BoardEntity boardEntity = boardRepository.findById(boardId)
      .orElseThrow(() -> new BusinessException(ResponseCode.BOARD_NOT_FOUND));

    boardRepository.deleteById(boardId);

    return CommonResponse.of(boardEntity.getBoardId(), ResponseCode.SUCCESS);
  }

  @Transactional
  public CommonResponse modifyBoard(Long boardId, BoardAddRequest request) {
    BoardEntity boardEntity = boardRepository.findById(boardId)
      .orElseThrow(() -> new BusinessException(ResponseCode.BOARD_NOT_FOUND));

    boardEntity.updateBoard(request);

    return CommonResponse.of(boardEntity.getBoardId(), ResponseCode.SUCCESS);
  }

  public CommonResponse getBoard(Long boardId) {
    BoardEntity boardEntity = boardRepository.findById(boardId)
      .orElseThrow(() -> new BusinessException(ResponseCode.BOARD_NOT_FOUND));

    return CommonResponse.of(BoardGetResponse.of(boardEntity), ResponseCode.SUCCESS);
  }

}
