package com.ruoyi.wms.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 出库单详情对象 wms_shipment_order_detail
 *
 * @author zcc
 * @date 2024-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("wms_shipment_order_detail")
public class ShipmentOrderDetail extends BaseEntity {

    @Serial
    private static final long serialVersionUID=1L;

    /**
     *
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 出库单
     */
    private Long shipmentOrderId;
    /**
     * 规格id
     */
    private Long skuId;
    /**
     * 数量
     */
    private BigDecimal quantity;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 所属仓库
     */
    private Long warehouseId;
    /**
     * 所属库区
     */
    private Long areaId;
    /**
     * 批号
     */
    private String batchNo;
    /**
     * 生产日期
     */
    private LocalDateTime productionDate;
    /**
     * 过期时间
     */
    private LocalDateTime expirationDate;
    /**
     * 入库记录id
     */
    private Long inventoryDetailId;
    /**
     * 备注
     */
    private String remark;

    /**
     * 毛重(kg)
     */
    private BigDecimal grossWeight;

    /**
     * 净重(kg)
     */
    private BigDecimal netWeight;


    /**
     * 时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;

    /**
     * 装卸费
     */
    private BigDecimal loadingFee;
    /**
     * 操作费
     */
    private BigDecimal operationFee;
    /**
     * 仓储费
     */
    private BigDecimal storageFee;
    /**
     * 合计金额
     */
    private BigDecimal totalFee;
    /**
     * 入库单号
     */
    private String receiptOrderNo;

    /**
     * 出库单号
     */
    private String shipmentOrderNo;

}
