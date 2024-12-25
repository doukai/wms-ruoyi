package com.ruoyi.wms.domain.vo;

import java.math.BigDecimal;

import com.alibaba.excel.annotation.ExcelIgnore;
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
    @ExcelIgnore
    private Long id;

    /**
     * 出库单
     */
    @ExcelIgnore
    private Long shipmentOrderId;

    /**
     * 规格id
     */
    @ExcelIgnore
    private Long skuId;

    /**
     * 数量
     */
    @ExcelProperty(value = "数量", index = 5)
    private BigDecimal quantity;

    /**
     * 金额
     */
    @ExcelIgnore
    private BigDecimal amount;

    /**
     * 所属仓库
     */
    @ExcelIgnore
    private Long warehouseId;

    /**
     * 所属库区
     */
    @ExcelIgnore
    private Long areaId;

    /**
     * 所属仓库
     */
    @ExcelProperty(value = "仓库", index = 3)
    private String warehouse;

    /**
     * 所属库区
     */
    @ExcelProperty(value = "库区", index = 4)
    private String area;

    /**
     * 批号
     */
    @ExcelIgnore
    private String batchNo;

    /**
     * 生产日期
     */
    @ExcelIgnore
    private LocalDateTime productionDate;

    /**
     * 过期时间
     */
    @ExcelIgnore
    private LocalDateTime expirationDate;

    /**
     * 入库记录id
     */
    @ExcelIgnore
    private Long inventoryDetailId;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注", index = 12)
    private String remark;

    private ItemSkuVo itemSku;

    private BigDecimal remainQuantity;

    /**
     * 毛重(kg)
     */
    @ExcelProperty(value = "毛重(kg)", index = 6)
    private BigDecimal grossWeight;

    /**
     * 净重(kg)
     */
    @ExcelProperty(value = "净重(kg)", index = 7)
    private BigDecimal netWeight;


    /**
     * 时间
     */
    @ExcelProperty(value = "入库时间", index = 2)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;

    /**
     * 装卸费
     */
    @ExcelProperty(value = "装卸费", index = 8)
    private BigDecimal loadingFee;
    /**
     * 操作费
     */
    @ExcelProperty(value = "操作费", index = 9)
    private BigDecimal operationFee;
    /**
     * 仓储费
     */
    @ExcelProperty(value = "仓储费", index = 10)
    private BigDecimal storageFee;
    /**
     * 合计金额
     */
    @ExcelProperty(value = "合计金额", index = 11)
    private BigDecimal totalFee;
    /**
     * 入库单号
     */
    @ExcelProperty(value = "入库单号", index = 1)
    private String receiptOrderNo;

    @ExcelProperty(value = "出库单号", index = 0)
    private String shipmentOrderNo;
}
