package th.co.The1API.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import th.co.The1API.model.ResponseModel;
import th.co.The1API.model.UserInfoModel;
import th.co.The1API.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/getInfo")
	public ResponseModel getInfo(@RequestBody String request) {
		ResponseModel result = new ResponseModel();
		try {
			
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> jsonMap = objectMapper.readValue(request, new TypeReference<Map<String, Object>>() {});
			String seed = jsonMap.get("seed") != null ? jsonMap.get("seed").toString() : "";
			
			UserInfoModel usermodel = null;
			if (seed.isEmpty()) {
				usermodel = userService.getInfo(seed);
			} else {
				usermodel = userService.getUserInfowithSeed(seed);
			}
			
			//UserInfoModel usermodel = userService.getInfo(seed);
			
			if(usermodel != null) {
				result.setCode("S");
				result.setResult(usermodel);
				result.setDescription("success");
			} else {
				result.setCode("N");
				result.setDescription("Not found");
			}
			

		} catch (Exception ex) {
			ex.getStackTrace();
			result.setCode("E");
			result.setDescription(ex.getMessage());
		}

		return result;
	}
}
