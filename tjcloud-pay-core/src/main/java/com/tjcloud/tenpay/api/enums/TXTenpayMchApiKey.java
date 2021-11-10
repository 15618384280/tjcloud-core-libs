package com.tjcloud.tenpay.api.enums;

import com.tjcloud.tenpay.api.TXTenpayConstants;

/**
 * 交易类型:1-JSAPI、2-NATIVE、3-APP、4-WAP
 * @author TJ_zhoupf
 *
 */
public enum TXTenpayMchApiKey {
	
		Tenpay_JSAPI (TXTenpayConstants.JSAPI_MCH_API_KEY, "JSAPI"),
		Tenpay_NATIVE("", "NATIVE"),
		Tenpay_APP(TXTenpayConstants.MOBILE_MCH_API_KEY, "APP"),
		Tenpay_WAP("", "WAP"),;
		
		private final String text;
		private final String status;

		private TXTenpayMchApiKey(String text, String status)
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

		public static String getText(String status)
		{
			for (TXTenpayMchApiKey e : TXTenpayMchApiKey.values())
			{
				if (e.getStatus().equals(status))
				{
					return e.getText();
				}
			}
			return "";
		}
}
