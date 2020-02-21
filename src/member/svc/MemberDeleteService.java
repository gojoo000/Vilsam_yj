package member.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class MemberDeleteService {
	
	/*
	 * public boolean isMember(String id, String pass) throws Exception{
	 * 
	 * boolean isMember = false; Connection con = getConnection(); MemberDAO
	 * memberDAO = MemberDAO.getInstance(); memberDAO.setConnection(con); isMember =
	 * memberDAO.isMember(id, pass); close(con); return isMember; }
	 */
	public boolean removeMember(String id) throws Exception{
		
		boolean isRemoveSuccess = false;
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		int deleteCount = memberDAO.deleteMember(id);
		
		if(deleteCount > 0) {
			commit(con);
			isRemoveSuccess = true;
		}
		else {
			rollback(con);
		}
		
		close(con);
		return isRemoveSuccess;
	}
}
