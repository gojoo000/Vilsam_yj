package member.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberBean;

public class MemberChkService {
	public int checkId(String memberId) {
		// TODO Auto-generated method stub
		boolean checkSuccess = false;
		MemberDAO memberDAO = MemberDAO.getInstance();
		Connection con = getConnection();
		memberDAO.setConnection(con);
		
		int flag = memberDAO.checkMember(memberId);
		
		
		close(con);
		
		return flag;
	}
}
