package org.iclass.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageReqDTO {
		private int page =1 ;		// 요청페이지
		private int pageSize = 10;	// 페이지의 글개수
		private int startNo;	// 페이지 글목록의 시작 rownum
		private int endNo;		// 페이지 글목록의 마지막 rownum
		
		private PageReqDTO() { 	}
		
		public static PageReqDTO of(int page, int pageSize) {
			int startNo = (page-1)*pageSize +1;
			int endNo = startNo + (pageSize-1);
			
			PageReqDTO dto = new PageReqDTO();
			dto.setPage(page);
			dto.setPageSize(pageSize);
			dto.setStartNo(startNo);
			dto.setEndNo(endNo);
			return dto;
		}

}
