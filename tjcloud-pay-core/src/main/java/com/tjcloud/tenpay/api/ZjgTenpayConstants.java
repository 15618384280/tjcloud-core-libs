package com.tjcloud.tenpay.api;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;

public abstract class ZjgTenpayConstants {
	public static final String PARAM_ACCESS_TOKEN = "access_token";

	public static final Header jsonHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
	public static final Header xmlHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_XML.toString());

	public static final String JSAPI_MCH_ID = "1220368201";										//公众号商户ID
	public static final String JSAPI_MCH_API_KEY = "f51edee6db15bfe888c0923aadd5c124";			//公众号商户ID
	public static final String JSAPI_APP_ID = "wx0b2562bbc58776e5";								//公众号应用ID
	public static final String JSAPI_APP_SECRET = "ad8711265d7255ecc520d3e1163ae087";			//公众号商户ID

	public static final String MOBILE_MCH_ID = "1358809302";								//张家港移动应用商户ID
	public static final String MOBILE_MCH_API_KEY = "8wj8snhzd9pmiaqh1b4nh5mie37oee4r";		//张家港移动应用商户ID
	public static final String MOBILE_APP_ID = "wx755f1e46e7a3d41b";						//张家港移动应用应用ID
	public static final String MOBILE_APP_SECRET = "3b10663919c62215e1d7383784e35fe9";		//张家港移动应用商户ID

//	public static final String MOBILE_MCH_ID = "1387156702";								//上海体院移动应用商户ID
//	public static final String MOBILE_MCH_API_KEY = "1RzAj7J5JkJ2JCov0Ut7aD2eoaXrd8Dm";		//上海体院移动应用商户ID
//	public static final String MOBILE_APP_ID = "wxd9847f66d09f5a85";						//上海体院移动应用应用ID
//	public static final String MOBILE_APP_SECRET = "174d6690ab443ac01cee0f37f79963fe";		//上海体院移动应用商户ID

	public static final String BASE_API_URI = "https://api.weixin.qq.com";
	public static final String MCH_API_URI = "https://api.mch.weixin.qq.com";
	public static final String MEDIA_API_URI = "http://file.api.weixin.qq.com";
	public static final String MP_API_URI = "https://mp.weixin.qq.com";
	public static final String OPEN_API_URI = "https://open.weixin.qq.com";
	public static final String APP_PAYCALLBACK_URI = "http://192.168.2.234:8088/v3/orders/%s/pay/%s/callback";
}
