package reservation.svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.ReservationDAO;
import vo.ReservationBean;

public class ReserChkService {
	public int checkReservation(String room_num, String reser_date) {
		// TODO Auto-generated method stub
		boolean checkSuccess = false;
		ReservationDAO reservationDAO = ReservationDAO.getInstance();
		Connection con = getConnection();
		reservationDAO.setConnection(con);
		
		int flag = reservationDAO.checkReservation(room_num,reser_date);
		
		
		close(con);
		
		return flag;
	}
}
