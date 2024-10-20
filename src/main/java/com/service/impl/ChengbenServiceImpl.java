package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.ChengbenDao;
import com.entity.ChengbenEntity;
import com.service.ChengbenService;
import com.entity.view.ChengbenView;

/**
 * 维修成本 服务实现类
 */
@Service("chengbenService")
@Transactional
public class ChengbenServiceImpl extends ServiceImpl<ChengbenDao, ChengbenEntity> implements ChengbenService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<ChengbenView> page =new Query<ChengbenView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
