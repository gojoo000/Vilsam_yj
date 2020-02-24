package reservation.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import reservation.svc.ReservationListService;
import vo.ActionForward;
import vo.ReservationBean;

public class ReservationListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<ReservationBean> articleList = new ArrayList<ReservationBean>();

		/*
		 * if (request.getParameter("page") != null) { page =
		 * Integer.parseInt(request.getParameter("page")); }
		 */
		ReservationListService reservationListService = new ReservationListService();
		/* int listCount = reservationListService.getListCount(); */

		/* articleList = reservationListService.getArti
		 * cleList(RESER_NUM); */

		/*request.setAttribute("MEMBER_ID", request.getParameter("MEMBER_ID").toString());*/
		request.setAttribute("MEMBER_ID", request.getParameter("MEMBER_ID"));
		request.setAttribute("articleList", articleList);
		/* System.out.println(articleList); */
		ActionForward forward = new ActionForward();
		forward.setPath("/jsp/calendarForm.jsp");
		return forward;
	}
}
