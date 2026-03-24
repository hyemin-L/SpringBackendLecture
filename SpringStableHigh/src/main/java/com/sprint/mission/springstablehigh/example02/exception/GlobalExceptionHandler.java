package com.sprint.mission.springstablehigh.example02.exception;


import com.sprint.mission.springstablehigh.example02.dto.ErrorResponse;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(DuplicateEmailException.class)
  public ResponseEntity<ErrorResponse> handleDuplicateEmail(DuplicateEmailException e) {

    return ResponseEntity
        .badRequest()
        .body(ErrorResponse.of(
            "USER_001",
            e.getMessage(),
            Map.of("email", e.getEmail())
        ));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleException(Exception e) {

    return ResponseEntity
        .internalServerError()
        .body(ErrorResponse.of(
            "SERVER_001",
            "일시적인 서버 오류가 발생했습니다"
        ));
  }
}
