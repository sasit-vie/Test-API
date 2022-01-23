package th.co.The1API.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
@CrossOrigin(origins = "*")
public class TestController {
	
	    @GetMapping("/test")
	    public String getVersion() {
	        return "Test";
	    }
}
