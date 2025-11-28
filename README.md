```markdown
# YouTube Download API

A REST API for downloading YouTube videos using NewPipe Extractor.

## Live API
**Base URL:** `https://youtubeapikey-peaseernest.onrender.com`

## API Key
All requests require authentication using the API key in the request header:
```
X-API-Key: peaseernest
```

## API Endpoints

### 1. Get Video Info
Get basic information about a YouTube video.

**Endpoint:** `GET /api/v1/info`

**Parameters:**
- `url` (required) - YouTube video URL

**Example Request:**
```bash
curl -X GET "https://youtubeapikey-peaseernest.onrender.com/api/v1/info?url=https://youtube.com/watch?v=dQw4w9WgXcQ" \
  -H "X-API-Key: peaseernest"
```

**Example Response:**
```json
{
  "title": "Video Title",
  "description": "Video description",
  "duration": 300,
  "viewCount": 1000000,
  "uploaderName": "Channel Name",
  "thumbnailUrl": "https://...",
  "videoStreams": null,
  "audioStreams": null
}
```

### 2. Get Download Links
Get video and audio download links with quality options.

**Endpoint:** `GET /api/v1/download`

**Parameters:**
- `url` (required) - YouTube video URL
- `quality` (optional, default: 720p) - Video quality preference

**Example Request:**
```bash
curl -X GET "https://youtubeapikey-peaseernest.onrender.com/api/v1/download?url=https://youtube.com/watch?v=dQw4w9WgXcQ&quality=1080p" \
  -H "X-API-Key: peaseernest"
```

**Example Response:**
```json
{
  "title": "Video Title",
  "description": "Video description",
  "duration": 300,
  "viewCount": 1000000,
  "uploaderName": "Channel Name",
  "thumbnailUrl": "https://...",
  "videoStreams": [
    {
      "content": "https://...",
      "format": "MPEG_4",
      "resolution": "1080p"
    }
  ],
  "audioStreams": [
    {
      "content": "https://...",
      "format": "M4A",
      "averageBitrate": 128000
    }
  ]
}
```

## Status Codes
- `200 OK` - Request successful
- `401 Unauthorized` - Invalid or missing API key
- `400 Bad Request` - Invalid URL or other error

## Local Development

### Setup
1. Clone the repository
2. Set API key environment variable:
   ```bash
   export API_KEY=peaseernest
   ```
3. Build the project:
   ```bash
   ./gradlew build
   ```
4. Run the application:
   ```bash
   ./gradlew bootRun
   ```

The API will be available at `http://localhost:8080`

## Deploy to Render

1. Create new Web Service on Render
2. Connect your GitHub repository
3. Configure:
   - **Environment:** Docker
   - **Add environment variable:** `API_KEY=peaseernest`
4. Deploy!

## Technologies Used
- Spring Boot 3.4.0
- NewPipe Extractor v0.24.8
- Java 17
- Gradle 8.5

## Security Note
⚠️ **Keep your API key secure!** The default key `peaseernest` is shown here for demonstration. In production, use a strong, unique API key and never commit it to version control.
```