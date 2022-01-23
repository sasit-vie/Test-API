package th.co.The1API.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import th.co.The1API.model.UserInfoModel;
import th.co.The1API.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Value("${randomuser.url}")
	private String randomuserUrl;

	@Override
	public UserInfoModel getInfo(String seed) throws Exception {
		// TODO Auto-generated method stub
		UserInfoModel userInfo = null;

		try {
			userInfo = randomUser();
		} catch (Exception ex) {
			throw ex;
		}

		return userInfo;
	}

	@Override
	@Cacheable(value = "userInfo", key = "#seed", unless = "#result==null")
	public UserInfoModel getUserInfowithSeed(String seed) throws Exception {
		UserInfoModel userInfo = null;

		try {
			userInfo = randomUserWithSeed(seed);
		} catch (Exception ex) {
			throw ex;
		}

		return userInfo;
	}

	@CachePut(value = "userInfo", key = "#seed")
	private UserInfoModel randomUserWithSeed(String seed) throws Exception {
		UserInfoModel userInfo = null;

		try {

			String url = randomuserUrl + "/?seed=" + seed;
			userInfo = cllAPIRandowUser(url);

		} catch (Exception ex) {
			throw ex;
		}

		return userInfo;
	}

	private UserInfoModel randomUser() throws Exception {
		UserInfoModel userInfo = null;

		try {
			String url = randomuserUrl;
			userInfo = cllAPIRandowUser(url);

		} catch (Exception ex) {
			throw ex;
		}

		return userInfo;
	}

	private UserInfoModel cllAPIRandowUser(String url) throws Exception {
		UserInfoModel userInfo = null;

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			RestTemplate template = new RestTemplate();

			String result = template.getForObject(url, String.class);
			JsonNode node = objectMapper.readValue(result, JsonNode.class);

			if (node.has("results")) {
				Gson gson = new Gson();
				List<UserInfoModel> userInfoList = gson.fromJson(node.get("results").toString(),
						new TypeToken<List<UserInfoModel>>() {
						}.getType());
				System.out.println("userInfo : " + gson.toJson(userInfoList));
				if (userInfoList != null && userInfoList.size() > 0) {
					userInfo = userInfoList.get(0);
				}
			}

		} catch (Exception ex) {
			throw ex;
		}

		return userInfo;
	}

}
