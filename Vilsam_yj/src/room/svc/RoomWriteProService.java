package room.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.RoomDAO;
import vo.RoomBean;
public class RoomWriteProService {

	public boolean registArticle(RoomBean roomBean) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isWriteSuccess = false;
		Connection con = getConnection();
		RoomDAO roomDAO = RoomDAO.getInstance();
		roomDAO.setConnection(con);
		int insertCount = roomDAO.insertArticle(roomBean);
		
		if(insertCount > 0){
			commit(con);
			isWriteSuccess = true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isWriteSuccess;
		
	}

}
