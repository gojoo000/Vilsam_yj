package room.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import com.oreilly.servlet.MultipartRequest;

import dao.RoomDAO;
import vo.RoomBean;

public class RoomModifyProService {

	public boolean modifyArticle(RoomBean article) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		RoomDAO roomDAO = RoomDAO.getInstance();
		roomDAO.setConnection(con);
		int updateCount = roomDAO.updateRoom(article);
		
		if(updateCount > 0){
			commit(con);
			isModifySuccess=true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isModifySuccess;
		
	}

}
