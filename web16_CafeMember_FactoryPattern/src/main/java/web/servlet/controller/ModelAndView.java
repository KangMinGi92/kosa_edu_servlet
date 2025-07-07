package web.servlet.controller;

//결과페이지의 이름과 페이지 이동방법을 저장하는 클래스
public class ModelAndView {
	
	private String path; //결과페이지 이름
	private boolean isRedirect;//이동방식
	
	public ModelAndView() {
	}
	
	public ModelAndView(String path) {
		this.path = path;
	}
	
	public ModelAndView(String path, boolean isRedirect) {
		this.path = path;
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}
	
	
	
}
