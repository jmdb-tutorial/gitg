package jmdbtutorial.gitg;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TagValidatorController {

	@RequestMapping("/tagvalidator")
    public ResponseEntity<String> tagvalidator() {
    
        return ResponseEntity.ok(HttpsChecker.check());
    }
	
}
