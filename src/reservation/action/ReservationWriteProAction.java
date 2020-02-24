package reservation.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import reservation.svc.ReservationWriteProService;
import vo.ActionForward;
import vo.ReservationBean;

public class ReservationWriteProAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ReservationBean reservation = new ReservationBean();
		boolean insertResult = false;

		System.out.println("@$%^&*()_");
		
		/*
		 * reservation.setReser_num(Integer.parseInt(request.getParameter("RESER_NUM")))
		 * ;
		 */
		reservation.setRoom_num(Integer.parseInt(request.getParameter("room_num")));
		reservation.setMember_id(request.getParameter("MEMBER_ID"));

	
		reservation.setReser_date(request.getParameter("reserDate")); //name 받아옴

		ReservationWriteProService reserWriteService = new ReservationWriteProService();
		insertResult = reserWriteService.insertReservation(reservation);

		ActionForward forward = null;
		if (insertResult == false) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('공간예약 실패')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("/productList.pro");
			request.getSession().setAttribute("msg", "2");
			
		}
		return forward;
	}
}