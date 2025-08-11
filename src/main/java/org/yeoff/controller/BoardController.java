package org.yeoff.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yeoff.common.annotation.AuthorCheck;
import org.yeoff.common.response.CommonResponse;
import org.yeoff.dto.BoardAddRequest;
import org.yeoff.service.BoardService;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

  private final BoardService boardService;

  @PostMapping
  public ResponseEntity<CommonResponse> addBoard(@RequestBody @Valid BoardAddRequest request) {
    return ResponseEntity.ok(boardService.addBoard(request));
  }

  @DeleteMapping("/{boardId}")
  @AuthorCheck
  public ResponseEntity<CommonResponse> deleteBoard(@PathVariable("boardId") Long boardId) {
    return ResponseEntity.ok(boardService.deleteBoard(boardId));
  }

  @PutMapping("/{boardId}")
  @AuthorCheck
  public ResponseEntity<CommonResponse> modifyBoard(@PathVariable("boardId") Long boardId,
    @RequestBody @Valid BoardAddRequest request) {
    return ResponseEntity.ok(boardService.modifyBoard(boardId, request));
  }

  @GetMapping("/{boardId}")
  public ResponseEntity<CommonResponse> getBoard(@PathVariable("boardId") Long boardId) {
    return ResponseEntity.ok(boardService.getBoard(boardId));
  }
}
