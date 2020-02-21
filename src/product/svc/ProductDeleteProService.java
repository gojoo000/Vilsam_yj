package product.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;
import dao.ProductDAO;

public class ProductDeleteProService {

	public boolean removeArticle(String PRODUCT_NUM){
		// TODO Auto-generated method stub
		
		boolean isRemoveSuccess = false;
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		int deleteCount = productDAO.delProd(PRODUCT_NUM);
		
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
