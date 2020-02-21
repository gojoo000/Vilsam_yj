package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.svc.MemberJoinService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberJoinAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		MemberBean member = new MemberBean();
		boolean joinResult = false;

		System.out.println("@@@@");
		
		member.setMEMBER_ID(request.getParameter("MEMBER_ID"));
		member.setMEMBER_PW(request.getParameter("MEMBER_PW"));
		member.setMEMBER_NAME(request.getParameter("MEMBER_NAME"));
		member.setMEMBER_GENDER(request.getParameter("MEMBER_GENDER"));
		member.setMEMBER_EMAIL(request.getParameter("MEMBER_EMAIL"));
		member.setMEMBER_ZIPCODE(request.getParameter("MEMBER_ZIPCODE"));
		member.setMEMBER_ADDR1(request.getParameter("MEMBER_ADDR1"));
		member.setMEMBER_ADDR2(request.getParameter("MEMBER_ADDR2"));
		member.setMEMBER_PHONE1(request.getParameter("MEMBER_PHONE1"));
		member.setMEMBER_PHONE2(request.getParameter("MEMBER_PHONE2"));
		member.setMEMBER_BIRTH(request.getParameter("MEMBER_BIRTH"));
		
		
		
		MemberJoinService memberJoinService = new MemberJoinService();
		joinResult = memberJoinService.joinMember(member);

		ActionForward forward = null;
		if (joinResult == false) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입 실패')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./memberLogin.me");
			request.getSession().setAttribute("msg", "1");
			
		}
		return forward;
	}
}