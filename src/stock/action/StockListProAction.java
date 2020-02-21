package stock.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import stock.svc.StockListService;
import vo.ActionForward;
import vo.StockBean;

public class StockListProAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<StockBean> articleList = new ArrayList<StockBean>();

		String num = request.getParameter("PRODUCT_NUM").toString();
		System.out.println("@@@ "+num);
				
		StockListService stockListService = new StockListService();

		articleList = stockListService.getArticleList(num);
		 
		request.setAttribute("articleList", articleList);
		System.out.println(articleList);
		ActionForward forward = new ActionForward();
		forward.setPath("/jsp/sell/prosellpop.jsp");
		return forward;
	}
}
