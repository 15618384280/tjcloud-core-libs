package com.tjcloud.tenpay.api;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;

public abstract class CMTenpayConstants {
	public static final String PARAM_ACCESS_TOKEN = "access_token";

	public static final Header jsonHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
	public static final Header xmlHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_XML.toString());

	public static final String JSAPI_MCH_ID = "1220368201";										//公众号商户ID
	public static final String JSAPI_MCH_API_KEY = "f51edee6db15bfe888c0923aadd5c124";			//公众号商户ID
	public static final String JSAPI_APP_ID = "wx70452922d7f8144c";								//公众号应用ID
	public static final String JSAPI_APP_SECRET = "76d15ab0e1b20fe0693df2c85c6462db";			//公众号商户ID
	
	public static final String H5_MCH_ID = "1224494802";										//测试H5商户ID
	public static final String H5_MCH_API_KEY = "f51edee6db15bfe888c0923aadd5c124";				//测试H5商户ID
	public static final String H5_APP_ID = "wx70452922d7f8144c";								//测试H5应用ID
	public static final String H5_APP_SECRET = "76d15ab0e1b20fe0693df2c85c6462db";				//测试H5商户ID

	public static final String APP_MCH_ID = "1220368201";										//小程序商户ID
	public static final String APP_MCH_API_KEY = "f51edee6db15bfe888c0923aadd5c124";			//小程序商户ID
	public static final String APP_APP_ID = "wx70452922d7f8144c";								//小程序应用ID
	public static final String APP_APP_SECRET = "76d15ab0e1b20fe0693df2c85c6462db";				//小程序商户ID
	
	public static final String MOBILE_MCH_ID = "1225269001";								//要运动移动应用商户ID
	public static final String MOBILE_MCH_API_KEY = "67a0d2ba991da33c5651f191050e980d";		//要运动移动应用商户ID
	public static final String MOBILE_APP_ID = "wx5a65ff38c53a97d2";						//要运动移动应用应用ID
	public static final String MOBILE_APP_SECRET = "29e195e8d1ff7ca419324091793b6df6";		//要运动移动应用商户ID
	
	public static final String BASE_API_URI = "https://api.weixin.qq.com";
	public static final String MCH_API_URI = "https://api.mch.weixin.qq.com";
	public static final String MEDIA_API_URI = "http://file.api.weixin.qq.com";
	public static final String MP_API_URI = "https://mp.weixin.qq.com";
	public static final String OPEN_API_URI = "https://open.weixin.qq.com";
	public static final String APP_PAYCALLBACK_URI = "http://192.168.2.234:8088/v3/orders/%s/pay/%s/callback";
}
