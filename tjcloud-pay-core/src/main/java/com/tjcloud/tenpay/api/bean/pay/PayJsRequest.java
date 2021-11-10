package com.tjcloud.tenpay.api.bean.pay;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 支付 JS 请求
 * @author LiYi
 *
 */
public class PayJsRequest {

	@JSONField(name="appId")
	private String appid;

	@JSONField(name="timeStamp")
	private String timestamp;

	@JSONField(name="nonceStr")
	private String noncestr;

	@JSONField(name="package")
	private String package_;

	@JSONField(name="sign")
	private String sign;
	
	@JSONField(name="signType")
	private String signtype;
	
	@JSONField(name="paySign")
	private String paysign;
	
	@JSONField(name="partnerId")
	private String partnerid;
	
	@JSONField(name="prepayId")
	private String prepayid;


	public String getPackage_() {
		return package_;
	}

	public void setPackage_(String package1) {
		package_ = package1;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSigntype() {
		return signtype;
	}

	public void setSigntype(String signtype) {
		this.signtype = signtype;
	}

	public String getPaysign() {
		return paysign;
	}

	public void setPaysign(String paysign) {
		this.paysign = paysign;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNoncestr() {
		return noncestr;
	}

	public void setNoncestr(String noncestr) {
		this.noncestr = noncestr;
	}

	public String getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(String partnerid) {
		this.partnerid = partnerid;
	}

	public String getPrepayid() {
		return prepayid;
	}

	public void setPrepayid(String prepayid) {
		this.prepayid = prepayid;
	}

}
