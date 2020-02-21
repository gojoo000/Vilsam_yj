package room.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.RoomDAO;
import vo.RoomBean;

public class RoomListService {
	public int getListCount() throws Exception {
		int listCount = 0;
		Connection con = getConnection();
		RoomDAO roomDAO = RoomDAO.getInstance();
		roomDAO.setConnection(con);
		listCount = roomDAO.selectListCount();
		close(con);
		return listCount;
	}

	public ArrayList<RoomBean> getArticleList() throws Exception {
		ArrayList<RoomBean> articleList = null;
		Connection con = getConnection();
		RoomDAO roomDAO = RoomDAO.getInstance();
		roomDAO.setConnection(con);
		articleList = roomDAO.selectArticleList();
		close(con); // return articleList;
		return articleList;
	}

}
