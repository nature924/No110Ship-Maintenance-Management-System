package com.dao;

import com.entity.ChaunboEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChaunboView;

/**
 * 船舶 Dao 接口
 *
 * @author 
 */
public interface ChaunboDao extends BaseMapper<ChaunboEntity> {

   List<ChaunboView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
