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

![Image](https://images.openai.com/static-rsc-4/FG4kbS1wGVsTwqUcaf_5nmm6aKz72Ws7gT47x2ZJKM92VB9IrrSHYoZ9mi6At6HCOhi7szEtRfYMJefm78oQQlX1CQBSGjvUEJSCIE7KSz-UCnh6d6nxE8dGzmB4XG1_0Yng2Nrpy2K0H5cmmcIGpJsbbmhAlrEHrtWlNVPDwoze6FkGtE8smc4xmICfX9YW?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/MVSj8BqXeSyFuvC2FioedBKw1pHB4KUSkZhWuUzDks55dVsLwaOXIR90YYvyQ-lkhY0UxlywxsS32Mi2wqN-7BDegh2QANQUO_-frR_KTbErWRLBNhqqvcrolI3yR8IqXvaNLr6kgSRaXEWjXKplvlQsQdGmUkIwhzSeX9XFywM7EJELtEWGQu0iah-vJVjg?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/957Ougx2-XfVHR3LjLunsdErslbqH6BIiYa1FpyaHNBJHgZOtKGDHqKSs09vxNTSECIvmL8YoIpdKwQSwIXe8RLz3vsl6XXhhw5aW97fDVyESah4-WKbXRzAvCZUgX8xWNBam-DOOxxaJsD9sypNL_M4cOtYgJu3oklJFP_qtmhuwjLzKHNMupXjX75TCFpo?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/_co2aAhfQTKd6nPR0fp90UNACZx9HV2V711HrnUepTh-53kt4aP-eKMbJAOqihIHh3bqPjQ0yndwmjGcMArIbA5_DfWvI6Ci4_0kINXXXI9PVkcFgrt1QaLCQSFW0dqmwiqmiOub2jcIx5Inxijpe96q7brOcnFSRFruNAQYpGO6H8kzORw1KOpd6DOjBYby?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/WYAARhyO-ySZNHxExQnV3uP6NHWmi88yBZD1ywmYzMv2WbAQbYuJwmK0k9ObQbLXqe-_kabjrUr4xCzym2DSIrte8Ft5yW1fYcHjLffcKF14j_aGWbJZ1x1RdOC-_K8FUc9O0ICoHwRfXDoi9UGd3OWbgCib5ceYBHOAECNzbTkl-QMyF8LHVzNYuNk0nqxY?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/QSM7V71uLFIbgnDR2tynr4eW2NSES4yaKTpz-zbhAJb5N5DANPIypIHLktPOgPAPS5sxNnAzSX-XAPLLDHU2AuV6wnyxA_WqiGyoqPwdL2OFQ9rmJujClYB1rEe2j-707KXeH03QAill0dY0NHOmjVe5KMCE_ELtpRcACAM1OZhtbMUz99h_PIN-D1GUECML?purpose=fullsize)

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
