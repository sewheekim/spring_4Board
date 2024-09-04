package org.iclass.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.iclass.dao.CommunityCommentsMapper;
import org.iclass.dao.CommunityMapper;
import org.iclass.dto.CommunityDTO;
import org.iclass.dto.PageReqDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

//@Component
@Service
@Slf4j
//@RequiredArgsConstructor  //final 변수 커스텀 생성자를 만듭니다.
public class CommunityService {
	//게시판 기능 서비스 - 메인글과 댓글은 하나의 기능.서비스도 1개로 했습니다.
	// 자동 주입 - final 로 하고 생성주입을 했습니다.
	private final CommunityMapper mainDao;
	private final CommunityCommentsMapper cmtDao;
	
	//생성자 주입
	public CommunityService(CommunityMapper mainDao,CommunityCommentsMapper cmtDao) {
		// TODO Auto-generated constructor stub
		this.mainDao = mainDao;
		this.cmtDao = cmtDao;
	}
	
	//페이지네이션+검색 기능으로 글목록 생성
	public Map<String, Object> pageSearchList(int page) {
		//현재 페이지를 전달받아 해당 글목록을 만듭니다.
		//한 페이지 10개씩 보여주기
		PageReqDTO pageDto = PageReqDTO.of(page,10);
		List<CommunityDTO> list = mainDao.getList(pageDto);
		 Map<String, Object> map = new HashMap<>();
		 map.put("pageDto", pageDto);
		 map.put("list", list);
		 return map;
	}
	//글상세보기 : select, 조회수 증가 update
	@Transactional   //트랜잭션 단위에 해당하는 sql 특히 insert,update,delete를
	// 알아서 commit 또는 rollback 합니다.
	public CommunityDTO read(int idx) {
		CommunityDTO dto = mainDao.selectByIdx(idx);
		mainDao.setReadCount(idx);
		return dto;
	}
	
	

}
