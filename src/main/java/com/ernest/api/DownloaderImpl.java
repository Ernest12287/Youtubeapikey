package com.ernest.api;

import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.downloader.Request;
import org.schabi.newpipe.extractor.downloader.Response;
import org.schabi.newpipe.extractor.exceptions.ReCaptchaException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class DownloaderImpl extends Downloader {

    @Override
    public Response execute(Request request) throws IOException, ReCaptchaException {
        URL url = new URL(request.url());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(request.httpMethod());
        
        // Fix: headers() returns Map<String, List<String>>, not Map<String, String>
        for (Map.Entry<String, List<String>> header : request.headers().entrySet()) {
            // Join multiple header values with comma
            String value = String.join(", ", header.getValue());
            conn.setRequestProperty(header.getKey(), value);
        }
        
        conn.connect();
        
        int responseCode = conn.getResponseCode();
        InputStream inputStream = conn.getInputStream();
        String responseBody = new String(inputStream.readAllBytes());
        
        // Fix: Response constructor now requires 5 parameters (added ipAddress)
        return new Response(
            responseCode,
            "",  // responseMessage
            conn.getHeaderFields(),
            responseBody,
            request.url()  // ipAddress/request URL
        );
    }
}