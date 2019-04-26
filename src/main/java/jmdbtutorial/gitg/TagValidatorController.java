package jmdbtutorial.gitg;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagValidatorController {

	@PostMapping("/tagvalidator")
	public ResponseEntity<String> tagvalidator(@RequestBody String tag) {
		return ResponseEntity.ok(HttpsChecker.check(tag));
	}

}
