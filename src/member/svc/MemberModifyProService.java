package member.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberBean;

public class MemberModifyProService {
	
	public boolean modifyMember(MemberBean member) throws Exception {
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		int updateCount = memberDAO.updateMember(member);
		System.out.println(updateCount);
		
		if(updateCount > 0) {
			commit(con);
			isModifySuccess = true;
		}
		else {
			rollback(con);
		}
		
		close(con);
		return isModifySuccess;
	}	
}
