package product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import product.svc.ProductDetailService;
import vo.ActionForward;
import vo.ProductBean;

 public class ProductDetailAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
	   	
		String product_num=request.getParameter("product_num");
		System.out.println(product_num);
		ProductDetailService productDetailService = new ProductDetailService();
		ProductBean article = productDetailService.getArticle(product_num);
		ActionForward forward = new ActionForward();
		System.out.println(article);
	   	request.setAttribute("product", article);
   		forward.setPath("/jsp/product/product_detail.jsp");
   		return forward;

	 }
	 
}