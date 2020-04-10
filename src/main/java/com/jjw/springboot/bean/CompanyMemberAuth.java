package com.jjw.springboot.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@TableName ( "company_member_auth" )
public class CompanyMemberAuth  implements Serializable {

	private static final long serialVersionUID =  2488219161676901227L;

   	@ApiModelProperty(name = "id" )
	private Long id;

	/**
	 * 会员ID
	 */
   	@ApiModelProperty(name = "mid" )
	private Long mid;

	/**
	 * 登录用户名
	 */
   	@ApiModelProperty(name = "username" )
	private String username;

	/**
	 * 密码
	 */
   	@ApiModelProperty(name = "password" )
	private String password;

	/**
	 * 盐
	 */
   	@ApiModelProperty(name = "salt" )
	private String salt;

	/**
	 * 微信openid
	 */
   	@ApiModelProperty(name = "wx_openid" )
	private String wxOpenid;

	/**
	 * 微信开放平台unionid
	 */
   	@ApiModelProperty(name = "wx_unionid" )
	private String wxUnionid;

	/**
	 * 0禁用，1启用
	 */
   	@ApiModelProperty(name = "status" )
	private Integer status;

}
