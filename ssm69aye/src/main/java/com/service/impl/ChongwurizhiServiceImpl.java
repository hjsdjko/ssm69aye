package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ChongwurizhiDao;
import com.entity.ChongwurizhiEntity;
import com.service.ChongwurizhiService;
import com.entity.vo.ChongwurizhiVO;
import com.entity.view.ChongwurizhiView;

@Service("chongwurizhiService")
public class ChongwurizhiServiceImpl extends ServiceImpl<ChongwurizhiDao, ChongwurizhiEntity> implements ChongwurizhiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChongwurizhiEntity> page = this.selectPage(
                new Query<ChongwurizhiEntity>(params).getPage(),
                new EntityWrapper<ChongwurizhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChongwurizhiEntity> wrapper) {
		  Page<ChongwurizhiView> page =new Query<ChongwurizhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChongwurizhiVO> selectListVO(Wrapper<ChongwurizhiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChongwurizhiVO selectVO(Wrapper<ChongwurizhiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChongwurizhiView> selectListView(Wrapper<ChongwurizhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChongwurizhiView selectView(Wrapper<ChongwurizhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
