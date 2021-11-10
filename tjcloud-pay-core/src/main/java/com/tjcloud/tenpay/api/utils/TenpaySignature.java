package com.tjcloud.tenpay.api.utils;

import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.tenpay.api.bean.pay.PayFeedback;
import com.tjcloud.tenpay.api.bean.pay.PayNativeInput;
import com.tjcloud.tenpay.api.bean.pay.PayNotify;
import com.tjcloud.tenpay.api.bean.pay.PayWarn;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;
import java.util.Map;


public class TenpaySignature {

	private static final Logger logger = LoggerFactory.getLogger(TenpaySignature.class);


	/**
	 * 生成 package 字符串
	 * @param map map
	 * @param paternerKey paternerKey
	 * @return package_str
	 */
	public static String generatePackage(Map<String, String> map, String paternerKey) {
		String sign = generateSign(map, paternerKey);
		Map<String, String> tmap = MapUtil.order(map);
		String s2 = MapUtil.mapJoin(tmap);
		return s2 + "&sign=" + sign;
	}

	/**
	 * 生成sign MD5 加密 toUpperCase
	 * @param map map
	 * @param paternerKey paternerKey
	 * @return sign
	 */
	public static String generateSign(Map<String, String> map, String paternerKey) {
		Map<String, String> tmap = MapUtil.order(map);
		if (tmap.containsKey("sign")) {
			tmap.remove("sign");
		}
		if (tmap.containsKey("package_")) {
			tmap.put("package", tmap.get("package_"));
			tmap.remove("package_");
		}
		String str = MapUtil.mapJoin(tmap);

		logger.info("###############::::::::::::::"+str);
		return DigestUtils.md5Hex(str + "&key=" + paternerKey).toUpperCase();
	}

	public static String generateCloseSign(Map<String, String> map, String paternerKey) {
		Map<String, String> tmap = MapUtil.order(map);
		if (tmap.containsKey("sign")) {
			tmap.remove("sign");
		}

		String str = MapUtil.mapJoin(tmap);

		logger.info("###############::::::::::::::"+str);
		return HmacUtils.hmacSha256Hex(paternerKey, str + "&key=" + paternerKey);
	}

	public static String decryptSign (String value, String key) {
		String decryptStr = null;
		try {
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] decodeBuffer = decoder.decodeBuffer(value);
			String md5Key = DigestUtils.md5Hex(key);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(md5Key.getBytes(), "AES"));
			decryptStr = new String(cipher.doFinal(decodeBuffer));
		} catch (NoSuchAlgorithmException e) {
			logger.error(" decryptSign NoSuchAlgorithmException msg : {} ", e.getMessage(), e);
		} catch (BadPaddingException e) {
			logger.error(" decryptSign NoSuchAlgorithmException msg : {} ", e.getMessage(), e);
		} catch (InvalidKeyException e) {
			logger.error(" decryptSign InvalidKeyException msg : {} ", e.getMessage(), e);
		} catch (NoSuchPaddingException e) {
			logger.error(" decryptSign NoSuchPaddingException msg : {} ", e.getMessage(), e);
		} catch (IOException e) {
			logger.error(" decryptSign IOException msg : {} ", e.getMessage(), e);
		} catch (NoSuchProviderException e) {
			logger.error(" decryptSign NoSuchProviderException msg : {} ", e.getMessage(), e);
		} catch (IllegalBlockSizeException e) {
			logger.error(" decryptSign IllegalBlockSizeException msg : {} ", e.getMessage(), e);
		} catch (Exception e) {
			logger.error(" decryptSign Exception msg : {} ", e.getMessage(), e);
		}
		return decryptStr;
	}

	/**
	 * 生成 HMACSHA256
	 * @param data 待处理数据
	 * @param key 密钥
	 * @return 加密结果
	 * @throws Exception
	 */
	public static String HMACSHA256(String data, String key) throws Exception {
		Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
		SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
		sha256_HMAC.init(secret_key);
		byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (byte item : array) {
			sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString().toUpperCase();
	}

	/**
	 * 生成 paySign
	 * @param map map
	 * @param paySignKey paySignKey
	 * @return pay sign
	 */
	public static String generatePaySign(Map<String, String> map, String paySignKey) {
		if (paySignKey != null) {
			map.put("appkey", paySignKey);
		}
		Map<String, String> tmap = MapUtil.order(map);
		String str = MapUtil.mapJoin(tmap);
		return DigestUtils.sha1Hex(str);
	}

	/**
	 * 生成事件消息接收签名
	 * @param token token
	 * @param timestamp timestamp
	 * @param nonce nonce
	 * @return str
	 */
	public static String generateEventMessageSignature(String token, String timestamp, String nonce) {
		String[] array = new String[] { token, timestamp, nonce };
		Arrays.sort(array);
		String s = StringUtils.arrayToDelimitedString(array, "");
		return DigestUtils.sha1Hex(s);
	}

	/**
	 * 验证 pay feedback appSignature 签名
	 * @param payFeedback payFeedback
	 * @param paySignKey 公众号支付请求中用于加密的密钥Key, 可验证商户唯一身份,对应于支付场景中的 appKey 值
	 * @return boolean
	 */
	public static boolean validateAppSignature(PayFeedback payFeedback, String paySignKey) {
		Map<String, String> map = MapUtil.objectToMap(payFeedback,
				"msgtype",
				"appsignature",
				"signmethod",
				"feedbackid",
				"transid",
				"reason",
				"solution",
				"extinfo",
				"picInfo");
		return payFeedback.getAppsignature().equals(generatePaySign(map, paySignKey));
	}

	/**
	 * 验证 pay native appSignature 签名
	 * @param payNativeInput payNativeInput
	 * @param paySignKey 公众号支付请求中用于加密的密钥Key, 可验证商户唯一身份,对应于支付场景中的 appKey 值
	 * @return boolean
	 */
	public static boolean validateAppSignature(PayNativeInput payNativeInput, String paySignKey) {
		Map<String, String> map = MapUtil.objectToMap(payNativeInput, "appsignature", "signmethod");
		return payNativeInput.getAppsignature().equals(generatePaySign(map, paySignKey));
	}

	/**
	 * 验证 pay notify appSignature 签名
	 * @param payNotify payNotify
	 * @param paySignKey 公众号支付请求中用于加密的密钥Key, 可验证商户唯一身份,对应于支付场景中的 appKey 值
	 * @return boolean
	 */
	public static boolean validateAppSignature(PayNotify payNotify, String paySignKey) {
		Map<String, String> map = MapUtil.objectToMap(payNotify, "appsignature", "signmethod");
		return payNotify.getAppsignature().equals(generatePaySign(map, paySignKey));
	}

	/**
	 * 验证 pay warn appSignature 签名
	 * @param payWarn payWarn
	 * @param paySignKey 公众号支付请求中用于加密的密钥Key, 可验证商户唯一身份,对应于支付场景中的 appKey 值
	 * @return boolean
	 */
	public static boolean validateAppSignature(PayWarn payWarn, String paySignKey) {
		Map<String, String> map = MapUtil.objectToMap(payWarn, "appsignature", "signmethod");
		return payWarn.getAppsignature().equals(generatePaySign(map, paySignKey));
	}

	/**
	 * mch 支付、代扣异步通知签名验证， 该方法可以替代 mch 支付、代扣异步通知验证，用以防止官方返回参数与bean不一至而导致签名错误。
	 * @param map 参与签名的参数
	 * @param key mch key
	 * @return boolean
	 */
	public static boolean validateSign(Map<String, String> map, String key) {
		return map.get("sign").equals(generateSign(map, key));
	}

}
