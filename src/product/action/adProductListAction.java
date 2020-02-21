package product.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import product.svc.ProductListService;
import vo.ActionForward;
import vo.ProductBean;
import vo.PageInfo;

public class adProductListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<ProductBean> articleList = new ArrayList<ProductBean>();

		/*
		 * if (request.getParameter("page") != null) { page =
		 * Integer.parseInt(request.getParameter("page")); }
		 */
		ProductListService productListService = new ProductListService();
		int listCount = productListService.getListCount(); 

		 articleList = productListService.getArticleList();

		PageInfo pageInfo = new PageInfo();

		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		System.out.println(articleList);
		ActionForward forward = new ActionForward();
		forward.setPath("/jsp/product/product_list.jsp");
		return forward;
	}
}
