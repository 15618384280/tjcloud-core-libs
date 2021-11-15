package com.tjcloud.auth.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.StringUtils;

import java.util.List;

/**
 * OAuth 2.0 认证用户(auth_user)
 * @author auto bin.yin 2016.07.05
 */
@LogRequired
public class AuthUser extends AbstractEntity {
	private static final long serialVersionUID = 1467684424789L;

	private String tenantId;        //租户ID
	private String avatar;          //头像
	private String nickname;        //昵称
	private String username;        //用户名
	private String password;        //密码
	private String salt;            //盐值
	private String shasalt;         //盐值
	private String shapwd;          //密码
	private String code;            //授权码
	private String accessToken;     //令牌
	private Boolean accessExpired;  //令牌是否已到期
	private Long expires;           //到期时长
	private Long expiresTime;       //到期时间
	private String refreshToken;    //刷新令牌
	private Boolean refreshExpired; //刷新令牌是否已到期
	private Long rexpires;          //刷新令牌到期时长
	private Long rexpiresTime;      //刷新令牌到期时间
	private String gender;          //性别
	private String email;           //邮箱
	private String mobile;          //手机号码
	private String source;          //用户来源
	private String type;            //用户类型
	private Integer visits;         //访问次数
	private Integer fails;          //失败次数
	private String ip;              //访问IP
	private String lastip;          //上次访问IP
	private String userId;          //用户ID
	private String note;            //备注
	private String platformUserId;  //平台用户ID
	private String platformUserPwd;//平台用户密码
	private String alipayUserId;    //支付宝用户ID
	private String tenpayOpenId;    //微信用户ID
	private String miniOpenId;		//学校开放小程序id
	private String ydhfMiniOpenId;		//运动合肥小程序OPENID
	private Long lockedTime;        //锁定时间
	private String lockedReason;    //锁定原因

	private String mobileBind;
	private List<AuthUserOut> userTokenList;

	public AuthUser() {}
	public AuthUser(String username) {
		this.username = username;
	}
	public void addCreatedBy(String creatorId, String  createdBy){
		this.setCreatorId(creatorId);
		this.setCreatedBy(createdBy);
	}
	public String getMiniOpenId() {
		return miniOpenId;
	}
	public void setMiniOpenId(String miniOpenId) {
		this.miniOpenId = miniOpenId;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getShasalt() {
		return shasalt;
	}
	public void setShasalt(String shasalt) {
		this.shasalt = shasalt;
	}
	public String getShapwd() {
		return shapwd;
	}
	public void setShapwd(String shapwd) {
		this.shapwd = shapwd;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public Boolean getAccessExpired() {
		return accessExpired;
	}
	public void setAccessExpired(Boolean accessExpired) {
		this.accessExpired = accessExpired;
	}
	public Long getExpires() {
		return expires;
	}
	public void setExpires(long expires) {
		this.expires = expires;
	}
	public Long getExpiresTime() {
		return expiresTime;
	}
	public void setExpiresTime(long expiresTime) {
		this.expiresTime = expiresTime;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public Boolean getRefreshExpired() {
		return refreshExpired;
	}
	public void setRefreshExpired(Boolean refreshExpired) {
		this.refreshExpired = refreshExpired;
	}
	public Long getRexpires() {
		return rexpires;
	}
	public void setRexpires(long rexpires) {
		this.rexpires = rexpires;
	}
	public Long getRexpiresTime() {
		return rexpiresTime;
	}
	public void setRexpiresTime(long rexpiresTime) {
		this.rexpiresTime = rexpiresTime;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getVisits() {
		return visits;
	}
	public void setVisits(Integer visits) {
		this.visits = visits;
	}
	public Integer getFails() {
		return fails;
	}
	public void setFails(Integer fails) {
		this.fails = fails;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getLastip() {
		return lastip;
	}
	public void setLastip(String lastip) {
		this.lastip = lastip;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getPlatformUserId() {
		return platformUserId;
	}
	public void setPlatformUserId(String platformUserId) {
		this.platformUserId = platformUserId;
	}
	public String getPlatformUserPwd() {
		return platformUserPwd;
	}
	public void setPlatformUserPwd(String platformUserPwd) {
		this.platformUserPwd = platformUserPwd;
	}
	public String getAlipayUserId() {
		return alipayUserId;
	}
	public void setAlipayUserId(String alipayUserId) {
		this.alipayUserId = alipayUserId;
	}
	public String getTenpayOpenId() {
		return tenpayOpenId;
	}
	public void setTenpayOpenId(String tenpayOpenId) {
		this.tenpayOpenId = tenpayOpenId;
	}
	public Long getLockedTime() {
		return lockedTime;
	}
	public void setLockedTime(Long lockedTime) {
		this.lockedTime = lockedTime;
	}
	public String getLockedReason() {
		return lockedReason;
	}
	public void setLockedReason(String lockedReason) {
		this.lockedReason = lockedReason;
	}
	public String getMobileBind() {
		return mobileBind;
	}
	public void setMobileBind(String mobileBind) {
		this.mobileBind = mobileBind;
	}
	public List<AuthUserOut> getUserTokenList() {
		return userTokenList;
	}
	public void setUserTokenList(List<AuthUserOut> userTokenList) {
		this.userTokenList = userTokenList;
	}
	public String getCredentialsSalt() {
        return StringUtils.msNull(this.username) + StringUtils.msNull(this.salt);
    }
	public String getYdhfMiniOpenId() {
		return ydhfMiniOpenId;
	}
	public void setYdhfMiniOpenId(String ydhfMiniOpenId) {
		this.ydhfMiniOpenId = ydhfMiniOpenId;
	}
	
}