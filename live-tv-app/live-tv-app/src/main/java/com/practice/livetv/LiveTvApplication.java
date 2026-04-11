package com.practice.livetv;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LiveTvApplication {
    static List<Map<String, String>> channelList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        SpringApplication.run(LiveTvApplication.class, args);
        String playlistUrl = "https://iptv-org.github.io/iptv/index.m3u";
        URL url = new URL(playlistUrl);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(url.openStream())
        );

        String line;
        String channelName = "";
        String channelLogo = "";
        String channelGroup = "";
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("#EXTINF")) {
                channelName = line.substring(line.lastIndexOf(",") + 1).trim();
                if (line.contains("tvg-logo")) {
                    channelLogo = line.split("tvg-logo=\"")[1].split("\"")[0];
                } else {
                    channelLogo = "";
                }

                if (line.contains("group-title")) {
                    channelGroup = line.split("group-title=\"")[1].split("\"")[0];
                } else {
                    channelGroup = "";
                }

            }

            else if (line.startsWith("http")) {

                Map<String, String> channel = new HashMap<>();
                channel.put("name", channelName);
                channel.put("logo", channelLogo);
                channel.put("group", channelGroup);
                channel.put("streamUrl", line.trim());
                channelList.add(channel);
            }
        }

        reader.close();
        System.out.println("Total Channels Loaded: " + channelList.size());
    }

    // API 1 : Get all channels
    
    @GetMapping("/channels")
    public List<Map<String, String>> getAllChannels() {
        List<Map<String, String>> response = new ArrayList<>();
        for (Map<String, String> channel : channelList) {
            Map<String, String> data = new HashMap<>();
            data.put("name", channel.get("name"));
            data.put("logo", channel.get("logo"));
            data.put("group", channel.get("group"));

            response.add(data);
        }

        return response;
    }
  
    @GetMapping("/channels/play")
    public Map<String, String> playChannel(@RequestParam String name) {

        for (Map<String, String> channel : channelList) {

            if (channel.get("name").equalsIgnoreCase(name)) {

                Map<String, String> response = new HashMap<>();
                response.put("streamUrl", channel.get("streamUrl"));
                return response;
            }
        }
        Map<String, String> error = new HashMap<>();
        error.put("error", "Channel not found");
        return error;
    }
}

/*
 * 1. Load M3U playlist from URL and parse channel information (name, logo, group, stream URL).
 * 2. Store channel information in a list.
 * 3. Create API endpoint to return all channels (name, logo, group).
 * 4. Create API endpoint to return stream URL for a given channel name.
 * 5. Handle errors (e.g., channel not found).
 */

/*To run channels and for better viewing experience open the stream URL in a chrome media player after starting the main application run http://localhost:8080/player.html */