package reservation.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Globals;

import member.svc.MemberChkService;
import member.svc.MemberJoinService;
import member.svc.MemberListService;
import member.svc.MemberViewService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import reservation.svc.ReserveChkService;
import vo.ReservationBean;

   
/**
 * Servlet implementation class idChkAction
 */
@WebServlet("/rsv/calendar.do")
public class reserveCalendarAction extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reserveCalendarAction() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
    	  Map<String,Object> rsvMap = new HashMap<String,Object>();
          
    	  String type="";
    	  String room_num="";
          if(request.getParameter("type") != null) {
             type= request.getParameter("type").toString();
          }
          if(request.getParameter("room_num") != null) {
              room_num= request.getParameter("room_num").toString();
           }
          ReserveChkService reserveChkService = new ReserveChkService();
            List<ReservationBean> reserveList=reserveChkService.checkReserve(type);
            //1.리스트에 쿼리결과를 넣는다.
            //request.setAttribute("reserveList", reserveList);
            rsvMap.put("calendarList", reserveList);
            //2.Map에 reserveList를 넣는다.
            System.out.println( JSONArray.fromObject(rsvMap) );

            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(JSONObject.fromObject(rsvMap).toString());
            //3.Map을 json object형태로 바꿔서 출력
         
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