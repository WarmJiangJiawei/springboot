package com.jjw.springboot.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName ( "company_member" )
public class CompanyMember  implements Serializable {

	private static final long serialVersionUID =  7761515076543338934L;

   	@ApiModelProperty(name = "id" )
	private Long id;

	/**
	 * 归属企业ID
	 */
   	@ApiModelProperty(name = "cid" )
	private Long cid;

	/**
	 * 推荐注册会员ID
	 */
   	@ApiModelProperty(name = "r_mid" )
	private Long rMid;

	/**
	 * 会员姓名
	 */
   	@ApiModelProperty(name = "name" )
	private String name;

	/**
	 * 备注名
	 */
   	@ApiModelProperty(name = "remark_name" )
	private String remarkName;

	/**
	 * 手机号
	 */
   	@ApiModelProperty(name = "mobile" )
	private String mobile;

	/**
	 * 微信号
	 */
   	@ApiModelProperty(name = "weixin" )
	private String weixin;

	/**
	 * 头像
	 */
   	@ApiModelProperty(name = "avatar" )
	private String avatar;

	/**
	 * 性别（1男，2女，0未知）
	 */
   	@ApiModelProperty(name = "sex" )
	private Integer sex;

	/**
	 * 昵称
	 */
   	@ApiModelProperty(name = "nickname" )
	private String nickname;

	/**
	 * 生日
	 */
   	@ApiModelProperty(name = "birthday" )
	private Date birthday;

	/**
	 * 省
	 */
   	@ApiModelProperty(name = "province" )
	private String province;

	/**
	 * 省ID
	 */
   	@ApiModelProperty(name = "province_id" )
	private Long provinceId;

	/**
	 * 市
	 */
   	@ApiModelProperty(name = "city" )
	private String city;

	/**
	 * 市ID
	 */
   	@ApiModelProperty(name = "city_id" )
	private Long cityId;

	/**
	 * 区
	 */
   	@ApiModelProperty(name = "area" )
	private String area;

	/**
	 * 区ID
	 */
   	@ApiModelProperty(name = "area_id" )
	private Long areaId;

	/**
	 * 详细地址
	 */
   	@ApiModelProperty(name = "address" )
	private String address;

	/**
	 * 余额（单位分）
	 */
   	@ApiModelProperty(name = "balance" )
	private Long balance;

	/**
	 * 银两/积分
	 */
   	@ApiModelProperty(name = "score" )
	private Long score;

	/**
	 * 佣金（分）
	 */
   	@ApiModelProperty(name = "commission" )
	private Long commission;

	/**
	 * 会员成长值
	 */
   	@ApiModelProperty(name = "level_value" )
	private Long levelValue;

	/**
	 * 销费次数
	 */
   	@ApiModelProperty(name = "consume_count" )
	private Long consumeCount;

	/**
	 * 销费总金额
	 */
   	@ApiModelProperty(name = "consume_money" )
	private Long consumeMoney;

	/**
	 * 最后销费时间
	 */
   	@ApiModelProperty(name = "consume_last_time" )
	private Long consumeLastTime;

	/**
	 * 6位邀请码
	 */
   	@ApiModelProperty(name = "invite_code" )
	private String inviteCode;

	/**
	 * 邀请开关
	 */
   	@ApiModelProperty(name = "invite_switch" )
	private Integer inviteSwitch;

	/**
	 * 邀请数量
	 */
   	@ApiModelProperty(name = "invite_number" )
	private Long inviteNumber;

	/**
	 * 来源ID
	 */
   	@ApiModelProperty(name = "source_id" )
	private Integer sourceId;

	/**
	 * 标签列表逗号分隔
	 */
   	@ApiModelProperty(name = "tag_id_lst" )
	private String tagIdLst;

	/**
	 * 最后登录时间
	 */
   	@ApiModelProperty(name = "lastlogin_at" )
	private Long lastloginAt;

	/**
	 * 备注
	 */
   	@ApiModelProperty(name = "remarks" )
	private String remarks;

	/**
	 * 1企业会员、2钻卡会员、3贵宾会员，4普通会员
	 */
   	@ApiModelProperty(name = "member_type" )
	private Integer memberType;

	/**
	 * 0禁用用，1启用
	 */
   	@ApiModelProperty(name = "status" )
	private Integer status;

	/**
	 * 注册时间
	 */
   	@ApiModelProperty(name = "create_at" )
	private Long createAt;

	/**
	 * 更新时间
	 */
   	@ApiModelProperty(name = "update_at" )
	private Long updateAt;

	/**
	 * UUID
	 */
   	@ApiModelProperty(name = "uuid" )
	private String uuid;

	/**
	 * 1删除，0未删除
	 */
   	@ApiModelProperty(name = "is_deleted" )
	private Integer isDeleted;

}
