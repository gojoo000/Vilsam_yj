package member.svc;

import java.sql.Connection;

import static db.JdbcUtil.*;
import dao.MemberDAO;
import vo.MemberBean;

public class MemberInfoService {

	public MemberBean getMemberInfo(String id) throws Exception{
		
		MemberBean memberInfo = null;
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		memberInfo = memberDAO.selectMember(id);
		close(con);
		return memberInfo;
	}
}
