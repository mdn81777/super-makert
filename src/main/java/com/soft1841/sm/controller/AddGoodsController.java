package com.soft1841.sm.controller;
/**
 * 新增书籍控制
 *
 * @author 蔡一帆
 */

import cn.hutool.db.Entity;
import com.soft1841.sm.dao.GoodsDAO;
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.service.GoodsService;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.utils.DAOFactory;
import com.soft1841.sm.utils.ServiceFactory;
import com.sun.org.glassfish.gmbal.Description;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AddGoodsController implements Initializable {
    private ObservableList<Goods> goodsData = FXCollections.observableArrayList();

    public ObservableList<Goods> getGoodsData() {
        return goodsData;
    }

    public void setGoodsData(ObservableList<Goods> goodsData) {
        this.goodsData = goodsData;
    }

    @FXML
    private ComboBox<Type> goodsType;
    @FXML
    private TextField goodsName, goodsPrice, goodsCover, goodsBarcode, goodsStock;
    @FXML
    private TextArea goodsDescription;

    private ObservableList<Type> typeData = FXCollections.observableArrayList();

    private TypeService typeService = ServiceFactory.getTypeServiceInstance();
    private GoodsService goodsService = ServiceFactory.getGoodsServiceInstance();
    private List<Type> entityList = null;

    private Long typeId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        entityList = typeService.getAllTypes();
        for (Type entity : entityList) {
            typeData.add(entity);
        }
        goodsType.setItems(typeData);
        goodsType.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            typeId = newValue.getId();
        });
    }

    public void addGoods() throws Exception {
        String name = goodsName.getText();
        String price = goodsPrice.getText();
        String cover = goodsCover.getText();
        String barcode = goodsBarcode.getText();
        String stock = goodsStock.getText();
        String description = goodsDescription.getText();
        System.out.println(stock);
        Goods goods = new Goods();
        goods.setTypeId(typeId);
        goods.setName(name);
        goods.setPrice(Double.parseDouble(price));
        goods.setCover(cover);
        goods.setBarcode(barcode);
        goods.setStock(Integer.parseInt(stock));
        goods.setDescription(description);
        long id = goodsService.addGoods(goods);
        goods.setId(id);
        this.getGoodsData().add(goods);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示信息");
        alert.setHeaderText("新增商品成功！");
        alert.showAndWait();
        Stage stage = (Stage) goodsName.getScene().getWindow();
        stage.close();
    }
}
