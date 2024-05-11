package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusschongwurizhiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusschongwurizhiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusschongwurizhiView;


/**
 * 宠物日志评论表
 *
 * @author 
 * @email 
 * @date 2022-02-27 17:35:06
 */
public interface DiscusschongwurizhiService extends IService<DiscusschongwurizhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusschongwurizhiVO> selectListVO(Wrapper<DiscusschongwurizhiEntity> wrapper);
   	
   	DiscusschongwurizhiVO selectVO(@Param("ew") Wrapper<DiscusschongwurizhiEntity> wrapper);
   	
   	List<DiscusschongwurizhiView> selectListView(Wrapper<DiscusschongwurizhiEntity> wrapper);
   	
   	DiscusschongwurizhiView selectView(@Param("ew") Wrapper<DiscusschongwurizhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusschongwurizhiEntity> wrapper);
   	

}

