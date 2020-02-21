package notice.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import notice.svc.NoticeModifyProService;
import vo.ActionForward;
import vo.NoticeBean;

public class NoticeModifyProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{

		ActionForward forward = null;
		boolean isModifySuccess = false;
		int notice_num=Integer.parseInt(request.getParameter("NOTICE_NUM"));
		NoticeBean article=new NoticeBean();
		NoticeModifyProService noticeModifyProService = new NoticeModifyProService();
		boolean isRightUser=noticeModifyProService.isArticleWriter(notice_num, request.getParameter("NOTICE_PASS"));

		if(!isRightUser){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('.');");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			article.setNOTICE_NUM(notice_num);
			article.setNOTICE_SUBJECT(request.getParameter("NOTICE_SUBJECT"));
			article.setNOTICE_CONTENT(request.getParameter("NOTICE_CONTENT")); 
			isModifySuccess = noticeModifyProService.modifyArticle(article);

			if(!isModifySuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('.');");
				out.println("history.back()");
				out.println("</script>");
			}
			else{
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("noticeDetail.no?notice_num="+article.getNOTICE_NUM()); 
			}

		}

		return forward;
	}

}