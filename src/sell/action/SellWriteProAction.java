package sell.action;

import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import sell.svc.SellWriteProService;
import vo.ActionForward;
import vo.SellListBean;
import vo.StockBean;

public class SellWriteProAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		SellListBean sellListBean = null;
		ServletContext context = request.getServletContext();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		sellListBean = new SellListBean();
		sellListBean.setProduct_num(request.getParameter("PRODUCT_NUM"));
		sellListBean.setMember_id(request.getParameter("MEMBER_ID"));
		sellListBean.setSell_count(Integer.parseInt(request.getParameter("SELL_COUNT")));

		// �궇吏� 蹂��솚
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		Date currentTime = new Date();
		String[] mTime = (simpleDateFormat.format(currentTime)).split("-");
		
		StockBean stockBean = new StockBean();
		stockBean.setIo(request.getParameter("IO"));
		stockBean.setProduct_num(request.getParameter("PRODUCT_NUM"));
		stockBean.setCount(Integer.parseInt(request.getParameter("SELL_COUNT")));

		/*
		 * stockBean.setDateyy(request.getParameter("mTime[0]"));
		 * stockBean.setDatemm(request.getParameter("mTime[1]"));
		 * stockBean.setDatedd(request.getParameter("mTime[2]"));
		 */
		
		stockBean.setDateyy(mTime[0]);
		stockBean.setDatemm(mTime[1]);
		stockBean.setDatedd(mTime[2]);

		/*
		 * sellListBean.setSell_yn(request.getParameter("SELL_YN"));
		 * sellListBean.setSell_date(Date.valueOf((request.getParameter("SELL_DATE"))));
		 */

		SellWriteProService sellWriteProService = new SellWriteProService();
		boolean isWriteSuccess = sellWriteProService.registArticle(sellListBean, stockBean);
		/*
		 * HttpSession session = request.getSession(); MemberBean member = new
		 * MemberBean(); session.setAttribute("id", member.getMEMBER_ID());
		 */

		if (!isWriteSuccess) {
			out.println("<script>");
			out.println("alert('주문이 불가능합니다.')");
			out.println("history.back();");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('주문이 완료되었습니다.')");
			out.println("history.back();");
			out.println("</script>");
			/*
			 * forward = new ActionForward(); forward.setRedirect(true);
			 * forward.setPath("/jsp/sell/sellBuyListR.jsp");
			 */
		}

		return forward;

	}

}