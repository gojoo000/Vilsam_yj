package notice.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.NoticeDAO;
import vo.NoticeBean;

public class NoticeListService {
	public int getListCount() throws Exception {
		int listCount = 0; 
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(con);
		listCount = noticeDAO.selectListCount();
		close(con);
		return listCount;
	}

	public ArrayList<NoticeBean> getArticleList(int page,
			int limit) throws Exception {
		ArrayList<NoticeBean> articleList = null; 
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(con);
		articleList = noticeDAO.selectArticleList(page,
				limit); 
		close(con); //
		return articleList;
	}
}
