package room.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import room.svc.RoomDetailService;
import vo.ActionForward;
import vo.RoomBean;

public class RoomModifyFormAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 	ActionForward forward = new ActionForward();
			int room_num=Integer.parseInt(request.getParameter("room_num"));
			RoomDetailService roomDetailService = new RoomDetailService();	
		   	RoomBean article =roomDetailService.getArticle(room_num);
		   	request.setAttribute("article", article);
	   		forward.setPath("/room/qna_room_modify.jsp");
	   		return forward;
	   		
	 }
	 
}