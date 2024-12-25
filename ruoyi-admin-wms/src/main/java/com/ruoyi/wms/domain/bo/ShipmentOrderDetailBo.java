package com.ruoyi.wms.domain.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.mybatis.core.domain.PlaceAndItem;
import com.ruoyi.wms.domain.entity.ShipmentOrderDetail;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import io.github.linpeilie.annotations.AutoMappers;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import io.github.linpeilie.annotations.AutoMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 出库单详情业务对象 wms_shipment_order_detail
 *
 * @author zcc
 * @date 2024-08-01
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AutoMappers({
    @AutoMapper(target = ShipmentOrderDetail.class, reverseConvertGenerate = false),
    @AutoMapper(target = InventoryBo.class, reverseConvertGenerate = false)
})
public class ShipmentOrderDetailBo extends BaseEntity implements PlaceAndItem {

    /**
     *
     */
    @NotNull(message = "不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 出库单
     */
    @NotNull(message = "出库单不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long shipmentOrderId;

    /**
     * 规格id
     */
    @NotNull(message = "规格id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long skuId;

    /**
     * 数量
     */
    @NotNull(message = "数量不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal quantity;

    /**
     * 金额
     */
    @NotNull(message = "金额不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal amount;

    /**
     * 所属仓库
     */
    @NotNull(message = "所属仓库不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long warehouseId;

    /**
     * 所属库区
     */
    @NotNull(message = "所属库区不能为空", groups = { AddGroup.class, EditGroup.class })
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
    @NotNull(message = "入库记录id不能为空", groups = { AddGroup.class, EditGroup.class })
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

    private LocalDateTime createStartTime;
    private LocalDateTime createEndTime;


}
