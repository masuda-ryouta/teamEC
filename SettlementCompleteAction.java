package com.internousdev.mocha.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mocha.dao.CartInfoDAO;
import com.internousdev.mocha.dao.PurchaseHistoryInfoDAO;
import com.internousdev.mocha.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementCompleteAction extends ActionSupport implements SessionAware {
	private String id;
	private Map<String, Object> session;

	public String execute() throws SQLException {
		//sessionからString型の値を取り出し変数に格納
		String mochalogin = String.valueOf(session.get("logined"));
		int logined = "null".equals(mochalogin) ? 0 : Integer.parseInt(mochalogin);
		//もしログインしていたらloginError
		if (logined != 1) {
			return "loginError";
		}
		String result = ERROR;

		String user_id = session.get("userId").toString();

		//CartInfoDAOListにuser_idを格納
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		List<CartInfoDTO> cartInfoDTOList = cartInfoDAO.getCartInfo(user_id);

		//purchaseHistoryInfoDAOからメソッドを持ってくる
		PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
		int count = 0;
		for (CartInfoDTO dto : cartInfoDTOList) {
			count = purchaseHistoryInfoDAO.regist(
					user_id,
					dto.getProduct_id(),
					dto.getProduct_count(),
					Integer.parseInt(id),
					dto.getPrice());
		}
		//CartInfoDAOから削除メソッドを持ってくる
		if (count > 0) {
			count = cartInfoDAO.cartInfoDeleteSettlement(String.valueOf(session.get("userId")));
			if (count > 0) {
				result = SUCCESS;
			}
		}
		return result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}