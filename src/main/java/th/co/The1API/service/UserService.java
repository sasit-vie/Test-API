package th.co.The1API.service;

import th.co.The1API.model.UserInfoModel;

public interface UserService {

	public UserInfoModel getInfo(String seed) throws Exception;
	public UserInfoModel getUserInfowithSeed(String seed) throws Exception;
}
