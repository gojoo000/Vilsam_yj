package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import vo.NoticeBean;

public class NoticeDAO {
	DataSource ds;
	Connection con;

	private static NoticeDAO noticeDAO; //외부클래스에서 dao변수에 직접 접근할 수 없도록 제한자 걸기

	private NoticeDAO() {

	} //외부클래스에서 생성자를 사용해서 객체를 새로 생성할 수 없도록 제한자 걸기

	//싱글톤패턴으로 NoticeDAO 객체를 생성해서 리턴해주는 메소드 정의
	public static NoticeDAO getInstance() {
		if(noticeDAO ==null) {
			noticeDAO=new NoticeDAO();
		}
		return noticeDAO;
	}

	//NoticeDAO 객체에 Connection 객체를 주입하는 메소드 정의
	public void setConnection(Connection con) {
		this.con=con;
	}

	//글의 개수 구하기
	public int selectListCount() {
		int listCount=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			System.out.println("getConnection");
			pstmt=con.prepareStatement("SELECT count(*) FROM notice"); //전체 글 갯수 구하기
			rs=pstmt.executeQuery();

			if(rs.next()) {
				listCount=rs.getInt(1); //전체 글 갯수를 listCount에 할당(저장)
			}
		}catch(Exception e) {
			System.out.println("getListCount 에러 : "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}


	//글 목록 보기.
	public ArrayList<NoticeBean> selectArticleList(int page,int limit){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String notice_list_sql="select * from notice order by NOTICE_RE_REF desc,NOTICE_RE_SEQ asc limit ?,10";
		ArrayList<NoticeBean> articleList = new ArrayList<NoticeBean>();
		NoticeBean notice = null;
		int startrow=(page-1)*10; //읽기 시작할 row 번호..

		try{
			pstmt = con.prepareStatement(notice_list_sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();

			while(rs.next()){
				notice = new NoticeBean();
				notice.setNOTICE_NUM(rs.getInt("NOTICE_NUM"));
				notice.setNOTICE_NAME(rs.getString("NOTICE_NAME"));
				notice.setNOTICE_SUBJECT(rs.getString("NOTICE_SUBJECT"));
				notice.setNOTICE_CONTENT(rs.getString("NOTICE_CONTENT"));
				notice.setNOTICE_FILE(rs.getString("NOTICE_FILE"));
				notice.setNOTICE_RE_REF(rs.getInt("NOTICE_RE_REF"));
				notice.setNOTICE_RE_LEV(rs.getInt("NOTICE_RE_LEV"));
				notice.setNOTICE_RE_SEQ(rs.getInt("NOTICE_RE_SEQ"));
				notice.setNOTICE_READCOUNT(rs.getInt("NOTICE_READCOUNT"));
				notice.setNOTICE_DATE(rs.getDate("NOTICE_DATE"));
				articleList.add(notice);
			}

		}catch(Exception ex){
			System.out.println("getNoticeList 에러 : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return articleList;

	}

	//글 내용 보기.
	public NoticeBean selectArticle(int notice_num){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeBean noticeBean = null;

		try{
			pstmt = con.prepareStatement(
					"select * from notice where NOTICE_NUM = ?");
			pstmt.setInt(1, notice_num);
			rs= pstmt.executeQuery();

			if(rs.next()){
				noticeBean = new NoticeBean();
				noticeBean.setNOTICE_NUM(rs.getInt("NOTICE_NUM"));
				noticeBean.setNOTICE_NAME(rs.getString("NOTICE_NAME"));
				noticeBean.setNOTICE_SUBJECT(rs.getString("NOTICE_SUBJECT"));
				noticeBean.setNOTICE_CONTENT(rs.getString("NOTICE_CONTENT"));
				noticeBean.setNOTICE_FILE(rs.getString("NOTICE_FILE"));
				noticeBean.setNOTICE_RE_REF(rs.getInt("NOTICE_RE_REF"));
				noticeBean.setNOTICE_RE_LEV(rs.getInt("NOTICE_RE_LEV"));
				noticeBean.setNOTICE_RE_SEQ(rs.getInt("NOTICE_RE_SEQ"));
				noticeBean.setNOTICE_READCOUNT(rs.getInt("NOTICE_READCOUNT"));
				noticeBean.setNOTICE_DATE(rs.getDate("NOTICE_DATE"));
			}
		}catch(Exception ex){
			System.out.println("getDetail 에러 : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return noticeBean;

	}

	//글 등록.
	public int insertArticle(NoticeBean article){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num =0;
		String sql="";
		int insertCount=0;

		try{
			pstmt=con.prepareStatement("select max(notice_num) from notice");
			rs = pstmt.executeQuery();

			if(rs.next())
				num =rs.getInt(1)+1;
			else
				num=1;

			sql="insert into notice (NOTICE_NUM,NOTICE_NAME,NOTICE_PASS,NOTICE_SUBJECT,";
			sql+="NOTICE_CONTENT, NOTICE_FILE, NOTICE_RE_REF,"+
					"NOTICE_RE_LEV,NOTICE_RE_SEQ,NOTICE_READCOUNT,"+
					"NOTICE_DATE) values(?,?,?,?,?,?,?,?,?,?,now())";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getNOTICE_NAME());
			pstmt.setString(3, article.getNOTICE_PASS());
			pstmt.setString(4, article.getNOTICE_SUBJECT());
			pstmt.setString(5, article.getNOTICE_CONTENT());
			pstmt.setString(6, article.getNOTICE_FILE());
			pstmt.setInt(7, num);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);

			insertCount=pstmt.executeUpdate();

		}catch(Exception ex){
			System.out.println("noticeInsert 에러 : "+ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}

	//글 답변.
	public int insertReplyArticle(NoticeBean article){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String notice_max_sql="select max(notice_num) from notice";
		String sql="";
		int num=0;
		int insertCount=0;
		int re_ref=article.getNOTICE_RE_REF();
		int re_lev=article.getNOTICE_RE_LEV();
		int re_seq=article.getNOTICE_RE_SEQ();

		try{
			pstmt=con.prepareStatement(notice_max_sql);
			rs = pstmt.executeQuery();
			if(rs.next())num =rs.getInt(1)+1;
			else num=1;
			sql="update notice set NOTICE_RE_SEQ=NOTICE_RE_SEQ+1 where NOTICE_RE_REF=? ";
			sql+="and NOTICE_RE_SEQ>?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,re_ref);
			pstmt.setInt(2,re_seq);
			int updateCount=pstmt.executeUpdate();

			if(updateCount > 0){
				commit(con);
			}

			re_seq = re_seq + 1;
			re_lev = re_lev+1;
			sql="insert into notice (NOTICE_NUM,NOTICE_NAME,NOTICE_PASS,NOTICE_SUBJECT,";
			sql+="NOTICE_CONTENT, NOTICE_FILE,NOTICE_RE_REF,NOTICE_RE_LEV,NOTICE_RE_SEQ,";
			sql+="NOTICE_READCOUNT,NOTICE_DATE) values(?,?,?,?,?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getNOTICE_NAME());
			pstmt.setString(3, article.getNOTICE_PASS());
			pstmt.setString(4, article.getNOTICE_SUBJECT());
			pstmt.setString(5, article.getNOTICE_CONTENT());
			pstmt.setString(6, ""); //답장에는 파일을 업로드하지 않음.
			pstmt.setInt(7, re_ref);
			pstmt.setInt(8, re_lev);
			pstmt.setInt(9, re_seq);
			pstmt.setInt(10, 0);
			insertCount = pstmt.executeUpdate();
		}catch(SQLException ex){
			System.out.println("noticeReply 에러 : "+ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}

	//글 수정.
	public int updateArticle(NoticeBean article){

		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql="update notice set NOTICE_SUBJECT=?,NOTICE_CONTENT=? where NOTICE_NUM=?";

		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getNOTICE_SUBJECT());
			pstmt.setString(2, article.getNOTICE_CONTENT());
			pstmt.setInt(3, article.getNOTICE_NUM());
			updateCount = pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("noticeModify 에러 : " + ex);
		}finally{
			close(pstmt);
		}

		return updateCount;

	}

	//글 삭제.
	public int deleteArticle(int notice_num){

		PreparedStatement pstmt = null;
		String notice_delete_sql="delete from notice where NOTICE_num=?";
		int deleteCount=0;

		try{
			pstmt=con.prepareStatement(notice_delete_sql);
			pstmt.setInt(1, notice_num);
			deleteCount=pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("noticeDelete 에러 : "+ex);
		}	finally{
			close(pstmt);
		}

		return deleteCount;

	}

	//조회수 업데이트.
	public int updateReadCount(int notice_num){

		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql="update notice set NOTICE_READCOUNT = "+
				"NOTICE_READCOUNT+1 where NOTICE_NUM = "+notice_num;

		try{
			pstmt=con.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
		}catch(SQLException ex){
			System.out.println("setReadCountUpdate 에러 : "+ex);
		}
		finally{
			close(pstmt);

		}

		return updateCount;

	}

	//글쓴이인지 확인.
	public boolean isArticleNoticeWriter(int notice_num,String pass){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String notice_sql="select * from notice where NOTICE_NUM=?";
		boolean isWriter = false;

		try{
			pstmt=con.prepareStatement(notice_sql);
			pstmt.setInt(1, notice_num);
			rs=pstmt.executeQuery();
			rs.next();

			if(pass.equals(rs.getString("NOTICE_PASS"))){
				isWriter = true;
			}
		}catch(SQLException ex){
			System.out.println("isNoticeWriter 에러 : "+ex);
		}
		finally{
			close(pstmt);
		}

		return isWriter;

	}

}
