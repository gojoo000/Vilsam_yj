package reservation.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import room.svc.RoomDeleteProService;
import vo.ActionForward;

public class RoomDeleteProAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		String ROOM_NUM = request.getParameter("ROOM_NUM");
		RoomDeleteProService roomDeleteProService = new RoomDeleteProService();
		boolean isDeleteSuccess = roomDeleteProService.removeArticle(ROOM_NUM);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (!isDeleteSuccess) {
			out.println("<script>");
			out.println("alert('삭제 실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		} else {
			/*
			 * out.println("<script>"); out.println("alert('삭제 완료');");
			 * out.println("history.back();"); out.println("</script>");
			 */
			
			  forward = new ActionForward(); forward.setRedirect(true);
			  forward.setPath("/Vilsam_yj/RoomList.pro");
			 
		}

		return forward;
	}

}