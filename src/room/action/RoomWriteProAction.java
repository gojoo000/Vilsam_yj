package room.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import room.svc.RoomWriteProService;
import vo.ActionForward;
import vo.RoomBean;

public class RoomWriteProAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		RoomBean roomBean = null;
		String realFolder = "";
		String saveFolder = "/upload";
		int fileSize = 5 * 1024 * 1024;
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8",
				new DefaultFileRenamePolicy());
		roomBean = new RoomBean();
		roomBean.setRoom_name(multi.getParameter("ROOM_NAME"));
		roomBean.setRoom_price(Integer.parseInt(multi.getParameter("ROOM_PRICE")));
		roomBean.setRoom_image(multi.getOriginalFileName((String) multi.getFileNames().nextElement()));
		roomBean.setRoom_size(Integer.parseInt(multi.getParameter("ROOM_SIZE")));
		RoomWriteProService roomWriteProService = new RoomWriteProService();
		boolean isWriteSuccess = roomWriteProService.registArticle(roomBean);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (!isWriteSuccess) {

			out.println("<script>");
			out.println("alert('.')");
			out.println("history.back();");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			out.println("<script>");
			out.println("alert('공간등록 완료!')");
			out.println("</script>");
			forward.setPath("/RoomList.jsp");
		}

		return forward;

	}

}