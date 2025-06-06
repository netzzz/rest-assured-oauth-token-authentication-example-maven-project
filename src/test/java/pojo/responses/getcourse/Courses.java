package pojo.responses.getcourse;

import java.util.List;

public class Courses {
	private List<Course> webAutomation;
	private List<Course> api;
	private List<Course> mobile;

	public Courses() {
	}

	public List<Course> getWebAutomation() {
		return webAutomation;
	}

	public void setWebAutomation(List<Course> webAutomation) {
		this.webAutomation = webAutomation;
	}

	public List<Course> getApi() {
		return api;
	}

	public void setApi(List<Course> api) {
		this.api = api;
	}

	public List<Course> getMobile() {
		return mobile;
	}

	public void setMobile(List<Course> mobile) {
		this.mobile = mobile;
	}
}
