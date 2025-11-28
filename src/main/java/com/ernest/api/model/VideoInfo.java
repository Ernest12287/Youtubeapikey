package com.ernest.api.model;

import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.stream.AudioStream;
import java.util.List;

public class VideoInfo {
    private String title;
    private String description;
    private long duration;
    private long viewCount;
    private String uploader;
    private String uploaderName;
    private String thumbnailUrl;
    private List<VideoStream> videoStreams;
    private List<AudioStream> audioStreams;
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public long getDuration() { return duration; }
    public void setDuration(long duration) { this.duration = duration; }
    
    public long getViewCount() { return viewCount; }
    public void setViewCount(long viewCount) { this.viewCount = viewCount; }
    
    public String getUploader() { return uploader; }
    public void setUploader(String uploader) { this.uploader = uploader; }
    
    public String getUploaderName() { return uploaderName; }
    public void setUploaderName(String uploaderName) { this.uploaderName = uploaderName; }
    
    public String getThumbnailUrl() { return thumbnailUrl; }
    public void setThumbnailUrl(String thumbnailUrl) { this.thumbnailUrl = thumbnailUrl; }
    
    public List<VideoStream> getVideoStreams() { return videoStreams; }
    public void setVideoStreams(List<VideoStream> videoStreams) { 
        this.videoStreams = videoStreams; 
    }
    
    public List<AudioStream> getAudioStreams() { return audioStreams; }
    public void setAudioStreams(List<AudioStream> audioStreams) { 
        this.audioStreams = audioStreams; 
    }
}