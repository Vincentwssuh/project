package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardDAO;
import net.board.db.BoardDTO;

public class BoardAddAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		System.out.println("boardAddAction");
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = new BoardDTO();
		
		try {
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			String email = request.getParameter("email");
			String name = request.getParameter("name");
			String nickname = request.getParameter("nickname");
			String phone = request.getParameter("phone");
			
			dto.setId(id);
			dto.setPasswd(passwd);
			dto.setEmail(email);
			dto.setName(name);
			dto.setNickname(nickname);
			dto.setPhone(phone);
			
			dao.BoardJoin(dto);
			ActionForward forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("/testpro/board/index.jsp");
			return forward;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
