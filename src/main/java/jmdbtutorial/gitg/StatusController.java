package jmdbtutorial.gitg;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StatusController {

    @RequestMapping("/status")
    public ResponseEntity<Map> status() {
        Map<String, String> statusJson = new HashMap<>();

        statusJson.put("status", "up");

        return ResponseEntity.ok(statusJson);
    }
}
