package org.yeoff.controller;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommunityController {

  @GetMapping("/test")
  public ResponseEntity<?> test() {
    return ResponseEntity.ok(Map.of("test", "hi"));
  }
}
