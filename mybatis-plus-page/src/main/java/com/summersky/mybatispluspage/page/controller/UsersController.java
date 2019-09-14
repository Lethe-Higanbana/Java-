package com.summersky.mybatispluspage.page.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.summersky.mybatispluspage.config.Base64;
import com.summersky.mybatispluspage.config.JFchart;
import com.summersky.mybatispluspage.page.entity.Users;
import com.summersky.mybatispluspage.page.mapper.UsersMapper;
import com.summersky.mybatispluspage.page.service.UsersService;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 王者英雄排行 前端控制器
 * </p>
 *
 * @author zengfanbin
 * @since 2019-09-10
 */
@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersMapper usersMapper;
    @Autowired
    UsersService usersService;
    private JFchart jFchart;
    private Users users;
    @RequestMapping("/index")
    public String indexs(){
        return "page";
    }

    /**
     * 返回图表 饼状图
     * @return
     */
    @RequestMapping("/JF")
    public String jFrchart(Map<String,Object> molde){
        //创建主题样式
        StandardChartTheme mChartTheme = new StandardChartTheme("CN");
        //设置标题字体
        mChartTheme.setExtraLargeFont(new Font("黑体", Font.BOLD, 20));
        //设置轴向字体
        mChartTheme.setLargeFont(new Font("宋体", Font.CENTER_BASELINE, 15));
        //设置图例字体
        mChartTheme.setRegularFont(new Font("宋体", Font.CENTER_BASELINE, 15));
        //应用主题样式
        ChartFactory.setChartTheme(mChartTheme);
        ///////////////以上主题设置必须位于创建图表函数之前才能生效////////////
        System.out.println(usersMapper.cike());;
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("刺客", usersMapper.cike());
        dataset.setValue("法师", usersMapper.fashi());
        dataset.setValue("坦克", usersMapper.tanke());
        dataset.setValue("辅助", usersMapper.fuzhu());
        dataset.setValue("射手", usersMapper.sheshou());
        dataset.setValue("战士", usersMapper.zhanshi());
        dataset.setValue("零", usersMapper.ling());
        dataset.setValue("侠岚", usersMapper.xialan());
        dataset.setValue("魂族", usersMapper.hunzu());
        dataset.setValue("古族", usersMapper.guzu());
        dataset.setValue("萧族", usersMapper.xiaozu());
        dataset.setValue("太虚古龙", usersMapper.txgl());
        dataset.setValue("异火", usersMapper.yihuo());

        JFreeChart chart = ChartFactory.createPieChart("职业占比比率图", dataset,
                true, true, true);


        String path="C:\\Users\\Lenovo\\Pictures\\PieChart.jpg";
        Base64 base=new Base64();
        String code="data:image/jpeg;base64,"+base.getImageBinary(path);
        try {
            ChartUtils.saveChartAsJPEG(new File(path),
                    chart, 800, 500);
        } catch (IOException e) {
            e.printStackTrace();
        }
        molde.put("src",code);
        return "JFreechart";

    }

    @ResponseBody
    @RequestMapping("/test")
    public List<Users> test(){
        System.out.println(usersMapper.groupliist());

        return usersMapper.groupliist();
    }

    /**
     * 分页查询
     * @param pageNumber 页码
     * @param pageSize 每页显示多少条
     *
     */
    @ResponseBody
    @RequestMapping(value = "/page")//,method = RequestMethod.POST)
    //前端传参
    public Object page(Integer pageNumber,Integer pageSize)
    {
        //创建一个 Map
        Map<String,Object> map = new HashMap<>();
        //查询数据的封装
        QueryWrapper<Users> queryWrapper =  new QueryWrapper<>();
        //这个可以让你的查询按你设定的顺序查询
        //queryWrapper.orderByDesc("id");
        //根据前台传的参数进行分页查询
        Page<Users> page = new Page<>(pageNumber,pageSize);
        IPage<Users> iPage =usersMapper.selectPage(page,queryWrapper);
        //bootstrap 要求返回的json数据要包括两个属性
        //total:总记录数   rows：显示的内容
        map.put("total",iPage.getTotal());
        map.put("rows",iPage.getRecords());
        System.out.println(iPage.getRecords().size());
        System.out.println(JSON.toJSONString(iPage));
        System.out.println(JSON.toJSONString(map));
        return JSON.toJSONString(map);
    }
    /**
     * 解决图表汉字显示问题
     *
     * @param chart
     */
    private static void processChart(JFreeChart chart) {
        CategoryPlot plot = chart.getCategoryPlot();
        //PiePlot piePlot=chart.getPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        ValueAxis rAxis = plot.getRangeAxis();
        chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        TextTitle textTitle = chart.getTitle();
        textTitle.setFont(new Font("宋体", Font.PLAIN, 20));
        domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));
        domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
        rAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
        rAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));
        // renderer.setItemLabelGenerator(new LabelGenerator(0.0));
        // renderer.setItemLabelFont(new Font("宋体", Font.PLAIN, 12));
        // renderer.setItemLabelsVisible(true);
    }
}

