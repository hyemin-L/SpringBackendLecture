package com.sprint.mission.springsecuritysessionbasedarchi.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class UserSessionMetadata {

  private String username;

  private LocalDateTime loginTime;
}