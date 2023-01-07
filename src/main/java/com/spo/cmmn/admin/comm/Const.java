package com.spo.cmmn.admin.comm;

public class Const {

	public Const() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * 트랜잭션-기본 권리 생성 
	 */
	public static final String[] BASIS_AUTH_ID = {"1101","1102","1103","1104","1105","1106" };
	public static final String[] BASIS_AUTH_NM = {"총괄운영자","기관관리자","기관사용자","외부기관사용자","사건관리자","사건담당자" };
	public static final String[] BASIS_AUTH_ENM = {"opmng","insttmng","insttusr","otinsttusr","incdntmng","incdntusr" };
	public static final String[] BASIS_AUTH_DESC = {"기관관리, 사건관리시스템 운영"
			,"사건관리시스템접근, 사건관리시스템 기관사용자관리, 사건목록조"
			,"사건관리시스템접근, 사건관리시스템 기관조직변경, 사건목록조회"
			,"사건담당자대상"
			,"사건관리시스템접근,사건목록조회, 사건목록변경, 사건송치, 디지털증거폐기/등록, 파일암호해제신청, 사건병합, 서비스기간수정"
			,"사건관리시스템접근,사건목록조회, 당사건상세정보조회, 정보변경, 파일암호해제신청" };


}
