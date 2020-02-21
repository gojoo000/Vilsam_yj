package notice.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.NoticeDAO;
import vo.NoticeBean;

public class NoticeReplyProService {

	public boolean replyArticle(NoticeBean article) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isReplySuccess = false;
		int insertCount = 0;
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(con);
		insertCount = noticeDAO.insertReplyArticle(article);
		
		if(insertCount > 0){
			commit(con);
			isReplySuccess = true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isReplySuccess;
		
	}

}
