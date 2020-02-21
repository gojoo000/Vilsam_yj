package notice.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import notice.svc.NoticeReplyProService;
import vo.ActionForward;
import vo.NoticeBean;

public class NoticeReplyProAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 throws Exception{
		 
		 	ActionForward forward = null;
		    String nowPage = request.getParameter("page");
		 	NoticeBean article = new NoticeBean();  		
		 	article.setNOTICE_NUM(Integer.parseInt(request.getParameter("NOTICE_NUM")));
		 	article.setNOTICE_NAME(request.getParameter("NOTICE_NAME"));
		 	article.setNOTICE_PASS(request.getParameter("NOTICE_PASS"));
		 	article.setNOTICE_SUBJECT(request.getParameter("NOTICE_SUBJECT"));
		 	article.setNOTICE_CONTENT(request.getParameter("NOTICE_CONTENT"));
		 	article.setNOTICE_RE_REF(Integer.parseInt(request.getParameter("NOTICE_RE_REF")));
		 	article.setNOTICE_RE_LEV(Integer.parseInt(request.getParameter("NOTICE_RE_LEV")));
		 	article.setNOTICE_RE_SEQ(Integer.parseInt(request.getParameter("NOTICE_RE_SEQ")));	   		
		 	NoticeReplyProService boardReplyProService = new NoticeReplyProService();
		 	boolean isReplySuccess = boardReplyProService.replyArticle(article);
		 	
	   		if(isReplySuccess){
	   			forward = new ActionForward();
	   			forward.setRedirect(true);
	   			forward.setPath("boardList.no?page=" + nowPage);
	   		}
	   		else{
	   			response.setContentType("text/html;charset=UTF-8");
	   			PrintWriter out = response.getWriter();
	   			out.println("<script>");
	   			out.println("alert('.')");
	   			out.println("history.back()");
	   			out.println("</script>");
	   		}
	   		
	   		return forward;
	   		
	}  	
	 
}