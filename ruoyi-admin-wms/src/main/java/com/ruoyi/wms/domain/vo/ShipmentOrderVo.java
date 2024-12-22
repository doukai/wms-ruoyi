package com.ruoyi.wms.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.mybatis.core.domain.BaseVo;
import com.ruoyi.wms.domain.entity.ShipmentOrder;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 出库单视图对象 wms_shipment_order
 *
 * @author zcc
 * @date 2024-08-01
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = ShipmentOrder.class)
public class ShipmentOrderVo extends BaseVo{

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * 出库单号，系统自动生成
     */
    @ExcelProperty(value = "出库单号，系统自动生成")
    private String shipmentOrderNo;

    /**
     * 出库类型
     */
    @ExcelProperty(value = "出库类型")
    private Long shipmentOrderType;

    /**
     * 出库订单
     */
    @ExcelProperty(value = "出库订单")
    private String orderNo;

    /**
     * 客户
     */
    @ExcelProperty(value = "客户")
    private Long merchantId;

    /**
     * 订单金额
     */
    @ExcelProperty(value = "订单金额")
    private BigDecimal receivableAmount;

    /**
     * 出库数量
     */
    @ExcelProperty(value = "出库数量")
    private BigDecimal totalQuantity;

    /**
     * 出库单状态
     */
    @ExcelProperty(value = "出库单状态")
    private Integer shipmentOrderStatus;

    /**
     * 仓库id
     */
    @ExcelProperty(value = "仓库id")
    private Long warehouseId;

    /**
     * 库区id
     */
    @ExcelProperty(value = "库区id")
    private Long areaId;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;

    List<ShipmentOrderDetailVo> details;

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
