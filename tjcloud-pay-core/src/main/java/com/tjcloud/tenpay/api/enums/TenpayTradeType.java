package com.tjcloud.tenpay.api.enums;

/**
 * 交易类型:1-JSAPI、2-NATIVE、3-APP、4-WAP
 * @author TJ_zhoupf
 *
 */
public enum TenpayTradeType {
	
		Tenpay_JSAPI ("JSAPI", 1),
		Tenpay_NATIVE("NATIVE", 2),
		Tenpay_APP("APP", 3),
		Tenpay_MWEB("MWEB", 4),
		Tenpay_WAPP("WAPP", 5),
		YP_Tenpay_WAPP("YP_WAPP", 6),
		JD_Tenpay_WAPP("JD_WAPP", 7);

		private final String text;
		private final int status;

		private TenpayTradeType(String text, int status)
		{
			this.text = text;
			this.status = status;
		}

		public String getText()
		{
			return text;
		}

		public int getStatus()
		{
			return status;
		}

		public static String getText(int status)
		{
			for (TenpayTradeType e : TenpayTradeType.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
		public static int getStatusText(String text)
		{
			for (TenpayTradeType e : TenpayTradeType.values())
			{
				if (e.getText().equals(text))
				{
					return e.getStatus();
				}
			}
			return 0;
		}
}
