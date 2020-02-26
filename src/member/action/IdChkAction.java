package member.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.svc.MemberChkService;
import member.svc.MemberJoinService;
import member.svc.MemberViewService;
import vo.MemberBean;

/**
 * Servlet implementation class idChkAction
 */
@WebServlet("/Vilsam_yj/idChkAction.do")
public class IdChkAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdChkAction() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	int chkResult = 0;
    	MemberBean member = new MemberBean();

    	
    	
		String memberId = request.getParameter("MEMBER_ID");
		//String memberId2 = request.getParameter("userid");
		
		
		MemberChkService memberChkService = new MemberChkService();
		chkResult = memberChkService.checkId(memberId);
		
		//System.out.println("chkResult: "+chkResult);
		
		response.getWriter().println(chkResult);
    }
    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
		  
		
	}

}
