package product.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import product.svc.ProductModifyProService;
import vo.ActionForward;
import vo.ProductBean;

public class ProductModifyProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{

		ActionForward forward = null;
		boolean isModifySuccess = false;
		 String product_num=request.getParameter("product_num"); 
		System.out.println(product_num);
		ProductBean article=new ProductBean();
		ProductModifyProService productModifyProService = new ProductModifyProService();

	/*	if(!isRightUser){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('.');");
			out.println("history.back();");
			out.println("</script>");
		}*/
		System.out.println("1"+request.getParameter("PRODUCT_PRICE"));
		//값 받기
		//대문자 받기
		  article.setProduct_num((request.getParameter("PRODUCT_NUM")));
		/* article.setProduct_image(request.getParameter("PRODUCT_IMAGE")); */
		  article.setProduct_name(request.getParameter("PRODUCT_NAME"));
		  article.setProduct_price(Integer.parseInt(request.getParameter("PRODUCT_PRICE")));
		
		  article.setProduct_category(request.getParameter("PRODUCT_CATEGORY"));
		 
			isModifySuccess = productModifyProService.modifyArticle(article);

			if(!isModifySuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('.');");
				out.println("history.back()");
				out.println("</script>");
			}
			else{
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("adproductList.pro?product_num="+article.getProduct_num()); 
			}

		

	return forward;
}

}