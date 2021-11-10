package com.tjcloud.tenpay.api.enums;

import com.tjcloud.tenpay.api.TenpayConstants;

/**
 * 交易类型:1-JSAPI、2-NATIVE、3-APP、4-WAP
 * @author TJ_zhoupf
 *
 */
public enum TenpayAppId {
	
		Tenpay_JSAPI (TenpayConstants.JSAPI_APP_ID, "JSAPI"),
		Tenpay_NATIVE("", "NATIVE"),
		Tenpay_APP(TenpayConstants.MOBILE_APP_ID, "APP"),
		Tenpay_MWEB(TenpayConstants.H5_APP_ID, "MWEB"),
		Tenpay_WAPP(TenpayConstants.APP_APP_ID, "WAPP"),;
		
		private final String text;
		private final String status;

		private TenpayAppId(String text, String status)
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
			for (TenpayAppId e : TenpayAppId.values())
			{
				if (e.getStatus().equals(status))
				{
					return e.getText();
				}
			}
			return "";
		}
}
