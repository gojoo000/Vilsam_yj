package stock.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.StockDAO;
import vo.StockBean;

public class StockdWriteProService {

	public boolean registArticle(StockBean stockBean) throws Exception {
		// TODO Auto-generated method stub

		boolean isWriteSuccess = false;
		Connection con = getConnection();
		StockDAO stockDAO = StockDAO.getInstance();
		stockDAO.setConnection(con);
		int insertCount = stockDAO.insertArticle(stockBean);
		if (insertCount > 0) {
			commit(con);
			isWriteSuccess = true;
		} else {
			rollback(con);
		}

		close(con);
		return isWriteSuccess;

	}

}
