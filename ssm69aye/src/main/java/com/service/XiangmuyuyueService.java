package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiangmuyuyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiangmuyuyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiangmuyuyueView;


/**
 * 项目预约
 *
 * @author 
 * @email 
 * @date 2022-02-27 17:35:06
 */
public interface XiangmuyuyueService extends IService<XiangmuyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiangmuyuyueVO> selectListVO(Wrapper<XiangmuyuyueEntity> wrapper);
   	
   	XiangmuyuyueVO selectVO(@Param("ew") Wrapper<XiangmuyuyueEntity> wrapper);
   	
   	List<XiangmuyuyueView> selectListView(Wrapper<XiangmuyuyueEntity> wrapper);
   	
   	XiangmuyuyueView selectView(@Param("ew") Wrapper<XiangmuyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiangmuyuyueEntity> wrapper);
   	

}

