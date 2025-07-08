package com.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algo.Count;
import com.algo.Kickboard;

@WebServlet("/front.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if(command.equals("count")) {
			wordCount(request,response);
		}else if(command.equals("kickboard")) {
			kickboardCount(request,response);
		}
	}//doProcess
	
	private void kickboardCount(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * 1. fname 값 받아서...input.txt
		  
		 * String path =
		  			1) ContextPath/res
		  			2) 1)번의 경로를 path할당
		  
		 * 2. 1번의 값을 가지고 File 객체 생성
		 * 	File f = new File(path,fname);
		 * 3. new Kickboard().execute(f);
		  		out.print(result);
		 */
		String fname=request.getParameter("fname");
		System.out.println(fname);
		System.out.println(request.getContextPath()+"/res");
		System.out.println(request.getRequestURI()+"/res");
		System.out.println(request.getServletContext().getRealPath("/res"));
		String path=request.getServletContext().getRealPath("/res");
		File f = new File(path,fname);
		try {
			int result=new Kickboard().execute(f);
			response.getWriter().print(result); //index.html의 success:function(result)에 담는다.
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	private void wordCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String word = request.getParameter("words");
		String result=new Count().execute(word);
		request.setAttribute("result", result);
		request.getRequestDispatcher("Result.jsp").forward(request, response);
	}
	
}
