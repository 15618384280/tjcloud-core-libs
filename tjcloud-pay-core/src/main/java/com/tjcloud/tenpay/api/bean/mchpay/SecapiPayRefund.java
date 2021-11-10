package com.tjcloud.tenpay.api.bean.mchpay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 退款申请
 *
 * @author Yi
 *
 */

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class SecapiPayRefund {

	@XmlElement
	private String appid;				//微信分配的公众账号 ID

	@XmlElement
	private String mch_id;				//微信支付分配的商户号

	@XmlElement
	private String device_info;			//微信支付分配的终端设备号，与下单一致

	@XmlElement
	private String nonce_str;			//随机字符串，不长于 32 位

	@XmlElement
	private String sign;				//签名

	@XmlElement
	private String transaction_id;		//微信订单号

	@XmlElement
	private String out_trade_no;		//商户系统内部的订单号,transaction_id 、 out_trade_no 二选一，如果同时 存 在 优 先 级 ：transaction_id>out_trade_no

	@XmlElement
	private String out_refund_no;		//商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔

	@XmlElement
	private Integer total_fee;			//订单总金额，单位为分

	@XmlElement
	private Integer refund_fee;			//退款总金额，单位为分,可以做部分退款

	@XmlElement
	private String op_user_id;			//操作员帐号, 默认为商户号

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
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

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getOut_refund_no() {
		return out_refund_no;
	}

	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}

	public Integer getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	public Integer getRefund_fee() {
		return refund_fee;
	}

	public void setRefund_fee(Integer refund_fee) {
		this.refund_fee = refund_fee;
	}

	public String getOp_user_id() {
		return op_user_id;
	}

	public void setOp_user_id(String op_user_id) {
		this.op_user_id = op_user_id;
	}

}
