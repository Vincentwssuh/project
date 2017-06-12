package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.action.Action;
import net.board.action.ActionForward;
import net.board.action.BoardAddAction;
import net.board.action.BoardLogin;
import net.board.action.Logout;
import net.board.action.MemberFind;
import net.board.action.MemberUpdate;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.do")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		System.out.println("RequestURI = "+RequestURI);
		System.out.println("contextPath = "+contextPath);
		System.out.println("command = "+command);
		
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/BoardAddAction.do")){
			try {
				action = new BoardAddAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}else if(command.equals("/BoardLogin.do")){
			try {
				action = new BoardLogin();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/Logout.do")){
			try {
				action = new Logout();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}else if(command.equals("/MemberFind.do")){
			try{
				action = new MemberFind();
				forward = action.execute(request, response);
			}catch (Exception e){
				e.printStackTrace();
			}
			
		}else if(command.equals("/MemberUpdate.do")){
			try {
				action = new MemberUpdate();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/menu1.do")){
			try{
				action = new MemberUpdate();
			} catch (Exception e){
				e.printStackTrace();
			}
		}else if (command.equals("/menu2.do")){
			try{
				action = new MemberUpdate();
			} catch (Exception e){
				e.printStackTrace();
			}
		}else if (command.equals("/menu3.do")){
			try{
				action = new MemberUpdate();
			} catch (Exception e){
				e.printStackTrace();
			}
		}else if (command.equals("/menu4.do")){
			try{
				action = new MemberUpdate();
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		
		
		//forwarding
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get");
		
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
		
		doProcess(request, response);
	}

}
