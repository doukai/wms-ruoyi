package com.ruoyi.wms.domain.vo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.mybatis.core.domain.PlaceAndItem;
import com.ruoyi.wms.domain.entity.ShipmentOrderDetail;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import io.github.linpeilie.annotations.AutoMapper;

import java.io.Serializable;
import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 出库单详情视图对象 wms_shipment_order_detail
 *
 * @author zcc
 * @date 2024-08-01
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = ShipmentOrderDetail.class)
public class ShipmentOrderDetailVo implements Serializable, PlaceAndItem {

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
     * 所属库区
     */
    @ExcelProperty(value = "所属库区")
    private Long areaId;

    /**
     * 批号
     */
    @ExcelProperty(value = "批号")
    private String batchNo;

    /**
     * 生产日期
     */
    @ExcelProperty(value = "生产日期")
    private LocalDateTime productionDate;

    /**
     * 过期时间
     */
    @ExcelProperty(value = "过期时间")
    private LocalDateTime expirationDate;

    /**
     * 入库记录id
     */
    @ExcelProperty(value = "入库记录id")
    private Long inventoryDetailId;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;

    private ItemSkuVo itemSku;

    private BigDecimal remainQuantity;

    /**
     * 毛重(kg)
     */
    @ExcelProperty(value = "毛重(kg)")
    private BigDecimal grossWeight;

    /**
     * 净重(kg)
     */
    @ExcelProperty(value = "净重(kg)")
    private BigDecimal netWeight;


    /**
     * 时间
     */
    @ExcelProperty(value = "入库时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;

    /**
     * 装卸费
     */
    @ExcelProperty(value = "装卸费")
    private BigDecimal loadingFee;
    /**
     * 操作费
     */
    @ExcelProperty(value = "操作费")
    private BigDecimal operationFee;
    /**
     * 仓储费
     */
    @ExcelProperty(value = "仓储费")
    private BigDecimal storageFee;
    /**
     * 合计金额
     */
    @ExcelProperty(value = "合计金额")
    private BigDecimal totalFee;
    /**
     * 入库单号
     */
    @ExcelProperty(value = "入库单号")
    private String receiptOrderNo;
}
