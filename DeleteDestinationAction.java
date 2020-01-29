package com.internousdev.mocha.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mocha.dao.DestinationInfoDAO;
import com.internousdev.mocha.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class DeleteDestinationAction extends ActionSupport implements SessionAware {

	private String id;
	private Map<String, Object> session;
	private List<DestinationInfoDTO> destinationInfoDTOList;

	public String execute() {
		//sessionからString型の値を取り出し変数に格納
		String mochalogin = String.valueOf(session.get("logined"));
		int logined = "null".equals(mochalogin)? 0 : Integer.parseInt(mochalogin);
		//もしログインしていたらloginError
				if(logined !=1) {
		return "loginerror";
	}

	String result = ERROR;
	//DestinationInfoDAOから削除メソッドを持ってくる
	DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
	int count = destinationInfoDAO.deleteDestination(id);
	//DestinationInfoDAOから宛先情報取得メソッドを持ってくる
	if(count > 0) {
		destinationInfoDTOList = destinationInfoDAO.getDestinationInfo(session.get("userId").toString());
	    result = SUCCESS;
	}
	return result;
}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<DestinationInfoDTO> getDestinationInfoDTOList() {
		return destinationInfoDTOList;
	}
	public void setDestinationInfoDTOList(List<DestinationInfoDTO> destinationInfoDTOList) {
		this.destinationInfoDTOList = destinationInfoDTOList;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}


