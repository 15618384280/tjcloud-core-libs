package com.tjcloud.tenpay.api.enums;

import com.tjcloud.tenpay.api.HFTenpayConstants;

/**
 * 交易类型:1-JSAPI、2-NATIVE、3-APP、4-WAP
 * @author TJ_zhoupf
 *
 */
public enum HFTenpayMchApiKey {
	
		Tenpay_JSAPI (HFTenpayConstants.JSAPI_MCH_API_KEY, "JSAPI"),
		Tenpay_NATIVE("", "NATIVE"),
		Tenpay_APP(HFTenpayConstants.MOBILE_MCH_API_KEY, "APP"),
		Tenpay_MWEB(HFTenpayConstants.H5_MCH_API_KEY, "MWEB"),
		Tenpay_WAPP(HFTenpayConstants.APP_MCH_API_KEY, "WAPP"),;
		
		private final String text;
		private final String status;

		private HFTenpayMchApiKey(String text, String status)
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
			for (HFTenpayMchApiKey e : HFTenpayMchApiKey.values())
			{
				if (e.getStatus().equals(status))
				{
					return e.getText();
				}
			}
			return "";
		}
}
