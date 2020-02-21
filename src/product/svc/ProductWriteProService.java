package product.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.ProductDAO;
import vo.ProductBean;
public class ProductWriteProService {

	public boolean registArticle(ProductBean productBean) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isWriteSuccess = false;
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		int insertCount = productDAO.insertArticle(productBean);
		
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
