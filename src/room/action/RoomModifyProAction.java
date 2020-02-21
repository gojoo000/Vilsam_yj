package room.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import room.svc.RoomModifyProService;
import vo.ActionForward;
import vo.RoomBean;

public class RoomModifyProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{

		ActionForward forward = null;
		boolean isModifySuccess = false;
		 String room_num=request.getParameter("room_num"); 
		System.out.println(room_num);
		RoomBean article=new RoomBean();
		RoomModifyProService roomModifyProService = new RoomModifyProService();

	/*	if(!isRightUser){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('.');");
			out.println("history.back();");
			out.println("</script>");
		}*/
		System.out.println("1"+request.getParameter("ROOM_PRICE"));
		//값 받기
		//대문자 받기
		  article.setRoom_num(Integer.parseInt(request.getParameter("ROOM_NUM")));
		  article.setRoom_image(request.getParameter("ROOM_IMAGE")); 
		  article.setRoom_name(request.getParameter("ROOM_NAME"));
		  article.setRoom_size(Integer.parseInt(request.getParameter("ROOM_SIZE")));
		  article.setRoom_price(Integer.parseInt(request.getParameter("ROOM_PRICE")));
		 
			isModifySuccess = roomModifyProService.modifyArticle(article);

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
				forward.setPath("RoomList.pro?room_num="+article.getRoom_num()); 
			}

		

	return forward;
}

}