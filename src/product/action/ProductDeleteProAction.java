package product.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import product.svc.ProductDeleteProService;
import vo.ActionForward;

public class ProductDeleteProAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		String PRODUCT_NUM = request.getParameter("PRODUCT_NUM");
		ProductDeleteProService productDeleteProService = new ProductDeleteProService();
		boolean isDeleteSuccess = productDeleteProService.removeArticle(PRODUCT_NUM);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (!isDeleteSuccess) {
			out.println("<script>");
			out.println("alert('삭제 실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		} else {
			/*
			 * out.println("<script>"); out.println("alert('삭제 완료');");
			 * out.println("history.back();"); out.println("</script>");
			 */
			
			  forward = new ActionForward(); forward.setRedirect(true);
			  forward.setPath("/Vilsam_yj/adproductList.pro");
			 
		}

		return forward;
	}

}