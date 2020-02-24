package reservation.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ReservationDAO;
import vo.ReservationBean;

public class ReservationListService {
	public ArrayList<ReservationBean> getArticleList(int RESER_NUM)  {
		ArrayList<ReservationBean> articleList = null;
		Connection con = getConnection();
		ReservationDAO reservationDAO = ReservationDAO.getInstance();
		reservationDAO.setConnection(con);
		articleList = reservationDAO.selectReserList();
		close(con); // return articleList;
		return articleList;
	}

}
