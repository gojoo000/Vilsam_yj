package room.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import room.svc.RoomDetailService;
import room.svc.RoomListService;
import room.svc.RoomSellService;
import vo.ActionForward;
import vo.RoomBean;

public class RoomSellAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int room_num = Integer.parseInt((request.getParameter("room_num")));
		System.out.println(room_num);
		RoomDetailService roomDetailService = new RoomDetailService();
		RoomBean article = roomDetailService.getArticle(room_num);
		ActionForward forward = new ActionForward();
		System.out.println(article);
		request.setAttribute("room", article);
		forward.setPath("/room/room_sell.jsp");
		return forward;

	}

}
