package com.dao;

import com.entity.ChuanjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuanjiaView;

/**
 * 船家 Dao 接口
 *
 * @author 
 */
public interface ChuanjiaDao extends BaseMapper<ChuanjiaEntity> {

   List<ChuanjiaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
