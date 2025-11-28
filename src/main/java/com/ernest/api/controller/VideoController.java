package com.ernest.api.controller;

import com.ernest.api.model.VideoInfo;
import com.ernest.api.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1")
public class VideoController {
    
    private static final Logger logger = LoggerFactory.getLogger(VideoController.class);
    
    @Autowired
    private VideoService videoService;
    
    @GetMapping("/info")
    public ResponseEntity<VideoInfo> getVideoInfo(
            @RequestParam String url,
            @RequestHeader(value = "X-API-Key", required = false) String apiKey) {
        
        if (!isValidApiKey(apiKey)) {
            logger.warn("Invalid API key attempt");
            return ResponseEntity.status(401).build();
        }
        
        try {
            logger.info("Fetching video info for URL: {}", url);
            VideoInfo info = videoService.getVideoInfo(url);
            logger.info("Successfully fetched video info");
            return ResponseEntity.ok(info);
        } catch (Exception e) {
            logger.error("Error fetching video info: ", e);
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/download")
    public ResponseEntity<VideoInfo> getDownloadLinks(
            @RequestParam String url,
            @RequestParam(defaultValue = "720p") String quality,
            @RequestHeader(value = "X-API-Key", required = false) String apiKey) {
        
        if (!isValidApiKey(apiKey)) {
            logger.warn("Invalid API key attempt");
            return ResponseEntity.status(401).build();
        }
        
        try {
            logger.info("Fetching download links for URL: {}", url);
            VideoInfo info = videoService.getDownloadLinks(url, quality);
            logger.info("Successfully fetched download links");
            return ResponseEntity.ok(info);
        } catch (Exception e) {
            logger.error("Error fetching download links: ", e);
            return ResponseEntity.badRequest().build();
        }
    }
    
    private boolean isValidApiKey(String apiKey) {
        String validKey = System.getenv("API_KEY");
        return validKey != null && validKey.equals(apiKey);
    }
}