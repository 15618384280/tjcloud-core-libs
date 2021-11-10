package com.tjcloud.tenpay.api.enums;

import com.tjcloud.tenpay.api.CMTenpayConstants;

/**
 * 交易类型:1-JSAPI、2-NATIVE、3-APP、4-WAP
 * @author TJ_zhoupf
 *
 */
public enum CMTenpayAppId {
	
		Tenpay_JSAPI (CMTenpayConstants.JSAPI_APP_ID, "JSAPI"),
		Tenpay_NATIVE("", "NATIVE"),
		Tenpay_APP(CMTenpayConstants.MOBILE_APP_ID, "APP"),
		Tenpay_MWEB(CMTenpayConstants.H5_APP_ID, "MWEB"),
		Tenpay_WAPP(CMTenpayConstants.APP_APP_ID, "WAPP");
		
		private final String text;
		private final String status;

		private CMTenpayAppId(String text, String status)
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
			for (CMTenpayAppId e : CMTenpayAppId.values())
			{
				if (e.getStatus().equals(status))
				{
					return e.getText();
				}
			}
			return "";
		}
}
