package room.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import room.svc.RoomDetailService;
import vo.ActionForward;
import vo.RoomBean;

 public class RoomDetailAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
	   	
		int room_num=Integer.parseInt(request.getParameter("room_num"));
		String page = request.getParameter("page");
		RoomDetailService roomDetailService = new RoomDetailService();
		RoomBean article = roomDetailService.getArticle(room_num);
		ActionForward forward = new ActionForward();
		request.setAttribute("page", page);
	   	request.setAttribute("article", article);
   		forward.setPath("/jsp/room/room_detail.jsp");
   		return forward;

	 }
	 
}