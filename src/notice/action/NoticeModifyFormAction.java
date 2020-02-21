package notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import notice.svc.NoticeDetailService;
import vo.ActionForward;
import vo.NoticeBean;

public class NoticeModifyFormAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 	ActionForward forward = new ActionForward();
			int notice_num=Integer.parseInt(request.getParameter("notice_num"));
			NoticeDetailService noticeDetailService
			= new NoticeDetailService();	
		   	NoticeBean article =noticeDetailService.getArticle(notice_num);
		   	request.setAttribute("article", article);
	   		forward.setPath("/notice/notice_modify.jsp");
	   		return forward;
	   		
	 }
	 
}