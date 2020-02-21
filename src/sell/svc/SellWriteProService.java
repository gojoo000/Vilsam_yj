package sell.svc;

import static db.JdbcUtil.*;
import dao.StockDAO;
import vo.StockBean;

import java.sql.Connection;

import dao.SellDAO;
import vo.SellListBean;

public class SellWriteProService {

	public boolean registArticle(SellListBean sellListBean, StockBean stockBean) throws Exception {
		// TODO Auto-generated method stub

		boolean isWriteSuccess = false;
		Connection con = getConnection();
		SellDAO sellDAO = SellDAO.getInstance();
		sellDAO.setConnection(con);
		StockDAO stockDAO = StockDAO.getInstance();
		stockDAO.setConnection(con);
		int insertSellCount = sellDAO.insertArticle(sellListBean);
		if (insertSellCount > 0) {
			stockBean.setSellnum(insertSellCount);
			int insertStockCount = stockDAO.insertArticle(stockBean);

			if ( insertStockCount > 0) {
				commit(con);
				isWriteSuccess = true;
			}else {
				rollback(con);
			}
		} else {
			rollback(con);
		}

		close(con);
		return isWriteSuccess;

	}

}
