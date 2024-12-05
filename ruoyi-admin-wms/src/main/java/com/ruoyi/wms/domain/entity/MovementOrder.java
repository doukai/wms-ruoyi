package com.ruoyi.wms.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;

import java.math.BigDecimal;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 移库单对象 wms_movement_order
 *
 * @author zcc
 * @date 2024-08-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("wms_movement_order")
public class MovementOrder extends BaseEntity {

    @Serial
    private static final long serialVersionUID=1L;

    /**
     *
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 编号
     */
    private String movementOrderNo;
    /**
     * 源仓库
     */
    private Long sourceWarehouseId;
    /**
     * 源库区
     */
    private Long sourceAreaId;
    /**
     * 目标仓库
     */
    private Long targetWarehouseId;
    /**
     * 目标库区
     */
    private Long targetAreaId;
    /**
     * 状态
     */
    private Integer movementOrderStatus;
    /**
     * 总数量
     */
    private BigDecimal totalQuantity;
    /**
     * 备注
     */
    private String remark;

    /**
     * 时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;

    /**
     * 毛重(kg)
     */
    private BigDecimal totalGrossWeight;

    /**
     * 净重(kg)
     */
    private BigDecimal totalNetWeight;

}
