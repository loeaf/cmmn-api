package com.spo.cmmn.admin.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int seq;
    private String title;
    private String content;
    private String fileurl;
    private Timestamp cdate;
    private Timestamp mdate;
}
