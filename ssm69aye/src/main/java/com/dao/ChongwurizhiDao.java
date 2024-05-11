package com.dao;

import com.entity.ChongwurizhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChongwurizhiVO;
import com.entity.view.ChongwurizhiView;


/**
 * 宠物日志
 * 
 * @author 
 * @email 
 * @date 2022-02-27 17:35:06
 */
public interface ChongwurizhiDao extends BaseMapper<ChongwurizhiEntity> {
	
	List<ChongwurizhiVO> selectListVO(@Param("ew") Wrapper<ChongwurizhiEntity> wrapper);
	
	ChongwurizhiVO selectVO(@Param("ew") Wrapper<ChongwurizhiEntity> wrapper);
	
	List<ChongwurizhiView> selectListView(@Param("ew") Wrapper<ChongwurizhiEntity> wrapper);

	List<ChongwurizhiView> selectListView(Pagination page,@Param("ew") Wrapper<ChongwurizhiEntity> wrapper);
	
	ChongwurizhiView selectView(@Param("ew") Wrapper<ChongwurizhiEntity> wrapper);
	

}
