package room.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;
import dao.RoomDAO;

public class RoomDeleteProService {

	public boolean removeArticle(String ROOM_NUM){
		// TODO Auto-generated method stub
		
		boolean isRemoveSuccess = false;
		Connection con = getConnection();
		RoomDAO roomDAO = RoomDAO.getInstance();
		roomDAO.setConnection(con);
		int deleteCount = roomDAO.delProd(ROOM_NUM);
		
		if(deleteCount > 0){
			//System.out.println(con);
			commit(con);
			isRemoveSuccess=true;
			//System.out.println("commit");
		}
		else{
			rollback(con);
			
			//System.out.println("rollback");
		}
		
		close(con);
		return isRemoveSuccess;
	}

}
