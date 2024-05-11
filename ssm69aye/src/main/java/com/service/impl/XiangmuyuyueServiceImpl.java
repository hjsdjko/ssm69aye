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


import com.dao.XiangmuyuyueDao;
import com.entity.XiangmuyuyueEntity;
import com.service.XiangmuyuyueService;
import com.entity.vo.XiangmuyuyueVO;
import com.entity.view.XiangmuyuyueView;

@Service("xiangmuyuyueService")
public class XiangmuyuyueServiceImpl extends ServiceImpl<XiangmuyuyueDao, XiangmuyuyueEntity> implements XiangmuyuyueService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiangmuyuyueEntity> page = this.selectPage(
                new Query<XiangmuyuyueEntity>(params).getPage(),
                new EntityWrapper<XiangmuyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiangmuyuyueEntity> wrapper) {
		  Page<XiangmuyuyueView> page =new Query<XiangmuyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiangmuyuyueVO> selectListVO(Wrapper<XiangmuyuyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiangmuyuyueVO selectVO(Wrapper<XiangmuyuyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiangmuyuyueView> selectListView(Wrapper<XiangmuyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiangmuyuyueView selectView(Wrapper<XiangmuyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
