package com.ernest.api.service;

import com.ernest.api.model.VideoInfo;
import org.schabi.newpipe.extractor.ServiceList;
import org.schabi.newpipe.extractor.stream.StreamInfo;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.stream.AudioStream;
import org.schabi.newpipe.extractor.Image;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VideoService {

    public VideoInfo getVideoInfo(String url) throws Exception {
        StreamInfo info = StreamInfo.getInfo(ServiceList.YouTube, url);
        
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setTitle(info.getName());
        videoInfo.setDescription(info.getDescription().getContent());
        videoInfo.setDuration(info.getDuration());
        videoInfo.setViewCount(info.getViewCount());
        
        List<Image> thumbnails = info.getThumbnails();
        if (!thumbnails.isEmpty()) {
            videoInfo.setThumbnailUrl(thumbnails.get(0).getUrl());
        }
        videoInfo.setUploaderName(info.getUploaderName());
        
        return videoInfo;
    }

    public VideoInfo getDownloadLinks(String url, String quality) throws Exception {
        StreamInfo info = StreamInfo.getInfo(ServiceList.YouTube, url);
        
        VideoInfo videoInfo = getVideoInfo(url);
        
        videoInfo.setVideoStreams(info.getVideoStreams());
        videoInfo.setAudioStreams(info.getAudioStreams());
        
        return videoInfo;
    }
}