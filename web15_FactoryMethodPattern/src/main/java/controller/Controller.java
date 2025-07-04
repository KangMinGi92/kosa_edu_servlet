package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	String requestHandle(HttpServletRequest request,HttpServletResponse response);
}
