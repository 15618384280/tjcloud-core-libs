package com.tjcloud.tenpay.api.enums;

/**
 * 交易状态：SUCCESS—支付成功、REFUND—转入退款、NOTPAY—未支付、CLOSED—已关闭、REVOKED—已撤销（刷卡支付）、USERPAYING--用户支付中、PAYERROR--支付失败(其他原因，如银行返回失败)
 * @author TJ_zhoupf
 *
 */
public enum TenpayTradeStatus {
	
	SUCCESS("支付成功", "SUCCESS"),
	REFUND("转入退款", "REFUND"),
	NOTPAY("未支付 ", "NOTPAY"),
	CLOSED("已关闭 ", "CLOSED"),
	REVOKED("已撤销（刷卡支付）  ", "REVOKED"),
	USERPAYING("用户支付中", "USERPAYING"),
	PAYERROR("支付失败(其他原因，如银行返回失败)", "PAYERROR"),;

	private final String text;
	private final String status;

	private TenpayTradeStatus(String text, String status)
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
		for (TenpayTradeStatus e : TenpayTradeStatus.values())
		{
			if (e.getStatus().equals(status))
			{
				return e.getText();
			}
		}
		return "";
	}
}
