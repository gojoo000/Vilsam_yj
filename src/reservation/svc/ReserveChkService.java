package reservation.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.MemberDAO;
import dao.ReservationDAO;
import vo.MemberBean;
import vo.ReservationBean;

public class ReserveChkService {
	public List<ReservationBean> checkReserve(String type) {
		// TODO Auto-generated method stub
		boolean checkSuccess = false;
		ReservationDAO reservationDAO = ReservationDAO.getInstance();
		Connection con = getConnection();
		reservationDAO.setConnection(con);
		
		
		List<ReservationBean> calendarList = new ArrayList<ReservationBean>();
		calendarList = reservationDAO.checkReservation(type);
		
		
		close(con);
		
		return calendarList;
	}
	
	public List<ReservationBean> checkReserve(int room_num) {
		// TODO Auto-generated method stub
		boolean checkSuccess = false;
		ReservationDAO reservationDAO = ReservationDAO.getInstance();
		Connection con = getConnection();
		reservationDAO.setConnection(con);
		
		
		List<ReservationBean> calendarList = new ArrayList<ReservationBean>();
		calendarList = reservationDAO.checkReservation(room_num);
		
		
		close(con);
		
		return calendarList;
	}
}
