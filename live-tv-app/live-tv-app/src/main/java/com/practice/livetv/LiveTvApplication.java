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

    // Store all channels in memory
    static List<Map<String, String>> channelList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        // Start Spring Boot application
        SpringApplication.run(LiveTvApplication.class, args);

        // IPTV playlist URL
        String playlistUrl = "https://iptv-org.github.io/iptv/index.m3u";

        // Open the IPTV playlist URL
        URL url = new URL(playlistUrl);

        // Read playlist line by line
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(url.openStream())
        );

        String line;
        String channelName = "";
        String channelLogo = "";
        String channelGroup = "";

        // Parse M3U file
        while ((line = reader.readLine()) != null) {

            // If metadata line
            if (line.startsWith("#EXTINF")) {

                // Extract channel name
                channelName = line.substring(line.lastIndexOf(",") + 1).trim();

                // Extract channel logo
                if (line.contains("tvg-logo")) {
                    channelLogo = line.split("tvg-logo=\"")[1].split("\"")[0];
                } else {
                    channelLogo = "";
                }

                // Extract channel group
                if (line.contains("group-title")) {
                    channelGroup = line.split("group-title=\"")[1].split("\"")[0];
                } else {
                    channelGroup = "";
                }

            }
            // If stream URL line
            else if (line.startsWith("http")) {

                // Create channel map
                Map<String, String> channel = new HashMap<>();
                channel.put("name", channelName);
                channel.put("logo", channelLogo);
                channel.put("group", channelGroup);
                channel.put("streamUrl", line.trim());

                // Add channel to list
                channelList.add(channel);
            }
        }

        // Close reader
        reader.close();

        // Log loaded channels count
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

    // API 2 : Play selected channel
  
    @GetMapping("/channels/play")
    public Map<String, String> playChannel(@RequestParam String name) {

        for (Map<String, String> channel : channelList) {

            if (channel.get("name").equalsIgnoreCase(name)) {

                Map<String, String> response = new HashMap<>();
                response.put("streamUrl", channel.get("streamUrl"));
                return response;
            }
        }

        // Channel not found
        Map<String, String> error = new HashMap<>();
        error.put("error", "Channel not found");
        return error;
    }
}
