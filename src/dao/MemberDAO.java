package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;
import vo.MemberBean;
import static db.JdbcUtil.*;

public class MemberDAO {
	public static MemberDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;

	private MemberDAO() {

	}

	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	/*
	 * public String adminLoginId(MemberBean member) { String loginId = null; String
	 * sql = "SELECT COUNT(*) cnt FROM MEMBER WHERE MEMBER_ID=?"; try { pstmt =
	 * con.prepareStatement(sql); pstmt.setString(1, member.getMEMBER_ID()); rs =
	 * pstmt.executeQuery();
	 * 
	 * if (rs.next()) { loginId = rs.getString("MEMBER_ID"); } } catch (Exception
	 * ex) { System.out.println("  " + ex); } finally {
	 * 
	 * close(rs); close(pstmt); }
	 * 
	 * return loginId;
	 * 
	 * }
	 */


	public int checkMember(String memberId) {
		String sql = "SELECT * FROM TB_MEMBER WHERE MEMBER_ID=?";
		
		int flag = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();

			//System.out.println("#### "+memberId+"   "+sql);
			
			if (rs.next()) {
				flag = 1;
			}else {
				flag = 0;
			}
			
			System.out.println("중복검사 flag  : "+flag);
			
			
		} catch (Exception ex) {
			System.out.println("id중복체크 에러" + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return flag;
	}
	
	
	public String selectLoginId(MemberBean member) {
		String memberType = null;
		String sql = "SELECT MEMBER_TYPE FROM TB_MEMBER WHERE MEMBER_ID=? AND MEMBER_PW=?";
		// String sql2 = "SELECT COUNT(*) cnt FROM MEMBER WHERE MEMBER_ID=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMEMBER_ID());
			pstmt.setString(2, member.getMEMBER_PW());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				memberType = rs.getString("MEMBER_TYPE");
			}
		} catch (Exception ex) {
			System.out.println("  " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return memberType;
	}

	
	
	
	public int insertMember(MemberBean member) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num =0;
		String sql="";
		int insertCount=0;

		try{
			/*
			 * pstmt = con.prepareStatement("select max(MEMBER_NUM) from MEMBER"); rs =
			 * pstmt.executeQuery();
			 * 
			 * if(rs.next()) num =rs.getInt(1)+1; else num=1;
			 */
			
			sql="insert into TB_MEMBER (MEMBER_ID,MEMBER_PW,MEMBER_NAME,MEMBER_GENDER,MEMBER_EMAIL,MEMBER_ZIPCODE,";
			sql+="MEMBER_ADDR1,MEMBER_ADDR2,MEMBER_PHONE1,MEMBER_PHONE2,MEMBER_BIRTH,MEMBER_TYPE,CRT_DT)";
			sql+="values(?,?,?,?,?,?,?,?,?,?,?,?,now())";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, member.getMEMBER_ID());
			pstmt.setString(2, member.getMEMBER_PW());
			pstmt.setString(3, member.getMEMBER_NAME());
			pstmt.setString(4, member.getMEMBER_GENDER());
			pstmt.setString(5, member.getMEMBER_EMAIL());
			pstmt.setString(6, member.getMEMBER_ZIPCODE());
			pstmt.setString(7, member.getMEMBER_ADDR1());
			pstmt.setString(8, member.getMEMBER_ADDR2());
			pstmt.setString(9, member.getMEMBER_PHONE1());
			pstmt.setString(10, member.getMEMBER_PHONE2());
			pstmt.setString(11, member.getMEMBER_BIRTH());
			pstmt.setString(12, "user");
			
			insertCount = pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("joinMember 에러: " + ex);
		} finally {
			close(pstmt);
		}

		return insertCount;
	}

	public ArrayList<MemberBean> selectMemberList() {
		String sql = "SELECT * FROM TB_MEMBER";
		ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();
		MemberBean member = null;
		try {

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					member = new MemberBean();
					member.setMEMBER_ID(rs.getString("MEMBER_ID"));
					member.setMEMBER_PW(rs.getString("MEMBER_PW"));
					member.setMEMBER_NAME(rs.getString("MEMBER_NAME"));
					member.setMEMBER_GENDER(rs.getString("MEMBER_GENDER"));
					member.setMEMBER_EMAIL(rs.getString("MEMBER_EMAIL"));
					member.setMEMBER_ZIPCODE(rs.getString("MEMBER_ZIPCODE"));
					member.setMEMBER_ADDR1(rs.getString("MEMBER_ADDR1"));
					member.setMEMBER_ADDR2(rs.getString("MEMBER_ADDR2"));
					member.setMEMBER_PHONE1(rs.getString("MEMBER_PHONE1"));
					member.setMEMBER_PHONE2(rs.getString("MEMBER_PHONE2"));
					member.setMEMBER_BIRTH(rs.getString("MEMBER_BIRTH"));
					member.setMEMBER_TYPE(rs.getString("MEMBER_TYPE"));
					member.setCRT_DT(rs.getString("CRT_DT"));
					System.out.println(rs.getString("CRT_DT")+"################## "+rs.getDate("CRT_DT"));
					memberList.add(member);
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.out.println("getDeatilMember 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return memberList;
	}

	public MemberBean selectMember(String id) {
		String sql = "SELECT * FROM TB_MEMBER WHERE MEMBER_ID=?";
		MemberBean member = null;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new MemberBean();
				member.setMEMBER_ID(rs.getString("MEMBER_ID"));
				member.setMEMBER_PW(rs.getString("MEMBER_PW"));
				member.setMEMBER_NAME(rs.getString("MEMBER_NAME"));
				member.setMEMBER_GENDER(rs.getString("MEMBER_GENDER"));
				member.setMEMBER_EMAIL(rs.getString("MEMBER_EMAIL"));
				member.setMEMBER_ZIPCODE(rs.getString("MEMBER_ZIPCODE"));
				member.setMEMBER_ADDR1(rs.getString("MEMBER_ADDR1"));
				member.setMEMBER_ADDR2(rs.getString("MEMBER_ADDR2"));
				member.setMEMBER_PHONE1(rs.getString("MEMBER_PHONE1"));
				member.setMEMBER_PHONE2(rs.getString("MEMBER_PHONE2"));
				member.setMEMBER_BIRTH(rs.getString("MEMBER_BIRTH"));
				member.setMEMBER_TYPE(rs.getString("MEMBER_TYPE"));
				member.setCRT_DT(rs.getDate("CRT_DT").toString());
				//System.out.println("################## "+rs.getString("CRT_DT"));
			}
		} catch (Exception ex) {
			System.out.println("getDeatilMember 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return member;
	}

	//�쉶�썝 �궘�젣�븯湲�
		public int deleteMember(String id) {
			
			PreparedStatement pstmt = null;
			String member_delete_sql = "delete from TB_MEMBER where MEMBER_ID=?";
			int deleteCount = 0;
			
			try {
				pstmt = con.prepareStatement(member_delete_sql);
				pstmt.setString(1, id);
				deleteCount = pstmt.executeUpdate();
			}catch(Exception ex) {
				System.out.println("memberDelete �뿉�윭 : " + ex);
			}finally {
				close(pstmt);
			}
			
			return deleteCount;
		}
		
		//회원정보 수정
				public int updateMember(MemberBean member) {
						
					int updateCount = 0;
					PreparedStatement pstmt = null;
					String sql = "update TB_MEMBER set MEMBER_PW=?, MEMBER_NAME=?, MEMBER_EMAIL=?, MEMBER_ZIPCODE=?, MEMBER_ADDR1=?,";
							sql+= "  MEMBER_ADDR2=?, MEMBER_PHONE1=?, MEMBER_PHONE2=?, MEMBER_TYPE=? WHERE MEMBER_ID=?";
					
					try {
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, member.getMEMBER_PW());
						pstmt.setString(2, member.getMEMBER_NAME());
						pstmt.setString(3, member.getMEMBER_EMAIL());
						pstmt.setString(4,member.getMEMBER_ZIPCODE());
						pstmt.setString(5,member.getMEMBER_ADDR1());
						pstmt.setString(6,member.getMEMBER_ADDR2());
						pstmt.setString(7,member.getMEMBER_PHONE1());
						pstmt.setString(8,member.getMEMBER_PHONE2());
						pstmt.setString(9,member.getMEMBER_TYPE());
						pstmt.setString(10,member.getMEMBER_ID());
						
						System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&3ddd&&&&&&  "+member.getMEMBER_ID()+"    "+sql);
						updateCount = pstmt.executeUpdate();
					}catch(Exception ex) {
						System.out.println("memberModify : " + ex);
					}finally {
						close(pstmt);
					}
					
					return updateCount;
				}

				
			}