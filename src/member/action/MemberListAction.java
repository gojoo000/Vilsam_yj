package member.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.MemberJoinService;
import member.svc.MemberListService;
import member.svc.MemberLoginService;
import member.svc.MemberTypeService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberListAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 	HttpSession session=request.getSession();
	   		String memberId=(String)session.getAttribute("MEMBER_ID");
	   		String memberType=(String)session.getAttribute("MEMBER_TYPE");
	   		ActionForward forward = null;
	   		
	   		
	   		System.out.println("$$$$$$ "+memberId+"  "+memberType);
	   		
	   		
	   		if(memberType.equals("admin")) {
	   			forward = new ActionForward();
		   	    MemberListService memberListService = new MemberListService();
		   		ArrayList<MemberBean> memberList=memberListService.getMemberList();
		   		request.setAttribute("memberList", memberList);
		   		System.out.println("^^^  "+memberList);
		   		forward.setPath("/jsp/member/member_list.jsp");
	   		}else {
	   			response.setContentType("text/html;charset=UTF-8");
		   		PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('.');");
		   		out.println("location.href='/memberLogin.me");
		   		out.println("</script>");
	   		}
	   		
	   		return forward;
	}
}