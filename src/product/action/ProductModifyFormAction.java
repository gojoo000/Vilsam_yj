package product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import product.svc.ProductDetailService;
import vo.ActionForward;
import vo.ProductBean;

public class ProductModifyFormAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 	ActionForward forward = new ActionForward();
			String product_num=request.getParameter("PRODUCT_NUM");
			ProductDetailService productDetailService
			= new ProductDetailService();	
		   	ProductBean articleList =productDetailService.getArticle(product_num);
		   	request.setAttribute("articleList", articleList);
	   		forward.setPath("/jsp/product/product_modify.jsp");
	   		return forward;
	   		
	 }
	 
}