package com.tjcloud.tenpay.api;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;

public abstract class HFTenpayConstants {
	public static final String PARAM_ACCESS_TOKEN = "access_token";

	public static final Header jsonHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
	public static final Header xmlHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_XML.toString());

	public static final String JSAPI_MCH_ID = "1510943001";										//测试公众号商户ID
	public static final String JSAPI_MCH_API_KEY = "f51edee6db15bfe888c0923aadd5c124";			//测试公众号商户ID
	public static final String JSAPI_APP_ID = "wxdce91bae7ca18265";								//测试公众号应用ID
	public static final String JSAPI_APP_SECRET = "9a3a034742dc8fae36e43707cde6fe82";			//测试公众号商户ID
	
	public static final String H5_MCH_ID = "1510943001";										//测试H5商户ID
	public static final String H5_MCH_API_KEY = "f51edee6db15bfe888c0923aadd5c124";				//测试H5商户ID
	public static final String H5_APP_ID = "wx1a29ee9bb6703fc1";								//测试H5应用ID
	public static final String H5_APP_SECRET = "5f8ddf9c5702c0ec2b2a9f3df8383c6b";				//测试H5商户ID
	
	public static final String APP_MCH_ID = "1510943001";										//小程序商户ID
	public static final String APP_MCH_API_KEY = "f51edee6db15bfe888c0923aadd5c124";			//小程序商户ID
	public static final String APP_APP_ID = "wx48cee7fd15671ec3";								//小程序应用ID
	public static final String APP_APP_SECRET = "5443e39c515499f32c4f7094e0ff9363";				//小程序商户ID
	
	public static final String MOBILE_MCH_ID = "1510943001";								//移动应用商户ID
	public static final String MOBILE_MCH_API_KEY = "f51edee6db15bfe888c0923aadd5c124";		//移动应用商户ID
	public static final String MOBILE_APP_ID = "wx427c049ffecca8cd";						//移动应用应用ID
	public static final String MOBILE_APP_SECRET = "4d49be1206368b92cf7eca71fab20451";		//移动应用商户ID
	

	public static final String BASE_API_URI = "https://api.weixin.qq.com";
	public static final String MCH_API_URI = "https://api.mch.weixin.qq.com";
	public static final String MEDIA_API_URI = "http://file.api.weixin.qq.com";
	public static final String MP_API_URI = "https://mp.weixin.qq.com";
	public static final String OPEN_API_URI = "https://open.weixin.qq.com";
	public static final String APP_PAYCALLBACK_URI = "http://192.168.2.234:8088/v3/orders/%s/pay/%s/callback";
}
