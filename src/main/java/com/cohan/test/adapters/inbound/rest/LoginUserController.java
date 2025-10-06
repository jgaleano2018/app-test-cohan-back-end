package com.cohan.test.adapters.inbound.rest;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginUserController {

    @GetMapping("/public/hello")
    public String publicHello() {
        return "hello public";
    }

    @GetMapping("/private/hello")
    public String privateHello(@AuthenticationPrincipal Jwt jwt) {
        return "hello " + jwt.getJwkSetUri();
    }

    @GetMapping("/admin/secret")
    @PreAuthorize("hasRole('admin')")
    public String adminSecret() {
        return "top secret";
    }
}