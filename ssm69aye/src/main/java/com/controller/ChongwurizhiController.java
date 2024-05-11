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

import com.entity.ChongwurizhiEntity;
import com.entity.view.ChongwurizhiView;

import com.service.ChongwurizhiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 宠物日志
 * 后端接口
 * @author 
 * @email 
 * @date 2022-02-27 17:35:06
 */
@RestController
@RequestMapping("/chongwurizhi")
public class ChongwurizhiController {
    @Autowired
    private ChongwurizhiService chongwurizhiService;


    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChongwurizhiEntity chongwurizhi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			chongwurizhi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChongwurizhiEntity> ew = new EntityWrapper<ChongwurizhiEntity>();
		PageUtils page = chongwurizhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chongwurizhi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChongwurizhiEntity chongwurizhi, 
		HttpServletRequest request){
        EntityWrapper<ChongwurizhiEntity> ew = new EntityWrapper<ChongwurizhiEntity>();
		PageUtils page = chongwurizhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chongwurizhi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChongwurizhiEntity chongwurizhi){
       	EntityWrapper<ChongwurizhiEntity> ew = new EntityWrapper<ChongwurizhiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chongwurizhi, "chongwurizhi")); 
        return R.ok().put("data", chongwurizhiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChongwurizhiEntity chongwurizhi){
        EntityWrapper< ChongwurizhiEntity> ew = new EntityWrapper< ChongwurizhiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chongwurizhi, "chongwurizhi")); 
		ChongwurizhiView chongwurizhiView =  chongwurizhiService.selectView(ew);
		return R.ok("查询宠物日志成功").put("data", chongwurizhiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChongwurizhiEntity chongwurizhi = chongwurizhiService.selectById(id);
		chongwurizhi.setClicknum(chongwurizhi.getClicknum()+1);
		chongwurizhi.setClicktime(new Date());
		chongwurizhiService.updateById(chongwurizhi);
        return R.ok().put("data", chongwurizhi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChongwurizhiEntity chongwurizhi = chongwurizhiService.selectById(id);
		chongwurizhi.setClicknum(chongwurizhi.getClicknum()+1);
		chongwurizhi.setClicktime(new Date());
		chongwurizhiService.updateById(chongwurizhi);
        return R.ok().put("data", chongwurizhi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        ChongwurizhiEntity chongwurizhi = chongwurizhiService.selectById(id);
        if(type.equals("1")) {
        	chongwurizhi.setThumbsupnum(chongwurizhi.getThumbsupnum()+1);
        } else {
        	chongwurizhi.setCrazilynum(chongwurizhi.getCrazilynum()+1);
        }
        chongwurizhiService.updateById(chongwurizhi);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChongwurizhiEntity chongwurizhi, HttpServletRequest request){
    	chongwurizhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chongwurizhi);

        chongwurizhiService.insert(chongwurizhi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChongwurizhiEntity chongwurizhi, HttpServletRequest request){
    	chongwurizhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chongwurizhi);

        chongwurizhiService.insert(chongwurizhi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ChongwurizhiEntity chongwurizhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chongwurizhi);
        chongwurizhiService.updateById(chongwurizhi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chongwurizhiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ChongwurizhiEntity> wrapper = new EntityWrapper<ChongwurizhiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = chongwurizhiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ChongwurizhiEntity chongwurizhi, HttpServletRequest request,String pre){
        EntityWrapper<ChongwurizhiEntity> ew = new EntityWrapper<ChongwurizhiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = chongwurizhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chongwurizhi), params), params));
        return R.ok().put("data", page);
    }







}
