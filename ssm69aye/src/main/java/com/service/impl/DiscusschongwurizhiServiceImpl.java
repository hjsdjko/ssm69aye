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


import com.dao.DiscusschongwurizhiDao;
import com.entity.DiscusschongwurizhiEntity;
import com.service.DiscusschongwurizhiService;
import com.entity.vo.DiscusschongwurizhiVO;
import com.entity.view.DiscusschongwurizhiView;

@Service("discusschongwurizhiService")
public class DiscusschongwurizhiServiceImpl extends ServiceImpl<DiscusschongwurizhiDao, DiscusschongwurizhiEntity> implements DiscusschongwurizhiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusschongwurizhiEntity> page = this.selectPage(
                new Query<DiscusschongwurizhiEntity>(params).getPage(),
                new EntityWrapper<DiscusschongwurizhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusschongwurizhiEntity> wrapper) {
		  Page<DiscusschongwurizhiView> page =new Query<DiscusschongwurizhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusschongwurizhiVO> selectListVO(Wrapper<DiscusschongwurizhiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusschongwurizhiVO selectVO(Wrapper<DiscusschongwurizhiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusschongwurizhiView> selectListView(Wrapper<DiscusschongwurizhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusschongwurizhiView selectView(Wrapper<DiscusschongwurizhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
