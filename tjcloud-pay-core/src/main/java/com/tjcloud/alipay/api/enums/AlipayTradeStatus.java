package com.tjcloud.alipay.api.enums;

/**
 * 交易状态：WAIT_BUYER_PAY（交易创建，等待买家付款）、TRADE_CLOSED（未付款交易超时关闭，或支付完成后全额退款）、TRADE_SUCCESS（交易支付成功）、TRADE_FINISHED（交易结束，不可退款） 
 * @author TJ_zhoupf
 *
 */
public enum AlipayTradeStatus {
	
	WAIT_BUYER_PAY("交易创建，等待买家付款", "WAIT_BUYER_PAY"),
	TRADE_CLOSED("未付款交易超时关闭，或支付完成后全额退款", "TRADE_CLOSED"),
	TRADE_SUCCESS("交易支付成功", "TRADE_SUCCESS"),
	TRADE_FINISHED("交易结束，不可退款", "TRADE_FINISHED");

	private final String text;
	private final String status;

	private AlipayTradeStatus(String text, String status)
	{
		this.text = text;
		this.status = status;
	}

	public String getText()
	{
		return text;
	}

	public String getStatus()
	{
		return status;
	}

	public static String getText(int status)
	{
		for (AlipayTradeStatus e : AlipayTradeStatus.values())
		{
			if (e.getStatus().equals(status))
			{
				return e.getText();
			}
		}
		return "";
	}
}
