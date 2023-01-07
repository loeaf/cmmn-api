package com.spo.cmmn.admin.dto;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionDTO implements Serializable {
	private static final long serialVersionUID = -5624457780444463151L;
	
	@Id
	private String session_usrid;
	private String session_usrname;
	private String session_orgid;
	private String session_orgname;
	private String session_instcd;
	private String session_instname;
	
	private String session_message;
	
	public String getSession_usrid() {
		return session_usrid;
	}

	public void setSession_usrid(String session_usrid) {
		this.session_usrid = session_usrid;
	}

	public String getSession_usrname() {
		return session_usrname;
	}

	public void setSession_usrname(String session_usrname) {
		this.session_usrname = session_usrname;
	}

	public String getSession_orgid() {
		return session_orgid;
	}

	public void setSession_orgid(String session_orgid) {
		this.session_orgid = session_orgid;
	}

	public String getSession_orgname() {
		return session_orgname;
	}

	public void setSession_orgname(String session_orgname) {
		this.session_orgname = session_orgname;
	}

	public String getSession_instcd() {
		return session_instcd;
	}

	public void setSession_instcd(String session_instcd) {
		this.session_instcd = session_instcd;
	}

	public String getSession_instname() {
		return session_instname;
	}

	public void setSession_instname(String session_instname) {
		this.session_instname = session_instname;
	}

	public String getSession_message() {
		return session_message;
	}

	public void setSession_message(String session_message) {
		this.session_message = session_message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(session_instcd, session_instname, session_message, session_orgid, session_orgname,
				session_usrid, session_usrname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SessionDTO other = (SessionDTO) obj;
		return Objects.equals(session_instcd, other.session_instcd)
				&& Objects.equals(session_instname, other.session_instname)
				&& Objects.equals(session_message, other.session_message)
				&& Objects.equals(session_orgid, other.session_orgid)
				&& Objects.equals(session_orgname, other.session_orgname)
				&& Objects.equals(session_usrid, other.session_usrid)
				&& Objects.equals(session_usrname, other.session_usrname);
	}
	
	
}
