package reservation.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reservation.svc.ReserChkService;
import vo.ReservationBean;

/**
 * Servlet implementation class idChkAction
 */
@WebServlet("/reserChkAction.reser")
public class ReserChkAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserChkAction() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	int chkResult = 0;
    	ReservationBean reservation = new ReservationBean();

    	
    	
		String room_num = request.getParameter("ROOM_NUM");
		String reser_date = request.getParameter("RESER_DATE");

		
		
		ReserChkService reserChkService = new ReserChkService();
		chkResult = reserChkService.checkReservation(room_num,reser_date);
		
		System.out.println("chkResult: "+reser_date+room_num);
		
		response.getWriter().println(chkResult);
    }
    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
		  
		
	}

}
