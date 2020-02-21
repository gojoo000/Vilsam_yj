package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.MemberLoginService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberLoginAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		MemberBean member = new MemberBean();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		member.setMEMBER_ID(request.getParameter("MEMBER_ID"));
		member.setMEMBER_PW(request.getParameter("MEMBER_PW"));

		MemberLoginService memberLoginService = new MemberLoginService();
		String loginResult = memberLoginService.login(member);
		/* System.out.println(loginResult); */
		ActionForward forward = null;
		forward = new ActionForward();
		
		if (loginResult == null) { /* || loginResult.equals("") */
			out.println("<script>");
			out.println("alert('ID/PW가 일치하지');");
			out.println("location.href='/Vilsam_yj/memberLogin.me';");
			out.println("</script>");
		} else {
			
	   		session.setAttribute("MEMBER_ID", request.getParameter("MEMBER_ID"));
	   		session.setAttribute("MEMBER_TYPE", loginResult);
			
			if (loginResult.equals("admin")) {
				forward.setPath("/memberListAction.me");
			} else {
				 forward.setPath("/index.jsp"); 
			}
		}
		/* System.out.println(session.getAttribute("MEMBER_ID")); */
		return forward;
	}
}