package com.tjcloud.tenpay.api.bean.mchpay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class CloseSeparateAccount implements Serializable {

	@XmlElement
	private String mch_id;				//微信支付分配的服务商商户号

	@XmlElement
	private String sub_mch_id;			//微信支付分配的子商户号，即分账的出资商户号。

	@XmlElement
	private String brand_mch_id;		//当服务商开通了“连锁品牌工具”后，使用品牌供应链分账时，此参数传入品牌主商户号。

	@XmlElement
	private String appid;				//微信分配的服务商appid

	@XmlElement
	private String nonce_str;			//随机字符串

	@XmlElement
	private String sign;				//签名

	@XmlElement
	private String sign_type;			//签名类型

	@XmlElement
	private String transaction_id;		//微信支付订单号

	@XmlElement
	private String out_order_no;		//商户系统内部的分账单号

	@XmlElement
	private String description;			//分账完结的原因描述

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getSub_mch_id() {
		return sub_mch_id;
	}

	public void setSub_mch_id(String sub_mch_id) {
		this.sub_mch_id = sub_mch_id;
	}

	public String getBrand_mch_id() {
		return brand_mch_id;
	}

	public void setBrand_mch_id(String brand_mch_id) {
		this.brand_mch_id = brand_mch_id;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_order_no() {
		return out_order_no;
	}

	public void setOut_order_no(String out_order_no) {
		this.out_order_no = out_order_no;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
