package sell.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import sell.svc.SellListService;
import vo.ActionForward;
import vo.PageInfo;
import vo.SellListBean;

public class SellListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ArrayList<SellListBean> articleList = new ArrayList<SellListBean>();

		/*
		 * if (request.getParameter("page") != null) { page =
		 * Integer.parseInt(request.getParameter("page")); }
		 */
		HttpSession session = request.getSession();
		String MEMBER_ID = (String) session.getAttribute("MEMBER_ID");
		String MEMBER_TYPE = (String) session.getAttribute("MEMBER_TYPE");
		System.out.println(MEMBER_ID);
		SellListService sellListService = new SellListService();

		articleList = sellListService.getArticleList(MEMBER_ID, MEMBER_TYPE);

		PageInfo pageInfo = new PageInfo();

		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		System.out.println(articleList);
		ActionForward forward = new ActionForward();
		forward.setPath("/jsp/sell/sell_list.jsp");
		return forward;
	}
}
