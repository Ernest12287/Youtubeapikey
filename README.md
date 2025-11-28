/ README.md
# YouTube Download API

A REST API for downloading YouTube videos using NewPipe Extractor.

## Setup

1. Build: `./gradlew build`
2. Set API key: `export API_KEY=peaseernest`
3. Run: `./gradlew bootRun`

## Deploy to Render

1. Create new Web Service on Render
2. Connect your GitHub repo
3. Add environment variable: `API_KEY=peaseernest`
4. Build command: `./gradlew build`
5. Start command: `java -jar build/libs/*.jar`

## API Endpoints

### Get Video Info
```
GET /api/v1/info?url=https://youtube.com/watch?v=VIDEO_ID
Header: X-API-Key: your-api-key
```

### Get Download Links
```
GET /api/v1/download?url=https://youtube.com/watch?v=VIDEO_ID&quality=720p
Header: X-API-Key: your-api-key
```

## Example Response
```json
{
  "title": "Video Title",
  "description": "Video description",
  "duration": 300,
  "viewCount": 1000000,
  "uploader": "Channel Name",
  "thumbnailUrl": "https://...",
  "videoStreams": [
    {
      "url": "https://...",
      "format": "MPEG_4",
      "quality": "1080p"
    }
  ],
  "audioStreams": [
    {
      "url": "https://...",
      "format": "M4A",
      "quality": "128 kbps"
    }
  ]
}
```

## Note
Your API key is: `peaseernest` - Keep this secure!