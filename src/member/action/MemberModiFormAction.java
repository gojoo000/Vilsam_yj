package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.MemberInfoService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberModiFormAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = null;
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();

		if (session.getAttribute("MEMBER_ID") != null) {
			id = request.getParameter("MEMBER_ID");
			MemberInfoService memberInfoService = new MemberInfoService();
			MemberBean memberInfo = new MemberBean();
			memberInfo = memberInfoService.getMemberInfo(id);
			request.setAttribute("member", memberInfo);
			forward.setPath("/jsp/member/member_info.jsp");
			//forward.setPath("/jsp/member/member_modiFY.jsp");
			request.getSession().setAttribute("msg", "0");

		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정할 권한이 없습니다!')");
			out.println("location.href='/jsp/loginForm.jsp'");
			out.println("</script>");
		}
		return forward;
	}
}
