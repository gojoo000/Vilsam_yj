package product.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import product.svc.ProductWriteProService;
import vo.ActionForward;
import vo.ProductBean;

public class ProductWriteProAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		ProductBean productBean = null;
		String realFolder = "";
		String saveFolder = "/upload";
		int fileSize = 5 * 1024 * 1024;
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8",
				new DefaultFileRenamePolicy());
		productBean = new ProductBean();
		productBean.setProduct_name(multi.getParameter("PRODUCT_NAME"));
		productBean.setProduct_price(Integer.parseInt(multi.getParameter("PRODUCT_PRICE")));
		productBean.setProduct_category(multi.getParameter("PRODUCT_CATEGORY"));
		productBean.setProduct_image(multi.getOriginalFileName((String) multi.getFileNames().nextElement()));
		ProductWriteProService productWriteProService = new ProductWriteProService();
		boolean isWriteSuccess = productWriteProService.registArticle(productBean);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (!isWriteSuccess) {

			out.println("<script>");
			out.println("alert('.')");
			out.println("history.back();");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			out.println("<script>");
			out.println("alert('상품등록 완료!')");
			out.println("</script>");
			forward.setPath("/index.jsp");
		}

		return forward;

	}

}