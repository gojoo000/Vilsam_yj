package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.MemberViewService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberViewAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("MEMBER_ID");
		String type = (String) session.getAttribute("MEMBER_TYPE");
		
		ActionForward forward = null;
		forward = new ActionForward();
		if (id == null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("/Vilsam_yj/memberLogin.me");
		}

		else {
			String viewId = request.getParameter("MEMBER_ID");
			MemberViewService memberViewService = new MemberViewService();
			MemberBean member = memberViewService.getMember(viewId);
			if (member != null) {
				request.setAttribute("member", member);
				if (type.equals("admin")) {
					forward.setPath("/jsp/member/member_info.jsp");
				} else {
					forward.setPath("/jsp/member/member_mypage.jsp");
				}
			} else {
//back()
			}
		}
		return forward;
	}
}