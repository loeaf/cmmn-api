package com.spo.cmmn.admin.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import lombok.Data;

/*
 * 2022.11.14. 박현우
 * 
 * 페이징 처리를 위한 DTO 생성
 * 해당 API에서는 DTO나 VO를 각 컨트롤러 별로 생성하지 않으므로 생성자 호출을 통해 페이징을 진행하도록 변형
 */
@Data
public class PagingDTO {

	private int total; // 전체 글 개수
	private int currentPage; // 현재 페이지 번호
	private int totalPages; // 전체 페이지 개수
	private int startPage; // 시작 페이지
	private int endPage; // 종료 페이지
	
	List<?> content; // 데이터
	
	private int size = 10; // 한 화면에 보여질 게시글의 기본 개수
	private int pagingCnt = 5; // 화면에 보여질 페이지의 기본 개수

	/**
	 * 페이징 생성을 위한 생성자 (권장)
	 * @param total 전체 글 개수 (SQL)
	 * @param currentPage 현재 페이지 번호
	 * @param size 한 화면에 보여질 게시글의 기본 개수
	 * @param pagingCnt 화면에 보여질 페이지의 기본 개수
	 * @param content 게시글 데이터 (페이징처리 SQL)
	 */
	public PagingDTO(int total, int currentPage, int size, int pagingCnt, List<?> content) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		this.pagingCnt = pagingCnt;

		Paging(total, currentPage, size, pagingCnt, content);
	}
	
	
	/**
	 * 페이징 생성을 위한 생성자 (기본 설정된 페이징 pagingCnt,  size)
	 * @param total 전체 글 개수 (SQL)
	 * @param currentPage 현재 페이지 번호
	 * @param content 게시글 데이터 (페이징처리 SQL)
	 */
	public PagingDTO(int total, int currentPage, List<?> content) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		
		Paging(total, currentPage, this.size, this.pagingCnt, content);
	}
	
	private void Paging(int total, int currentPage, int size, int pagingCnt, List<?> content) {
		if (total == 0 || content == null) {// 글이 없을시 기본값 설정
			this.total = 0;
			this.startPage = 0;
			this.endPage = 0;
		} else {//글이 존재 시
			
			//전체 페이지 개수 설정
			totalPages = total / size;
			
			//만약 페이지할 데이터가 없다면 최소페이지 설정
			if (total % size > 0) {
				totalPages++;
			}
			
			//시작 페이지 설정
			startPage = currentPage / pagingCnt * pagingCnt + 1;
			//시작 페이지 보정 (현재페이지5 / 페이지개수5 * 페이지개수5 + 1 일 경우 페이지 오버)
			if(currentPage % pagingCnt == 0){
				startPage -= pagingCnt;
			}
			
			//종료 페이지 설정
			endPage = startPage + pagingCnt - 1 ;
			//종료 페이지 보정 (종료 페이지가 total페이지보다 높을 때)
			if(endPage > totalPages) {
				endPage = totalPages;
			}
			
			//데이터 가공, SQL을 거치지 않은경우 (데이터 > 사이즈)
			if(content.size() > size) {
				this.content =  Arrays.asList(content.stream().skip((size * currentPage) - size).limit(size));
			}
		}
	}
}
