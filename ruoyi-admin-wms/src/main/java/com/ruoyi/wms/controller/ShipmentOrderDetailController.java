package com.ruoyi.wms.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.excel.utils.ExcelUtil;
import com.ruoyi.common.idempotent.annotation.RepeatSubmit;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;
import com.ruoyi.common.web.core.BaseController;
import com.ruoyi.wms.domain.bo.ShipmentOrderDetailBo;
import com.ruoyi.wms.domain.entity.Area;
import com.ruoyi.wms.domain.entity.Warehouse;
import com.ruoyi.wms.domain.vo.ShipmentOrderDetailVo;
import com.ruoyi.wms.service.AreaService;
import com.ruoyi.wms.service.ShipmentOrderDetailService;
import com.ruoyi.wms.service.WarehouseService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * 出库单详情
 *
 * @author zcc
 * @date 2024-08-01
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/wms/shipmentOrderDetail")
public class ShipmentOrderDetailController extends BaseController {

    private final ShipmentOrderDetailService shipmentOrderDetailService;

    private final WarehouseService warehouseService;

    private final AreaService areaService;

    /**
     * 查询出库单详情列表
     */
    @SaCheckPermission("wms:shipment:all")
    @GetMapping("/list")
    public TableDataInfo<ShipmentOrderDetailVo> list(ShipmentOrderDetailBo bo, PageQuery pageQuery) {
        return shipmentOrderDetailService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出出库单详情列表
     */
    @SaCheckPermission("wms:shipment:all")
    @Log(title = "出库单详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(ShipmentOrderDetailBo bo, HttpServletResponse response) {
        List<ShipmentOrderDetailVo> shipmentOrderDetailVos = shipmentOrderDetailService.queryList(bo);

        List<Long> warehouseIdList = shipmentOrderDetailVos.stream()
            .map(ShipmentOrderDetailVo::getWarehouseId)
            .filter(Objects::nonNull)
            .toList();
        List<Warehouse> warehouseList = warehouseService.listByIds(warehouseIdList);
        shipmentOrderDetailVos.stream()
            .filter(receiptOrderDetailVo -> receiptOrderDetailVo.getWarehouseId() != null)
            .forEach(receiptOrderDetailVo ->
                warehouseList.stream()
                    .filter(warehouse -> warehouse.getId().equals(receiptOrderDetailVo.getWarehouseId()))
                    .findFirst()
                    .ifPresent(warehouse -> receiptOrderDetailVo.setWarehouse(warehouse.getWarehouseName()))
            );

        List<Long> areaIdList = shipmentOrderDetailVos.stream()
            .map(ShipmentOrderDetailVo::getAreaId)
            .filter(Objects::nonNull)
            .toList();
        List<Area> areaList = areaService.listByIds(areaIdList);
        shipmentOrderDetailVos.stream()
            .filter(receiptOrderDetailVo -> receiptOrderDetailVo.getAreaId() != null)
            .forEach(receiptOrderDetailVo ->
                areaList.stream()
                    .filter(area -> area.getId().equals(receiptOrderDetailVo.getAreaId()))
                    .findFirst()
                    .ifPresent(area -> receiptOrderDetailVo.setArea(area.getAreaName()))
            );
        ExcelUtil.exportExcel(shipmentOrderDetailVos, "出库单详情", ShipmentOrderDetailVo.class, response);
    }

    /**
     * 获取出库单详情详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("wms:shipment:all")
    @GetMapping("/{id}")
    public R<ShipmentOrderDetailVo> getInfo(@NotNull(message = "主键不能为空")
                                            @PathVariable Long id) {
        return R.ok(shipmentOrderDetailService.queryById(id));
    }

    /**
     * 新增出库单详情
     */
    @SaCheckPermission("wms:shipment:all")
    @Log(title = "出库单详情", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody ShipmentOrderDetailBo bo) {
        shipmentOrderDetailService.insertByBo(bo);
        return R.ok();
    }

    /**
     * 修改出库单详情
     */
    @SaCheckPermission("wms:shipment:all")
    @Log(title = "出库单详情", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody ShipmentOrderDetailBo bo) {
        shipmentOrderDetailService.updateByBo(bo);
        return R.ok();
    }

    /**
     * 删除出库单详情
     *
     * @param ids 主键串
     */
    @SaCheckPermission("wms:shipment:all")
    @Log(title = "出库单详情", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        shipmentOrderDetailService.deleteByIds(List.of(ids));
        return R.ok();
    }

    /**
     * 获取出库单详情详细信息
     */
    @SaCheckPermission("wms:shipment:all")
    @GetMapping("/list/{shipmentOrderId}")
    public R<List<ShipmentOrderDetailVo>> listByShipmentOrderId(@NotNull @PathVariable Long shipmentOrderId) {
        return R.ok(shipmentOrderDetailService.queryByShipmentOrderId(shipmentOrderId));
    }
}
