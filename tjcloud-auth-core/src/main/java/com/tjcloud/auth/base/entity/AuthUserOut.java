package com.tjcloud.auth.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 外部认证用户(auth_user_out)
 * @author auto bin.yin 2016.07.05
 */
public class AuthUserOut extends AbstractEntity {
	private static final long serialVersionUID = 1467684424832L;

	private String type;         //外部渠道类型(1.阿里，2.微信)
	private String authId;       //认证ID
	private String authAppId;    //认证应用ID
	private String unionid;      //用户unionid
	private String userid;       //用户openid
	private String username;     //用户名
	private String nickname;     //用户昵称
	private String avatar;       //用户头像
	private String accessToken;  //令牌
	private Long expires;        //到期时长
	private Long expiresTime;    //到期时间
	private String refreshToken; //刷新令牌
	private Long rexpires;       //刷新信息到期时长
	private Long rexpiresTime;   //刷新令牌到期时间

	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	public String getAuthAppId() {
		return authAppId;
	}
	public void setAuthAppId(String authAppId) {
		this.authAppId = authAppId;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getUserid() {
		return this.userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return this.nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAvatar() {
		return this.avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getAccessToken() {
		return this.accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public Long getExpires() {
		return this.expires;
	}
	public void setExpires(Long expires) {
		this.expires = expires;
	}
	public Long getExpiresTime() {
		return this.expiresTime;
	}
	public void setExpiresTime(Long expiresTime) {
		this.expiresTime = expiresTime;
	}
	public String getRefreshToken() {
		return this.refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public Long getRexpires() {
		return this.rexpires;
	}
	public void setRexpires(Long rexpires) {
		this.rexpires = rexpires;
	}
	public Long getRexpiresTime() {
		return this.rexpiresTime;
	}
	public void setRexpiresTime(Long rexpiresTime) {
		this.rexpiresTime = rexpiresTime;
	}
}