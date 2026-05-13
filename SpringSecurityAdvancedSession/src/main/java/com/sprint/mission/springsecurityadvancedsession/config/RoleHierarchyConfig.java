package com.sprint.mission.springsecurityadvancedsession.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

@Configuration
public class RoleHierarchyConfig {

  @Bean
  public RoleHierarchy roleHierarchy() {
    RoleHierarchyImpl hierarchy = new RoleHierarchyImpl();

    // 계층 구조 정의: 상위 역할은 하위 역할의 모든 권한을 포함
    String roleHierarchyString = """
            ROLE_SUPER_ADMIN > ROLE_ADMIN
            ROLE_ADMIN > ROLE_MANAGER
            ROLE_MANAGER > ROLE_USER
            ROLE_USER > ROLE_GUEST
            """;

    hierarchy.setHierarchy(roleHierarchyString);
    return hierarchy;
  }

  // RoleHierarchy를 사용하는 AuthorizationManager 설정
  @Bean
  public AuthorizationManager<RequestAuthorizationContext> hierarchicalAuthorizationManager() {
    return new AuthorityAuthorizationManagerWithHierarchy(roleHierarchy());
  }
}