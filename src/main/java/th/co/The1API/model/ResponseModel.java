package th.co.The1API.model;

import java.io.Serializable;

public class ResponseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3389393561076621507L;

	private String code;
	private Object result;
	private String description;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
