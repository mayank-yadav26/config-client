package com.example.configclient.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RefreshScope
public class ConfigController {

    @Value("${app.name:Default App}")
    private String appName;

    @Value("${app.version:1.0.0}")
    private String appVersion;

    @Value("${app.description:Default Description}")
    private String appDescription;

    @Value("${db.url:jdbc:h2:mem:testdb}")
    private String dbUrl;

    @Value("${db.username:sa}")
    private String dbUsername;

    @Value("${feature.new-feature:false}")
    private boolean newFeature;

    @Value("${feature.experimental:false}")
    private boolean experimentalFeature;

    @Value("${debug.enabled:false}")
    private boolean debugEnabled;

    @GetMapping("/config")
    public Map<String, Object> getConfiguration() {
        Map<String, Object> config = new HashMap<>();
        config.put("appName", appName);
        config.put("appVersion", appVersion);
        config.put("appDescription", appDescription);
        config.put("dbUrl", dbUrl);
        config.put("dbUsername", dbUsername);
        config.put("newFeature", newFeature);
        config.put("experimentalFeature", experimentalFeature);
        config.put("debugEnabled", debugEnabled);
        return config;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "UP");
        status.put("app", appName);
        status.put("version", appVersion);
        return status;
    }

    @GetMapping("/features")
    public Map<String, Boolean> getFeatures() {
        Map<String, Boolean> features = new HashMap<>();
        features.put("newFeature", newFeature);
        features.put("experimentalFeature", experimentalFeature);
        features.put("debugEnabled", debugEnabled);
        return features;
    }
}
