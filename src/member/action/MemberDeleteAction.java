package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.svc.MemberDeleteService;
import action.Action;
import vo.ActionForward;

public class MemberDeleteAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		HttpSession session = request.getSession();
		String id = request.getParameter("MEMBER_ID");
		System.out.println(session.getAttribute("MEMBER_ID"));
		MemberDeleteService memberDeleteProService = new MemberDeleteService();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		/*
		 * if(!session.getAttribute("MEMBER_ID").equals("admin")) {
		 * out.println("<script>"); out.println("alert('�궘�젣�븷 沅뚰븳�씠 �뾾�뒿�땲�떎.');");
		 * out.println("history.back()"); out.println("</script>"); out.close(); }
		 */
		forward = new ActionForward();
		forward.setRedirect(true);
		boolean isDeleteSuccess = memberDeleteProService.removeMember(id);

		if (!isDeleteSuccess) {

			out.println("<script>");
			out.println("alert('회원정보를 삭제할 수 없습니다.');");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('삭제완료');");
			out.println("history.back()");
			out.println("</script>");

			if (id.equals("admin")) {
				out.println("<script>");
				out.println("alert('회원을 추방시켰습니다.');");
				out.println("history.back()");
				out.println("</script>");
				forward.setPath("/Vilsam_yj/memberListAction.me");
				/*
				 * forward.setPath("/Vilsam_yj/memberListAction.me?MEMBER_ID=" +
				 * session.getAttribute("MEMBER_ID"));
				 */
			} else {
				request.getSession().setAttribute("msg", "탈퇴처리 되었습니다.");
				out.println("<script>");
				out.println("alert('회원정보를 삭제할 수 없습니다.');");
				out.println("history.back()");
				out.println("</script>");
				//forward.setPath("/Vilsam_yj/memberListAction.me");
			}
		}

		return forward;
	}

}
