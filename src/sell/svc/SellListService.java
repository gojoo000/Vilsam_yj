package sell.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.SellDAO;
import vo.SellListBean;

public class SellListService {
	public ArrayList<SellListBean> getArticleList(String MEMBER_ID, String MEMBER_TYPE)  {
		ArrayList<SellListBean> articleList = null;
		Connection con = getConnection();
		SellDAO sellDAO = SellDAO.getInstance();
		sellDAO.setConnection(con);
		articleList = sellDAO.selectArticleList(MEMBER_ID,MEMBER_TYPE);
		close(con); // return articleList;
		return articleList;
	}

}
