package notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import notice.svc.NoticeDetailService;
import vo.ActionForward;
import vo.NoticeBean;

public class NoticeReplyFormAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 
		 	ActionForward forward = new ActionForward();
	   		String nowPage = request.getParameter("page");
	   		int notice_num=Integer.parseInt(request.getParameter("notice_num"));
	   		NoticeDetailService noticeDetailService = new NoticeDetailService();
	   		NoticeBean article=noticeDetailService.getArticle(notice_num);	
	   		request.setAttribute("article", article);
	   		request.setAttribute("page", nowPage);
	   		forward.setPath("/notice/notice_reply.jsp");
	   		return forward;
	   		
	}
	 
}