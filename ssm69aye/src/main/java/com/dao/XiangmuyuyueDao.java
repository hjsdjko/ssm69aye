package com.dao;

import com.entity.XiangmuyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiangmuyuyueVO;
import com.entity.view.XiangmuyuyueView;


/**
 * 项目预约
 * 
 * @author 
 * @email 
 * @date 2022-02-27 17:35:06
 */
public interface XiangmuyuyueDao extends BaseMapper<XiangmuyuyueEntity> {
	
	List<XiangmuyuyueVO> selectListVO(@Param("ew") Wrapper<XiangmuyuyueEntity> wrapper);
	
	XiangmuyuyueVO selectVO(@Param("ew") Wrapper<XiangmuyuyueEntity> wrapper);
	
	List<XiangmuyuyueView> selectListView(@Param("ew") Wrapper<XiangmuyuyueEntity> wrapper);

	List<XiangmuyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<XiangmuyuyueEntity> wrapper);
	
	XiangmuyuyueView selectView(@Param("ew") Wrapper<XiangmuyuyueEntity> wrapper);
	

}
