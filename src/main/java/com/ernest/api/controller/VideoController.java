package com.ernest.api.controller;

import com.ernest.api.model.VideoInfo;
import com.ernest.api.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class VideoController {
    
    @Autowired
    private VideoService videoService;
    
    @GetMapping("/info")
    public ResponseEntity<VideoInfo> getVideoInfo(
            @RequestParam String url,
            @RequestHeader(value = "X-API-Key", required = false) String apiKey) {
        
        if (!isValidApiKey(apiKey)) {
            return ResponseEntity.status(401).build();
        }
        
        try {
            VideoInfo info = videoService.getVideoInfo(url);
            return ResponseEntity.ok(info);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/download")
    public ResponseEntity<VideoInfo> getDownloadLinks(
            @RequestParam String url,
            @RequestParam(defaultValue = "720p") String quality,
            @RequestHeader(value = "X-API-Key", required = false) String apiKey) {
        
        if (!isValidApiKey(apiKey)) {
            return ResponseEntity.status(401).build();
        }
        
        try {
            VideoInfo info = videoService.getDownloadLinks(url, quality);
            return ResponseEntity.ok(info);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    private boolean isValidApiKey(String apiKey) {
        String validKey = System.getenv("API_KEY");
        return validKey != null && validKey.equals(apiKey);
    }
}