package product.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import product.svc.ProductDetailService;
import product.svc.ProductListService;
import product.svc.ProductSellService;
import vo.ActionForward;
import vo.ProductBean;

public class ProductSellAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String product_num=request.getParameter("product_num");
		System.out.println(product_num);
		ProductDetailService productDetailService = new ProductDetailService();
		ProductBean article = productDetailService.getArticle(product_num);
		ActionForward forward = new ActionForward();
		System.out.println(article);
	   	request.setAttribute("product", article);
   		forward.setPath("/product/product_sell.jsp");
   		return forward;

	 }
		
		
}
