package com.tjcloud.alipay.base.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

import java.util.Map;

/**
 * 支付宝交易(alipay_trade)
 * @author auto bin.yin 2016.07.18
 */
@LogRequired
public class AlipayTrade extends AbstractEntity {
	private static final long serialVersionUID = 1468828765914L;

	@JsonProperty("trade_no")
	private String tradeNo; //支付宝交易号
	@JsonProperty("out_trade_no")
	private String outTradeNo; //商户订单号
	@JsonProperty("seller_id")
	private String sellerId; //卖家支付宝用户ID
	@JsonProperty("seller_auth_id")
	private String sellerAuthId; //卖家认证编号
	@JsonProperty("buyer_logon_id")
	private String buyerLogonId; //买家支付宝账号
	@JsonProperty("buyer_id")
	private String buyerId; //买家支付宝用户ID
	@JsonProperty("buyer_auth_id")
	private String buyerAuthId; //买家认证编号
	@JsonProperty("trade_status")
	private String tradeStatus; //交易状态：WAIT_BUYER_PAY（交易创建，等待买家付款）、TRADE_CLOSED（未付款交易超时关闭，或支付完成后全额退款）、TRADE_SUCCESS（交易支付成功）、TRADE_FINISHED（交易结束，不可退款）
	@JsonProperty("platform_trade_status")
	private String platformTradeStatus; //平台交易状态
	@JsonProperty("qr_code")
	private String qrCode; //支付二维码地址
	@JsonProperty("total_amount")
	private String totalAmount; //订单总金额
	@JsonProperty("discountable_amount")
	private String discountableAmount; //可打折金额. 参与优惠计算的金额
	@JsonProperty("undiscountable_amount")
	private String undiscountableAmount; //不可打折金额. 不参与优惠计算的金额
	@JsonProperty("receipt_amount")
	private String receiptAmount; //实收金额
	@JsonProperty("buyer_pay_amount")
	private String payAmount; //买家实付金额
	@JsonProperty("point_amount")
	private String pointAmount; //积分支付的金额
	@JsonProperty("invoice_amount")
	private String invoiceAmount; //可开具发票的金额
	@JsonProperty("send_pay_date")
	private String payDate; //付款时间
	@JsonProperty("subject")
	private String subject; //订单标题
	@JsonProperty("body")
	private String body; //商品描述
	@JsonProperty("operator_id")
	private String operatorId; //商户操作员编号
	@JsonProperty("alipay_store_id")
	private String shopId; //支付宝店铺编号
	@JsonProperty("store_id")
	private String storeId; //商户门店编号
	@JsonProperty("store_name")
	private String storeName; //商户门店名称
	@JsonProperty("terminal_id")
	private String terminalId; //商户机具终端编号
	@JsonProperty("timeout_express")
	private String timeoutExpress; //该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）
	@JsonProperty("timeout_time")
	private Long timeoutTime; //超时时间

	@JsonProperty("cance_flag")
	private String canceFlag; //交易是否已撤销
	@JsonProperty("cancel_time")
	private Long cancelTime; //交易撤销时间
	@JsonProperty("refund_flag")
	private String refundFlag; //交易是否发生退款
	@JsonProperty("refund_time")
	private Long refundTime; //交易退款时间
	@JsonProperty("close_flag")
	private String closeFlag; //交易是否已关闭
	@JsonProperty("close_time")
	private Long closeTime; //交易关闭时间
	@JsonProperty("close_reason")
	private String closeReason; //交易关闭原因

	@JsonProperty("app_type")
	private String appType; //交易关闭原因
	
	@JsonProperty("business_params")
	private Map<String, String> businessParams;
	@JsonProperty("extend_params")
	private Map<String, String> extendParams;
	@JsonProperty("promo_params")
	private Map<String, String> promoParams;

	public String getTradeNo() {
		return this.tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getOutTradeNo() {
		return this.outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getSellerId() {
		return this.sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerAuthId() {
		return this.sellerAuthId;
	}
	public void setSellerAuthId(String sellerAuthId) {
		this.sellerAuthId = sellerAuthId;
	}

	public String getBuyerLogonId() {
		return buyerLogonId;
	}
	public void setBuyerLogonId(String buyerLogonId) {
		this.buyerLogonId = buyerLogonId;
	}

	public String getBuyerId() {
		return this.buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerAuthId() {
		return this.buyerAuthId;
	}
	public void setBuyerAuthId(String buyerAuthId) {
		this.buyerAuthId = buyerAuthId;
	}

	public String getTradeStatus() {
		return this.tradeStatus;
	}
	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public String getPlatformTradeStatus() {
		return platformTradeStatus;
	}
	public void setPlatformTradeStatus(String platformTradeStatus) {
		this.platformTradeStatus = platformTradeStatus;
	}

	public String getQrCode() {
		return this.qrCode;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getTotalAmount() {
		return this.totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getDiscountableAmount() {
		return this.discountableAmount;
	}
	public void setDiscountableAmount(String discountableAmount) {
		this.discountableAmount = discountableAmount;
	}

	public String getUndiscountableAmount() {
		return this.undiscountableAmount;
	}
	public void setUndiscountableAmount(String undiscountableAmount) {
		this.undiscountableAmount = undiscountableAmount;
	}

	public String getReceiptAmount() {
		return this.receiptAmount;
	}
	public void setReceiptAmount(String receiptAmount) {
		this.receiptAmount = receiptAmount;
	}

	public String getPayAmount() {
		return this.payAmount;
	}
	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	public String getPointAmount() {
		return this.pointAmount;
	}
	public void setPointAmount(String pointAmount) {
		this.pointAmount = pointAmount;
	}

	public String getInvoiceAmount() {
		return this.invoiceAmount;
	}
	public void setInvoiceAmount(String invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getPayDate() {
		return this.payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public String getSubject() {
		return this.subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return this.body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	public String getOperatorId() {
		return this.operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getShopId() {
		return this.shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getStoreId() {
		return this.storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return this.storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getTerminalId() {
		return this.terminalId;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getTimeoutExpress() {
		return this.timeoutExpress;
	}
	public void setTimeoutExpress(String timeoutExpress) {
		this.timeoutExpress = timeoutExpress;
	}

	public Long getTimeoutTime() {
		return timeoutTime;
	}
	public void setTimeoutTime(Long timeoutTime) {
		this.timeoutTime = timeoutTime;
	}

	public String getCanceFlag() {
		return this.canceFlag;
	}
	public void setCanceFlag(String canceFlag) {
		this.canceFlag = canceFlag;
	}

	public Long getCancelTime() {
		return this.cancelTime;
	}
	public void setCancelTime(Long cancelTime) {
		this.cancelTime = cancelTime;
	}

	public String getRefundFlag() {
		return this.refundFlag;
	}
	public void setRefundFlag(String refundFlag) {
		this.refundFlag = refundFlag;
	}

	public Long getRefundTime() {
		return this.refundTime;
	}
	public void setRefundTime(Long refundTime) {
		this.refundTime = refundTime;
	}

	public String getCloseFlag() {
		return this.closeFlag;
	}
	public void setCloseFlag(String closeFlag) {
		this.closeFlag = closeFlag;
	}

	public Long getCloseTime() {
		return this.closeTime;
	}
	public void setCloseTime(Long closeTime) {
		this.closeTime = closeTime;
	}

	public String getCloseReason() {
		return closeReason;
	}
	public void setCloseReason(String closeReason) {
		this.closeReason = closeReason;
	}
	public String getAppType() {
		return appType;
	}
	public void setAppType(String appType) {
		this.appType = appType;
	}

	public Map<String, String> getBusinessParams() {
		return businessParams;
	}
	public void setBusinessParams(Map<String, String> businessParams) {
		this.businessParams = businessParams;
	}
	public Map<String, String> getExtendParams() {
		return extendParams;
	}
	public void setExtendParams(Map<String, String> extendParams) {
		this.extendParams = extendParams;
	}
	public Map<String, String> getPromoParams() {
		return promoParams;
	}
	public void setPromoParams(Map<String, String> promoParams) {
		this.promoParams = promoParams;
	}
}