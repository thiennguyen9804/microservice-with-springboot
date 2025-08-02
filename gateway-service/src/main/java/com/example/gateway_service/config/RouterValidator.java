package com.example.gateway_service.config;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;

public class RouterValidator {
  public static final List<String> openApiEndpoints = List.of(
      "/auth/register",
      "/auth/login");
  public Predicate<ServerHttpRequest> isSecured = new Predicate<ServerHttpRequest>() {

    @Override
    public boolean test(ServerHttpRequest request) {
      return openApiEndpoints.stream().noneMatch(uri -> request.getURI().getPath().contains(uri));
    }

  };
}
