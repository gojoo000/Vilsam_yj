package notice.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import notice.svc.NoticeListService;
import vo.ActionForward;
import vo.NoticeBean;
import vo.PageInfo;

public class NoticeListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//�� �������� ��µ� ��ü �� ����� ������ ArrayList��ü�� �����ϴ� �κ��̴�.
		ArrayList<NoticeBean> articleList = new ArrayList<NoticeBean>();
		int page = 1;
		int limit = 10;

		//��Ϻ��⿡�� ��µ� �������� �Ķ���ͷ� ���۵� ��� page���� ���� ����
		//��Ϻ��� ���������� ��ȸ�� ������ ��ȣ�� Ŭ���ϰ� ��û�� ���� ��������ȣ�� �Ķ���ͷ� ���۵Ǿ�´�.
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		NoticeListService noticeListService = new NoticeListService();
		int listCount = noticeListService.getListCount(); // �� ����Ʈ ���� �޾ƿ�
		articleList = noticeListService.getArticleList(page, limit); // ����Ʈ�� �޾ƿ�
		// �� ������ ��
		int maxPage = (int) ((double) listCount / limit + 0.95); // 0.95�� ���ؼ� �ø� ó��
		// ���� �������� ������ ���� ������ ��(1,11,21 ��...)
		int startPage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		// ������������ ������ ������ ������ ��(10,20,30 ��...)
		int endPage = startPage + 10 - 1;

		if (endPage > maxPage)
			endPage = maxPage;

		PageInfo pageInfo = new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(endPage);
		pageInfo.setStartPage(startPage);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		ActionForward forward = new ActionForward();
		forward.setPath("/notice/notice_list.jsp");
		return forward;
	}
}
