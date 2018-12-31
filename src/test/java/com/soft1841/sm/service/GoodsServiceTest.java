//package com.soft1841.sm.service;
//
//import com.soft1841.sm.entity.Goods;
//import com.soft1841.sm.utils.ServiceFactory;
//import org.junit.Test;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//public class GoodsServiceTest {
//    private GoodsService goodsService = ServiceFactory.getGoodsServiceInstance();
//
//    @Test
//    public void addGoods() {
//        Goods goods = new Goods();
//        goods.setTypeId(1);
//        goods.setName("df");
//        goods.setPrice(20);
//        goods.setCover("sd");
//        goods.setDescription("测试吗");
//        goods.setBarcode("");
//        goods.setStock(123);
//        goodsService.addGoods(goods);
//    }
//
//    @Test
//    public void deleteGoods() {
//        goodsService.deleteGoods(123);
//    }
//
//
//    @Test
//    public void updateGoods() {
//        Goods goods = new Goods();
//        goods.setBarcode("12");
//        goods.setName("gdb");
//        goods.setStock(12);
//        goodsService.addGoods(goods);
//    }
//
//    @Test
//    public void getAllGoods() {
//        List<Goods> goodsList = goodsService.getAllGoods();
//        goodsList.forEach(goods -> System.out.println(goods));
//    }
//
//    @Test
//    public void getGoodsByTypeId() {
//        List<Goods> goodsList = goodsService.getGoodsByTypeId(1);
//        goodsList.forEach(goods -> System.out.println(goods));
//    }
//
//
//    @Test
//    public void getGoodsLike() {
//        List<Goods> goodsList = goodsService.getGoodsLike("开");
//        goodsList.forEach(goods -> System.out.println(goods));
//    }
//
//    @Test
//    public void getGoods() {
//        System.out.println(goodsService.getGoods(1));
//    }
//}