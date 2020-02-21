package stock.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.StockDAO;
import vo.StockBean;

public class StockListService {

	public ArrayList<StockBean> getArticleList(String num) throws Exception {
		ArrayList<StockBean> articleList = null;
		Connection con = getConnection();
		StockDAO stockDAO = StockDAO.getInstance();
		stockDAO.setConnection(con);
		articleList = stockDAO.selectStockList(num);
		close(con); // return articleList;
		return articleList;
	}
}
