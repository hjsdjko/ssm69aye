package com.entity.view;

import com.entity.DiscusschongwurizhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 宠物日志评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-02-27 17:35:06
 */
@TableName("discusschongwurizhi")
public class DiscusschongwurizhiView  extends DiscusschongwurizhiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusschongwurizhiView(){
	}
 
 	public DiscusschongwurizhiView(DiscusschongwurizhiEntity discusschongwurizhiEntity){
 	try {
			BeanUtils.copyProperties(this, discusschongwurizhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
