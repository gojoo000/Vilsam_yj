package room.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.RoomDAO;
import vo.RoomBean;

public class RoomSellService {

	public RoomBean getArticle(int room_num) {
		// TODO Auto-generated method stub
		
		RoomBean articleList = null;
		Connection con = getConnection();
		RoomDAO roomDAO = RoomDAO.getInstance();
		try {
			
		
		roomDAO.setConnection(con);

		articleList = roomDAO.selectRoom(room_num);
		}catch(Exception e){
			
		}finally {
		close(con);}
		return articleList;
		
	}

}
