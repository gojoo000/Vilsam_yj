package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.MemberModifyProService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberModifyAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		boolean isModifySuccess = false;
		HttpSession session = request.getSession();
		MemberBean member = new MemberBean();
		MemberModifyProService memberModifyProService = new MemberModifyProService();
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
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
			member.setMEMBER_TYPE(request.getParameter("MEMBER_TYPE"));
			
			System.out.println("^^^^^"+request.getParameter("MEMBER_ID")+"^^");
			
			isModifySuccess = memberModifyProService.modifyMember(member);
			System.out.println(isModifySuccess);
			
			if(!isModifySuccess) {

				out.println("<script>");
				out.println("alert('회원정보 수정실패');");
				out.println("history.back()");
				out.println("</script>");
			}
			else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("./memberMypageAction.me?MEMBER_ID="+member.getMEMBER_ID());
				/*request.getSession().setAttribute("msg", "0");*/
			}
		
		return forward;
		
	}

}
