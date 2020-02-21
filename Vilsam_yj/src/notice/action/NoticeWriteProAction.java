package notice.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import notice.svc.NoticeWriteProService;
import vo.ActionForward;
import vo.NoticeBean;

public class NoticeWriteProAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		NoticeBean noticeBean = null;
		String realFolder = "";
		String saveFolder = "/upload";
		int fileSize = 5 * 1024 * 1024;
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8",
				new DefaultFileRenamePolicy());
		noticeBean = new NoticeBean();
		noticeBean.setNOTICE_NAME(multi.getParameter("NOTICE_NAME"));
		noticeBean.setNOTICE_PASS(multi.getParameter("NOTICE_PASS"));
		noticeBean.setNOTICE_SUBJECT(multi.getParameter("NOTICE_SUBJECT"));
		noticeBean.setNOTICE_CONTENT(multi.getParameter("NOTICE_CONTENT"));
		noticeBean.setNOTICE_FILE(multi.getOriginalFileName((String) multi.getFileNames().nextElement()));
		NoticeWriteProService noticeWriteProService = new NoticeWriteProService();
		boolean isWriteSuccess = noticeWriteProService.registArticle(noticeBean);

		if (!isWriteSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			System.out.println("글쓰기 실패");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('.')");
			out.println("history.back();");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			System.out.println("글쓰기 완료");
			forward.setRedirect(true);
			forward.setPath("noticeList.no");
		}

		return forward;

	}

}