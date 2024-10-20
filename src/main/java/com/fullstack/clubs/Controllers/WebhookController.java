package com.fullstack.clubs.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook-receiver")
public class WebhookController {

    @PostMapping
    public ResponseEntity<String> handleWebhook(@RequestBody String payload) {
        System.out.println("Received webhook payload: " + payload);

        return ResponseEntity.ok("Webhook received");
    }
}
