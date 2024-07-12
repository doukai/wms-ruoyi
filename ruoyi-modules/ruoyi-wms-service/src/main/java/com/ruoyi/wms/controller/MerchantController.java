package com.ruoyi.wms.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import com.ruoyi.common.idempotent.annotation.RepeatSubmit;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.web.core.BaseController;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.excel.utils.ExcelUtil;
import com.ruoyi.wms.domain.vo.MerchantVo;
import com.ruoyi.wms.domain.bo.MerchantBo;
import com.ruoyi.wms.service.MerchantService;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;

/**
 * 往来单位
 *
 * @author zcc
 * @date 2024-07-05
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/wms/merchant")
public class MerchantController extends BaseController {

    private final MerchantService merchantService;

    /**
     * 查询往来单位列表
     */
    @SaCheckPermission("wms:merchant:list")
    @GetMapping("/list")
    public TableDataInfo<MerchantVo> list(MerchantBo bo, PageQuery pageQuery) {
        return merchantService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出往来单位列表
     */
    @SaCheckPermission("wms:merchant:export")
    @Log(title = "往来单位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MerchantBo bo, HttpServletResponse response) {
        List<MerchantVo> list = merchantService.queryList(bo);
        ExcelUtil.exportExcel(list, "往来单位", MerchantVo.class, response);
    }

    /**
     * 获取往来单位详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("wms:merchant:query")
    @GetMapping("/{id}")
    public R<MerchantVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(merchantService.queryById(id));
    }

    /**
     * 新增往来单位
     */
    @SaCheckPermission("wms:merchant:add")
    @Log(title = "往来单位", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MerchantBo bo) {
        return toAjax(merchantService.insertByBo(bo));
    }

    /**
     * 修改往来单位
     */
    @SaCheckPermission("wms:merchant:edit")
    @Log(title = "往来单位", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MerchantBo bo) {
        return toAjax(merchantService.updateByBo(bo));
    }

    /**
     * 删除往来单位
     *
     * @param ids 主键串
     */
    @SaCheckPermission("wms:merchant:remove")
    @Log(title = "往来单位", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(merchantService.deleteWithValidByIds(List.of(ids)));
    }
}