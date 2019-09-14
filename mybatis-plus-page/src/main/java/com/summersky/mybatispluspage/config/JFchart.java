package com.summersky.mybatispluspage.config;

import com.summersky.mybatispluspage.page.mapper.UsersMapper;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Authur:zengfanbin
 * @Date:2019-9-11
 * @Time:15:01
 * @Description:
 */
public class JFchart {
    @Autowired
    UsersMapper usersMapper;
    /*public static void main(String[] args) {
        // 1. 得到数据
        CategoryDataset dataset = getDataSet();
        // 2. 构造chart
        JFreeChart chart = ChartFactory.createBarChart3D(
                "水果产量图", // 图表标题
                "水果", // 目录轴的显示标签--横轴
                "产量", // 数值轴的显示标签--纵轴
                dataset, // 数据集
                PlotOrientation.VERTICAL, // 图表方向：水平、
                true, // 是否显示图例(对于简单的柱状图必须
                false, // 是否生成工具
                false // 是否生成URL链接
        );
        // 3. 处理chart中文显示问题
        processChart(chart);

        // 4. chart输出图片
        writeChartAsImage(chart);

        // 5. chart 以swing形式输出
        ChartFrame pieFrame = new ChartFrame("XXX", chart);
        pieFrame.pack();
        pieFrame.setVisible(true);

    }

    *//**
     * 获取一个演示用的组合数据集对象
     *
     * @return
     *//*
    private static CategoryDataset getDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100, "北京", "苹果");
        dataset.addValue(120, "上海", "苹果");
        dataset.addValue(160, "广州", "苹果");
        dataset.addValue(210, "北京", "梨子");
        dataset.addValue(220, "上海", "梨子");
        dataset.addValue(230, "广州", "梨子");
        dataset.addValue(330, "北京", "葡萄");
        dataset.addValue(340, "上海", "葡萄");
        dataset.addValue(340, "广州", "葡萄");
        dataset.addValue(420, "北京", "香蕉");
        dataset.addValue(430, "上海", "香蕉");
        dataset.addValue(400, "广州", "香蕉");
        dataset.addValue(510, "北京", "荔枝");
        dataset.addValue(530, "上海", "荔枝");
        dataset.addValue(510, "广州", "荔枝");
        return dataset;
    }

    *//**
     * 解决图表汉字显示问题
     *
     * @param chart
     *//*
    private static void processChart(JFreeChart chart) {
        CategoryPlot plot = chart.getCategoryPlot();
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

    *//**
     * 输出图片
     *
     * @param chart
     *//*
    private static void writeChartAsImage(JFreeChart chart) {
        FileOutputStream fos_jpg = null;
        try {
            fos_jpg = new FileOutputStream("D:\\test\\fruit.jpg");
            //ChartUtilities.writeChartAsJPEG(fos_jpg, 1, chart, 400, 300, null);
            ChartUtils.writeChartAsJPEG(fos_jpg, 1, chart, 400, 300, null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos_jpg.close();
            } catch (Exception e) {
            }
        }
    }

*/
    /**
     * 解决图表汉字显示问题
     *
     * @param chart
     */
    private static void processChart(JFreeChart chart) {
        CategoryPlot plot = chart.getCategoryPlot();
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

    /**
     * 饼状图
     */

    public String createPieChart() {

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("刺客", usersMapper.cike());
        dataset.setValue("法师", usersMapper.fashi());
        dataset.setValue("坦克", usersMapper.tanke());
        dataset.setValue("辅助", usersMapper.fuzhu());
        dataset.setValue("射手", usersMapper.sheshou());
        dataset.setValue("战士", usersMapper.zhanshi());
        dataset.setValue("零", usersMapper.ling());
        dataset.setValue("侠岚", usersMapper.xialan());

        JFreeChart chart = ChartFactory.createPieChart("职业占比比率图", dataset,
                true, true, true);

        Plot cp = chart.getPlot();
        cp.setBackgroundPaint(ChartColor.WHITE); // 背景色设置

        // 3. 处理chart中文显示问题
        processChart(chart);

        // 5. chart 以swing形式输出
        ChartFrame pieFrame = new ChartFrame("XXX", chart);
        pieFrame.pack();
        pieFrame.setVisible(true);

        String path="D:\\test\\PieChart.png";
        try {
            ChartUtils.saveChartAsPNG(new File(path),
                    chart, 800, 500);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

}
