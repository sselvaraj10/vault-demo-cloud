package com.example.vaultdemo.controller;

import com.example.vaultdemo.service.SecretService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/secrets")
public class SecretController {

    private final SecretService secretService;

    public SecretController(SecretService secretService) {
        this.secretService = secretService;
    }

    @GetMapping("/{path}")
    public Map<String, Object> getSecret(@PathVariable String path) {
        return secretService.readSecret(path);
    }

    @PostMapping("/{path}")
    public String writeSecret(@PathVariable String path, @RequestBody Map<String, Object> data) {
        secretService.writeSecret(path, data);
        return "Secret written to path: " + path;
    }
}
