package stock.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import stock.svc.StockdWriteProService;
import vo.ActionForward;
import vo.StockBean;

public class StockWriteProAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		StockBean stockBean = null;

		// ServletContext context = request.getServletContext();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		stockBean = new StockBean();
		stockBean.setIo(request.getParameter("IO"));
		stockBean.setProduct_num(request.getParameter("PRODUCT_NUM"));
		stockBean.setCount(Integer.parseInt(request.getParameter("COUNT")));
		stockBean.setDateyy(request.getParameter("DATEYY"));
		stockBean.setDatemm(request.getParameter("DATEMM"));
		stockBean.setDatedd(request.getParameter("DATEDD"));

		StockdWriteProService stockWriteProService = new StockdWriteProService();
		boolean isWriteSuccess = stockWriteProService.registArticle(stockBean);

		if (!isWriteSuccess) {

			out.println("<script>");
			out.println("alert('.')");
			out.println("history.back();");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('재고 등록완료!')");
			out.println("self.close();");
			out.println("</script>");
		}

		return forward;

		/*
		 * else { forward = new ActionForward(); forward.setRedirect(true);
		 * forward.setPath("/Vilsam_yj/adproductList.pro"); }
		 * 
		 * return forward;
		 */

	}

}