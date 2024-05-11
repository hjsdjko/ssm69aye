package com.dao;

import com.entity.DiscusschongwurizhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusschongwurizhiVO;
import com.entity.view.DiscusschongwurizhiView;


/**
 * 宠物日志评论表
 * 
 * @author 
 * @email 
 * @date 2022-02-27 17:35:06
 */
public interface DiscusschongwurizhiDao extends BaseMapper<DiscusschongwurizhiEntity> {
	
	List<DiscusschongwurizhiVO> selectListVO(@Param("ew") Wrapper<DiscusschongwurizhiEntity> wrapper);
	
	DiscusschongwurizhiVO selectVO(@Param("ew") Wrapper<DiscusschongwurizhiEntity> wrapper);
	
	List<DiscusschongwurizhiView> selectListView(@Param("ew") Wrapper<DiscusschongwurizhiEntity> wrapper);

	List<DiscusschongwurizhiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusschongwurizhiEntity> wrapper);
	
	DiscusschongwurizhiView selectView(@Param("ew") Wrapper<DiscusschongwurizhiEntity> wrapper);
	

}
