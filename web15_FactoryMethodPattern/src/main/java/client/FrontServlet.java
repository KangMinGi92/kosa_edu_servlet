package client;

import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ControllerFactory;

//원래 서블릿 코드가 될 것이다.
public class FrontServlet {
	static HttpServletRequest request = null;
	static HttpServletResponse response = null;
	public static void main(String[] args) {
		//폼값 받아서...
		Scanner sc = new Scanner(System.in);
		System.out.println("Command값 입력 >>>>>>>>>>>>>>");
		
		String command = sc.next();
		
		//1.
		Controller controller=ControllerFactory.getInstance().createController(command);
		
		//2.
		String path=controller.requestHandle(request, response);
		
		//3.
		System.out.println("페이지 이동..."+path);
	}

}
