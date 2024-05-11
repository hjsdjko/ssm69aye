package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChongwurizhiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChongwurizhiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChongwurizhiView;


/**
 * 宠物日志
 *
 * @author 
 * @email 
 * @date 2022-02-27 17:35:06
 */
public interface ChongwurizhiService extends IService<ChongwurizhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChongwurizhiVO> selectListVO(Wrapper<ChongwurizhiEntity> wrapper);
   	
   	ChongwurizhiVO selectVO(@Param("ew") Wrapper<ChongwurizhiEntity> wrapper);
   	
   	List<ChongwurizhiView> selectListView(Wrapper<ChongwurizhiEntity> wrapper);
   	
   	ChongwurizhiView selectView(@Param("ew") Wrapper<ChongwurizhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChongwurizhiEntity> wrapper);
   	

}

