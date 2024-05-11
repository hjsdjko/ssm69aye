package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscusschongwurizhiEntity;
import com.entity.view.DiscusschongwurizhiView;

import com.service.DiscusschongwurizhiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 宠物日志评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2022-02-27 17:35:06
 */
@RestController
@RequestMapping("/discusschongwurizhi")
public class DiscusschongwurizhiController {
    @Autowired
    private DiscusschongwurizhiService discusschongwurizhiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusschongwurizhiEntity discusschongwurizhi, 
		HttpServletRequest request){

        EntityWrapper<DiscusschongwurizhiEntity> ew = new EntityWrapper<DiscusschongwurizhiEntity>();
		PageUtils page = discusschongwurizhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusschongwurizhi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusschongwurizhiEntity discusschongwurizhi, 
		HttpServletRequest request){
        EntityWrapper<DiscusschongwurizhiEntity> ew = new EntityWrapper<DiscusschongwurizhiEntity>();
		PageUtils page = discusschongwurizhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusschongwurizhi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusschongwurizhiEntity discusschongwurizhi){
       	EntityWrapper<DiscusschongwurizhiEntity> ew = new EntityWrapper<DiscusschongwurizhiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusschongwurizhi, "discusschongwurizhi")); 
        return R.ok().put("data", discusschongwurizhiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusschongwurizhiEntity discusschongwurizhi){
        EntityWrapper< DiscusschongwurizhiEntity> ew = new EntityWrapper< DiscusschongwurizhiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusschongwurizhi, "discusschongwurizhi")); 
		DiscusschongwurizhiView discusschongwurizhiView =  discusschongwurizhiService.selectView(ew);
		return R.ok("查询宠物日志评论表成功").put("data", discusschongwurizhiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusschongwurizhiEntity discusschongwurizhi = discusschongwurizhiService.selectById(id);
        return R.ok().put("data", discusschongwurizhi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusschongwurizhiEntity discusschongwurizhi = discusschongwurizhiService.selectById(id);
        return R.ok().put("data", discusschongwurizhi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusschongwurizhiEntity discusschongwurizhi, HttpServletRequest request){
    	discusschongwurizhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusschongwurizhi);

        discusschongwurizhiService.insert(discusschongwurizhi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusschongwurizhiEntity discusschongwurizhi, HttpServletRequest request){
    	discusschongwurizhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusschongwurizhi);

        discusschongwurizhiService.insert(discusschongwurizhi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscusschongwurizhiEntity discusschongwurizhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusschongwurizhi);
        discusschongwurizhiService.updateById(discusschongwurizhi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusschongwurizhiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscusschongwurizhiEntity> wrapper = new EntityWrapper<DiscusschongwurizhiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discusschongwurizhiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
