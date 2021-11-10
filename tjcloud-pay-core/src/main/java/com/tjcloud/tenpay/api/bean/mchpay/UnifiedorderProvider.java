package com.tjcloud.tenpay.api.bean.mchpay;

import com.tjcloud.tenpay.api.bean.AdaptorCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 统一支付请求参数
 * @author Yi
 *
 */

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class UnifiedorderProvider {

	@XmlElement
	private String appid;								//服务商商户的APPID

	@XmlElement
	private String mch_id;								//微信支付分配的商户号

	@XmlElement
	private String sub_appid;							//当前调起支付的小程序APPID

	@XmlElement
	private String sub_mch_id;							//微信支付分配的子商户号

	@XmlElement
	private String device_info;							//微信支付分配的终端设备号

	@XmlElement
	private String nonce_str;							//随机字符串，不长于 32 位

	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String sign;								//Sign 签名生

	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String body;								//商品描述

	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String detail;								// 

	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String attach;								//附加数据，原样返回

	@XmlElement
	private String out_trade_no;						//商户系统内部的订单号,32个字符内、可包含字母,确保 在商户系统唯一

	@XmlElement
	private String total_fee;							//订单总金额，单位为分，不能带小数点

	@XmlElement
	private String spbill_create_ip;					//订单生成的机器 IP

	@XmlElement
	private String time_start;							//订 单 生 成 时 间  ， 格 式 为yyyyMMddHHmmss，如 2009 年12 月 27 日 9 点 10 分 10 秒表示为 20091227091010。时区为 GMT+8 beijing。该时间取自商户服务器

	@XmlElement
	private String time_expire;							//订 单 失 效 时 间 ， 格 式 为yyyyMMddHHmmss，如 2009 年12 月 27 日 9 点 10 分 10 秒表示为 20091227091010。时区为 GMT+8 beijing。该时间取自商户服务器

	@XmlElement
	private String goods_tag;							//商品标记，该字段不能随便填，不使用请填空，

	@XmlElement
	private String notify_url;							//通知地址：接收微信支付成功通知

	@XmlElement
	private String trade_type;							//交易类型：JSAPI、NATIVE、APP

	@XmlElement
	private String product_id;							//商品 ID：只在 trade_type 为 NATIVE时需要填写。此 id 为二维码中包含的商品 ID，商户自行维护。

	@XmlElement
	private String limit_pay;

	@XmlElement
	private String profit_sharing;						// 是否需要分账

	@XmlElement
	private String openid;								// 用户在商户 appid 下的唯一标识，trade_type 为 JSAPI时，此参数必传

	@XmlElement
	private String sub_openid;							// 用户在商户 appid 下的唯一标识，trade_type 为 JSAPI时，此参数必传



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

	public String getSub_appid() {
		return sub_appid;
	}

	public void setSub_appid(String sub_appid) {
		this.sub_appid = sub_appid;
	}

	public String getSub_mch_id() {
		return sub_mch_id;
	}

	public void setSub_mch_id(String sub_mch_id) {
		this.sub_mch_id = sub_mch_id;
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_expire() {
		return time_expire;
	}

	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getSub_openid() {
		return sub_openid;
	}

	public void setSub_openid(String sub_openid) {
		this.sub_openid = sub_openid;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getLimit_pay() {
		return limit_pay;
	}

	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}

	public String getProfit_sharing() {
		return profit_sharing;
	}

	public void setProfit_sharing(String profit_sharing) {
		this.profit_sharing = profit_sharing;
	}
}
