package com.dao;

import com.entity.GuzhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GuzhangView;

/**
 * 故障上报 Dao 接口
 *
 * @author 
 */
public interface GuzhangDao extends BaseMapper<GuzhangEntity> {

   List<GuzhangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
