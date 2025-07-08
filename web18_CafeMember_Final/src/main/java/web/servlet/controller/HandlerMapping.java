package web.servlet.controller;


//이전의 ControllerFactory이름을 만들었던 
//Component를 생성하는 공장의 역할
//싱글톤 패턴으로 생성...
public class HandlerMapping {
	
	private static HandlerMapping factory = new HandlerMapping();
	
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return factory;
	}
	
	//Componenet를 생성하는 기능...
	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("find.do")) {
			controller = new FindController();
			System.out.println("FindController...생성...");
		}else if(command.equals("register.do")) {//회원등록 요청이 들어왔다면,
			controller= new RegisterController();
			System.out.println("RegisterController...생성...");
		}else if(command.equals("login.do")) {//로그인 요청이 들어왔다면,
			controller= new LoginController();
			System.out.println("LoginController...생성...");
		}else if(command.equals("allMember.do")) {//전체 검색 요청이 들어왔다면,
			controller= new AllMemberController();
			System.out.println("AllMemberController...생성...");
		}else if(command.equals("logOut.do")) {//로그아웃 요청이 들어왔다면,
			controller= new LogOutController();
			System.out.println("LogOutController...생성...");
		}else if(command.equals("update.do")) {//업데이트 요청이 들어왔다면,
			controller= new UpdateController();
			System.out.println("UpdateController...생성...");
		}else if(command.equals("idExist.do")) {//아이디 중복체크 요청이 들어왔다면,
			controller= new IdExistController();
			System.out.println("IdExistController...생성...");
		}
		return controller;
	}
}
