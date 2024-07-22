package com.ruoyi.wms.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.utils.MapstructUtils;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;
import com.ruoyi.wms.domain.bo.AreaBo;
import com.ruoyi.wms.domain.entity.Area;
import com.ruoyi.wms.domain.vo.AreaVo;
import com.ruoyi.wms.mapper.AreaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AreaService {

    private final AreaMapper areaMapper;

    /**
     * 查询库区
     */

    public AreaVo queryById(Long id) {
        return areaMapper.selectVoById(id);
    }

    /**
     * 查询库区列表
     */

    public TableDataInfo<AreaVo> queryPageList(AreaBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Area> lqw = buildQueryWrapper(bo);
        Page<AreaVo> result = areaMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询库区列表
     */

    public List<AreaVo> queryList(AreaBo bo) {
        LambdaQueryWrapper<Area> lqw = buildQueryWrapper(bo);
        return areaMapper.selectVoList(lqw);
    }

    /**
     * 获取该仓库下的库区数量
     *
     * @param id 仓库id
     */

    public Long countByWarehouseId(Long id) {
        LambdaQueryWrapper<Area> lqw = Wrappers.lambdaQuery();
        lqw.eq(Area::getWarehouseId, id);
        return areaMapper.selectCount(lqw);
    }

    private LambdaQueryWrapper<Area> buildQueryWrapper(AreaBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Area> lqw = Wrappers.lambdaQuery();
        lqw.eq(StrUtil.isNotBlank(bo.getAreaNo()), Area::getAreaNo, bo.getAreaNo());
        lqw.like(StrUtil.isNotBlank(bo.getAreaName()), Area::getAreaName, bo.getAreaName());
        lqw.eq(bo.getWarehouseId() != null, Area::getWarehouseId, bo.getWarehouseId());
        return lqw;
    }

    /**
     * 新增库区
     */

    public void insertByBo(AreaBo bo) {
        validateAreaNameAndNo(bo);
        Area add = MapstructUtils.convert(bo, Area.class);
        areaMapper.insert(add);
    }

    /**
     * 修改库区
     */

    public void updateByBo(AreaBo bo) {
        validateAreaNameAndNo(bo);
        Area update = MapstructUtils.convert(bo, Area.class);
        areaMapper.updateById(update);
    }

    private void validateAreaNameAndNo(AreaBo area) {
        LambdaQueryWrapper<Area> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Area::getWarehouseId, area.getWarehouseId());
        queryWrapper.eq(Area::getAreaName, area.getAreaName());
        queryWrapper.ne(area.getId() != null, Area::getId, area.getId());
        Assert.isTrue(areaMapper.selectCount(queryWrapper) == 0, "库区名称重复");
        if (StrUtil.isBlank(area.getAreaNo())) {
            return;
        }
        queryWrapper.clear();
        queryWrapper.eq(Area::getAreaNo, area.getAreaNo());
        queryWrapper.ne(area.getId() != null, Area::getId, area.getId());
        Assert.isTrue(areaMapper.selectCount(queryWrapper) == 0, "库区编号重复");
    }

    /**
     * 批量删除库区
     */

    public void deleteByIds(Collection<Long> ids) {
        areaMapper.deleteBatchIds(ids);
    }

    public List<AreaVo> queryByIdsIgnoreDelFlag(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return CollUtil.newArrayList();
        }
        return areaMapper.queryByIdsIgnoreDelFlag(ids);
    }
}
