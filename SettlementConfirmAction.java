package com.internousdev.mocha.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mocha.dao.DestinationInfoDAO;
import com.internousdev.mocha.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementConfirmAction extends ActionSupport implements SessionAware {
	public List<DestinationInfoDTO> destinationInfoDTOList;
	public Map<String, Object> session;

	public String execute() {
		//sessionからString型の値を取り出し変数に格納
		String mochalogined = String.valueOf(session.get("logined"));
		int logined = "null".equals(mochalogined) ? 0 : Integer.parseInt(mochalogined);
		//もしログインしていたらloginError
		if (logined != 1) {
			return "loginError";
		}

		//ログインしていたらID取得
		String user_id = session.get("userId").toString();

		DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
		destinationInfoDTOList = destinationInfoDAO.getDestinationInfo(user_id);

		return SUCCESS;
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