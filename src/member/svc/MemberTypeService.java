package member.svc;

import vo.MemberBean;
import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.MemberDAO;

public class MemberTypeService {

	public String type(MemberBean member) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		
		String memberType = memberDAO.selectLoginId(member);
		close(con);
		return memberType;
	}

}
