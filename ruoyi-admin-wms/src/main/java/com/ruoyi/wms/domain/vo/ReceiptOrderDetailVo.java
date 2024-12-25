package com.ruoyi.wms.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import com.ruoyi.wms.domain.entity.ReceiptOrderDetail;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 入库单详情视图对象 wms_receipt_order_detail
 *
 * @author zcc
 * @date 2024-07-19
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = ReceiptOrderDetail.class)
public class ReceiptOrderDetailVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ExcelIgnore
    private Long id;

    /**
     * 入库单号
     */
    @ExcelIgnore
    private Long receiptOrderId;

    /**
     * 规格id
     */
    @ExcelIgnore
    private Long skuId;

    /**
     * 入库数量
     */
    @ExcelProperty(value = "入库数量", index = 4)
    private BigDecimal quantity;

    /**
     * 金额
     */
    @ExcelIgnore
    private BigDecimal amount;

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
     * 备注
     */
    @ExcelProperty(value = "备注", index = 7)
    private String remark;

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
    @ExcelProperty(value = "仓库", index = 2)
    private String warehouse;

    /**
     * 所属库区
     */
    @ExcelProperty(value = "库区", index = 3)
    private String area;

    private ItemSkuVo itemSku;

    /**
     * 毛重(kg)
     */
    @ExcelProperty(value = "毛重(kg)", index = 5)
    private BigDecimal grossWeight;

    /**
     * 净重(kg)
     */
    @ExcelProperty(value = "净重(kg)", index = 6)
    private BigDecimal netWeight;


    /**
     * 时间
     */
    @ExcelProperty(value = "入库时间", index = 1)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;

    /**
     * 入库单号
     */
    @ExcelProperty(value = "入库单号", index = 0)
    private String receiptOrderNo;
}
