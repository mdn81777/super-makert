package com.soft1841.sm.controller;

import com.soft1841.sm.service.AnalysisService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class DefaultController implements Initializable {
    @FXML
    private ImageView goodImg;
    @FXML
    private Label goodsCount,typeCount,staffCount,memberCount,supplierCount;
    private AnalysisService analysisService = ServiceFactory.getAnalysisServiceInstance();

    String[] imgPath = {"good1.png","good2.png","good3.png","good4.png","good5.png"};
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //获取后台的统计数据，显示在相应的区域
        goodsCount.setText("商品"+ analysisService.getGoodsCount() + "件" );
        typeCount.setText("种类" + analysisService.getTypeCount() + "种");
        staffCount.setText("员工" + analysisService.getStaffCount() + "人");
        memberCount.setText("会员" + analysisService.getMemberCount() + "人");
       supplierCount.setText("供应商" + analysisService.getSupplierCount() + "人");
        //新建一个线程，用来轮播
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //循环读取图片数组
                    for (int i = 0; i < imgPath.length; i++) {
                        //用每个资源创建一个图片对象
                        Image image = new Image("/img/" + imgPath[i]);
                        //开启一个UI线程
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                //将创建的Image对象设置给ImageView
                                 goodImg.setImage(image);
                            }
                        });
                        try {
                            //休眠2秒
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //轮播到最后一张图的时候，回到第一张重新播放
                        if (i == imgPath.length - 1) {
                            i = 0;
                        }
                    }
                }
            }
        }).start();
        }

    }

