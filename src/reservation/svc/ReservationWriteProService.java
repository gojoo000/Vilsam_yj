package reservation.svc;

import vo.ReservationBean;
import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.ReservationDAO;

public class ReservationWriteProService {

	public boolean insertReservation(ReservationBean reservation) {
		// TODO Auto-generated method stub
		boolean reservationSuccess = false;
		ReservationDAO reservationDAO = ReservationDAO.getInstance();
		Connection con = getConnection();
		reservationDAO.setConnection(con);
		int insertCount = reservationDAO.insertReservation(reservation);
		if(insertCount > 0){
			reservationSuccess = true;
			commit(con);
		}
		else{
			rollback(con);
		}
		close(con);
		return reservationSuccess;
	}

}
