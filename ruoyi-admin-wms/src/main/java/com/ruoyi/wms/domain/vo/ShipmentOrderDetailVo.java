package com.ruoyi.wms.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.wms.domain.entity.ShipmentOrderDetail;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 出库单详情视图对象 wms_shipment_order_detail
 *
 * @author zcc
 * @date 2024-08-01
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = ShipmentOrderDetail.class)
public class ShipmentOrderDetailVo implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * 出库单
     */
    @ExcelProperty(value = "出库单")
    private Long shipmentOrderId;

    /**
     * 规格id
     */
    @ExcelProperty(value = "规格id")
    private Long skuId;

    /**
     * 数量
     */
    @ExcelProperty(value = "数量")
    private BigDecimal quantity;

    /**
     * 金额
     */
    @ExcelProperty(value = "金额")
    private BigDecimal amount;

    /**
     * 所属仓库
     */
    @ExcelProperty(value = "所属仓库")
    private Long warehouseId;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;

    private ItemSkuVo itemSku;
}
