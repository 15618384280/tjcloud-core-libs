package com.tjcloud.tenpay.api.utils;

import com.tjcloud.tenpay.api.bean.mchpay.MchPayApp;
import com.tjcloud.tenpay.api.bean.mchpay.MchPayNativeReply;
import com.tjcloud.tenpay.api.bean.pay.PayJsRequest;
import com.tjcloud.tenpay.api.enums.CMTenpayAppId;
import com.tjcloud.tenpay.api.enums.CMTenpayMchApiKey;
import com.tjcloud.tenpay.api.enums.TenpayTradeType;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class CmPayUtil {
	
	/**
	 * (MCH)生成支付JS请求对象
	 * @param prepay_id	预支付订单号
	 * @param appId appId
	 * @param key 商户支付密钥
	 * @return json
	 */
	public static String generateMchPayJsRequestJson(String prepayId,String partnerId,String tradeType){
//		appId，partnerId，prepayId，nonceStr，timeStamp，package。注意：package的值格式为Sign=WXPay 
		String package_ = "Sign=WXPay";
		if(TenpayTradeType.Tenpay_JSAPI.getText().equals(tradeType) || TenpayTradeType.Tenpay_MWEB.getText().equals(tradeType) || TenpayTradeType.Tenpay_WAPP.getText().equals(tradeType)){
			package_ = "prepay_id="+prepayId;
		}else{
			package_ = "Sign=WXPay";
		}
		PayJsRequest payJsRequest = new PayJsRequest();
		payJsRequest.setAppid(CMTenpayAppId.getText(tradeType));
		payJsRequest.setNoncestr(UUID.randomUUID().toString().replace("-", ""));
		payJsRequest.setTimestamp(System.currentTimeMillis()/1000+"");
		payJsRequest.setPackage_(package_);
		if(TenpayTradeType.Tenpay_JSAPI.getText().equals(tradeType)|| TenpayTradeType.Tenpay_MWEB.getText().equals(tradeType) || TenpayTradeType.Tenpay_WAPP.getText().equals(tradeType)){
			payJsRequest.setSigntype("MD5");
		}else{
			payJsRequest.setPrepayid(prepayId);
			payJsRequest.setPartnerid(partnerId);
		}
		Map<String, String> mapS = (TenpayTradeType.Tenpay_JSAPI.getText().equals(tradeType)|| TenpayTradeType.Tenpay_MWEB.getText().equals(tradeType) || TenpayTradeType.Tenpay_WAPP.getText().equals(tradeType))
								 ? MapUtil.jsonStringToMap(JsonUtil.toJSONString(payJsRequest))
								 : MapUtil.objectToMap(payJsRequest);
		String paySign = TenpaySignature.generateSign(mapS,CMTenpayMchApiKey.getText(tradeType));
		if(TenpayTradeType.Tenpay_JSAPI.getText().equals(tradeType)|| TenpayTradeType.Tenpay_MWEB.getText().equals(tradeType)){
			payJsRequest.setPaysign(paySign);
		}else{
			payJsRequest.setSign(paySign);
		}
		return JsonUtil.toJSONString(payJsRequest);
	}

	/**
	 * (MCH)生成支付JS请求对象
	 * @param prepay_id	预支付订单号
	 * @param appId appId
	 * @param key 商户支付密钥
	 * @return json
	 */
	public static String generateMchPayJsRequestJson(String prepayId,String partnerId,String appId,String key){
		String package_ = "prepay_id="+prepayId;
		PayJsRequest payJsRequest = new PayJsRequest();
		payJsRequest.setAppid(appId);
		payJsRequest.setPartnerid(partnerId);
		payJsRequest.setPrepayid(prepayId);
		payJsRequest.setNoncestr(UUID.randomUUID().toString().replace("-", ""));
		payJsRequest.setPackage_(package_);
		payJsRequest.setTimestamp(System.currentTimeMillis()/1000+"");
		Map<String, String> mapS = MapUtil.objectToMap(payJsRequest);
		String paySign = TenpaySignature.generateSign(mapS,key);
		payJsRequest.setSign(paySign);
		return JsonUtil.toJSONString(payJsRequest);
	}


	/**
	 * (MCH)生成Native支付请求URL
	 * @param appid appid
	 * @param mch_id mch_id
	 * @param productid productid
	 * @param key key
	 * @return url
	 */
	public static String generateMchPayNativeRequestURL(
			String appid,
			String mch_id,
			String productid,
			String key){
		Map<String,String> map = new LinkedHashMap<String,String>();
		map.put("appid",appid);
		map.put("mch_id",mch_id);
		map.put("time_stamp",System.currentTimeMillis()/1000+"");
		map.put("nonce_str",UUID.randomUUID().toString().replace("-", ""));
		map.put("product_id",productid);
		String sign = TenpaySignature.generateSign(map,key);
		map.put("sign",sign);
		return "weixin://wxpay/bizpayurl?" + MapUtil.mapJoin(map);
	}

	/**
	 * (MCH)生成 native 支付回复XML
	 * @param mchPayNativeReply mchPayNativeReply
	 * @param key key
	 * @return xml
	 */
	public static String generateMchPayNativeReplyXML(MchPayNativeReply mchPayNativeReply,String key){
		Map<String, String> map = MapUtil.objectToMap(mchPayNativeReply);
		String sign = TenpaySignature.generateSign(map,key);
		mchPayNativeReply.setSign(sign);
		return XMLUtil.convertToXML(mchPayNativeReply);
	}

	/**
	 * (MCH)生成支付APP请求数据
	 * @param prepay_id	预支付订单号
	 * @param appId appId
	 * @param partnerid 商户平台号
	 * @param key 商户支付密钥
	 * @return app data
	 */
	public static MchPayApp generateMchAppData(String prepay_id,String appId,String partnerid,String key){
		Map<String, String> wx_map = new LinkedHashMap<String, String>();
		wx_map.put("appid", appId);
		wx_map.put("partnerid", partnerid);
		wx_map.put("prepayid", prepay_id);
		wx_map.put("package", "Sign=WXPay");
		wx_map.put("noncestr", UUID.randomUUID().toString().replace("-", ""));
		wx_map.put("timestamp", System.currentTimeMillis()/1000+"");
		String sign = TenpaySignature.generateSign(wx_map,key);
		MchPayApp mchPayApp = new MchPayApp();
		mchPayApp.setAppid(appId);
		mchPayApp.setPartnerid(partnerid);
		mchPayApp.setPrepayid(prepay_id);
		mchPayApp.setPackage_(wx_map.get("package"));
		mchPayApp.setNoncestr(wx_map.get("noncestr"));
		mchPayApp.setTimestamp(wx_map.get("timestamp"));
		mchPayApp.setSign(sign);
		return mchPayApp;
	}
}