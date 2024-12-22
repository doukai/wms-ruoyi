package com.ruoyi.wms.domain.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.wms.domain.entity.ShipmentOrder;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import io.github.linpeilie.annotations.AutoMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 出库单业务对象 wms_shipment_order
 *
 * @author zcc
 * @date 2024-08-01
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = ShipmentOrder.class, reverseConvertGenerate = false)
public class ShipmentOrderBo extends BaseEntity {

    /**
     *
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 出库单号，系统自动生成
     */
    @NotBlank(message = "出库单号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String shipmentOrderNo;

    /**
     * 出库类型
     */
    @NotNull(message = "出库类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long shipmentOrderType;

    /**
     * 出库订单
     */
    private String orderNo;

    /**
     * 客户
     */
    private Long merchantId;

    /**
     * 订单金额
     */
    private BigDecimal receivableAmount;

    /**
     * 出库数量
     */
    private BigDecimal totalQuantity;

    /**
     * 出库单状态
     */
    private Integer shipmentOrderStatus;

    /**
     * 仓库id
     */
    private Long warehouseId;

    /**
     * 库区id
     */
    private Long areaId;

    /**
     * 备注
     */
    private String remark;

    private List<ShipmentOrderDetailBo> details;

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
}
