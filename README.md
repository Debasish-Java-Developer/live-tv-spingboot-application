# 📺 Live TV Streaming Application (Spring Boot IPTV)

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![IPTV](https://img.shields.io/badge/IPTV-Streaming-blue)
![Status](https://img.shields.io/badge/Status-Active-success)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

---

## 🔍 Live TV Streaming Application using Spring Boot (IPTV Player)

This project is a **Live TV Streaming Application built using Java Spring Boot** that consumes IPTV channels from a public M3U playlist.

It provides a simple backend API and UI to stream live TV channels using:

* IPTV M3U playlist
* REST API (Spring Boot)
* HTML, CSS frontend

👉 IPTV Source Used:
https://iptv-org.github.io/iptv/index.m3u

👉 To Start Play run post starting tha main application:
http://localhost:8080/player.html

---

## 🚀 Keywords

> Live TV Spring Boot Application, IPTV Player Java, Spring Boot Streaming App, M3U IPTV Player, Free Live TV Streaming Java, REST API IPTV, Java Backend Streaming Project

---

## 📌 Features

* 📡 Stream Live TV Channels using IPTV
* 🔗 Parse M3U playlist dynamically
* ⚡ REST API for channel listing
* 🌐 Simple UI using HTML & CSS
* 🔍 Lightweight and fast backend
* 🧪 Beginner-friendly project

---

## 🧭 How It Works (Architecture)
Will update the flow in next iteration.

### Flow

```id="flowiptv"
Client (Browser)
    ↓
Spring Boot Backend
    ↓
Fetch IPTV M3U Playlist
    ↓
Parse Channels
    ↓
Expose REST API
    ↓
Frontend Displays Channels
    ↓
User Streams Video
```

---

## 🟢 API Endpoints

| Method | Endpoint          | Description                     |
| ------ | ----------------- | ------------------------------- |
| GET    | `/channels`       | Fetch all available TV channels |
| GET    | `/play/{channel}` | Play selected channel           |

---

## 🧪 Sample Spring Boot Code

### Definition

This example fetches IPTV playlist and returns channel list.

```java id="iptvcode1"
package com.example.livetv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@SpringBootApplication
@RestController
public class LiveTvApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiveTvApplication.class, args);
    }

    @GetMapping("/channels")
    public List<String> getChannels() {

        // Step 1: Simulate IPTV parsing (normally parse M3U file)
        List<String> channels = new ArrayList<>();

        // Step 2: Add sample channels
        channels.add("News Channel");
        channels.add("Sports Channel");
        channels.add("Music Channel");

        // Step 3: Return response
        return channels;
    }

    @GetMapping("/play/{channel}")
    public String playChannel(@PathVariable String channel) {

        // Step 1: Receive channel request
        System.out.println("Playing: " + channel);

        // Step 2: Return streaming URL (dummy)
        return "Streaming URL for " + channel;
    }
}
```

---

## 📊 Complexity

| Type             | Complexity |
| ---------------- | ---------- |
| Time Complexity  | O(n)       |
| Space Complexity | O(n)       |

### Explanation

* Parsing M3U playlist takes linear time
* Stores channel list in memory

---

## 🎯 Use Cases

* IPTV Player Development
* Video Streaming Backend
* Spring Boot Practice Project
* REST API Design
* Beginner Streaming App

---

## 🚀 Future Enhancements

* 🎥 HLS Video Streaming Support
* 🔐 Authentication & Subscription
* 📱 Mobile Responsive UI and App
* ⚡ Caching for performance
* 🌍 Multi-language support

---

## 📈 SEO Boost Tips (Already Applied)

* ✔ Keyword-rich headings
* ✔ Repeated important terms (Spring Boot IPTV, Live TV App)
* ✔ Structured content
* ✔ Clear project description
* ✔ Technical + beginner-friendly

---

## ⭐ Contribute

Feel free to fork and improve this project.

## 🙌 Support

If you like this project, give it a ⭐ on GitHub!
