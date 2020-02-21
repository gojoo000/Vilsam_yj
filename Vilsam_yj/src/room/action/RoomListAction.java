package room.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import room.svc.RoomListService;
import vo.ActionForward;
import vo.RoomBean;
import vo.PageInfo;

public class RoomListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<RoomBean> articleList = new ArrayList<RoomBean>();

		/*
		 * if (request.getParameter("page") != null) { page =
		 * Integer.parseInt(request.getParameter("page")); }
		 */
		RoomListService roomListService = new RoomListService();
		int listCount = roomListService.getListCount(); 

		 articleList = roomListService.getArticleList();

		PageInfo pageInfo = new PageInfo();

		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		System.out.println(articleList);
		ActionForward forward = new ActionForward();
		forward.setPath("/index.jsp");
		return forward;
	}
}
