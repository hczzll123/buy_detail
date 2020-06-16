package com.hcz.buy_detail.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hechangzheng
 * @since 2020-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Buydetails对象", description="")
public class Buydetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "终端号")
    private Integer endId;

    @ApiModelProperty(value = "发卡行")
    private String bankAdress;

    @ApiModelProperty(value = "卡种")
    private String cartType;

    @ApiModelProperty(value = "卡号")
    private String cartAcct;

    @ApiModelProperty(value = "交易日期")
    private String tradeDay;

    @ApiModelProperty(value = "交易时间")
    private String tradeTime;

    @ApiModelProperty(value = "交易类型")
    private String payType;

    @ApiModelProperty(value = "授权号")
    private String authAcct;

    @ApiModelProperty(value = "交易金额")
    private BigDecimal payAcct;

    @ApiModelProperty(value = "小费")
    private BigDecimal smallMoney;

    @ApiModelProperty(value = "分期期数")
    private String stage;

    @ApiModelProperty(value = "银行手续费")
    private BigDecimal handleMoney;

    @ApiModelProperty(value = "DCC返还手续费")
    private BigDecimal dccBackmoney;

    @ApiModelProperty(value = "划账金额")
    private BigDecimal paymentMoney;

    @ApiModelProperty(value = "凭证号")
    private String tradeNum;

    @ApiModelProperty(value = "批次号")
    private String batchNum;

    @ApiModelProperty(value = "pos交易序号")
    private String posAcct;

    @ApiModelProperty(value = "结算账号")
    private String saleAcct;

    @ApiModelProperty(value = "订单号")
    private String orderAcct;

    @ApiModelProperty(value = "柜台号")
    private String barAcct;

    @ApiModelProperty(value = "系统参考号")
    private String systemAcct;

    @ApiModelProperty(value = "持卡人姓名")
    private String cartName;

    @ApiModelProperty(value = "付款凭证号")
    private String payTradenum;

    @ApiModelProperty(value = "备注1")
    private String remarkNum1;

    @ApiModelProperty(value = "备注2")
    private String remarkNum2;


}
