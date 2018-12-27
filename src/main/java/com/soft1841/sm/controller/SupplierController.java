package com.soft1841.sm.controller;
import com.soft1841.sm.entity.Supplier;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.service.SupplierService;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.utils.ComponentUtil;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;

import java.util.Optional;
import java.util.ResourceBundle;

public class SupplierController implements Initializable {
    @FXML
    private TableView<Supplier> supplierTable;

    @FXML
    private ComboBox<Type> typeComboBox;

    @FXML
    private TextField keywordsField;

    private ObservableList<Supplier> supplierData = FXCollections.observableArrayList();

    private ObservableList<Type> typeData = FXCollections.observableArrayList();

    private SupplierService supplierService = ServiceFactory.getSupplierServiceInstance();

    private TypeService typeService = ServiceFactory.getTypeServiceInstance();

    private List<Supplier> supplierList = null;

    private List<Type> typeList = null;

    private TableColumn<Supplier,Supplier> delCol = new TableColumn<>("操作");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        initComBox();
    }

    private void initTable() {
        supplierTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        supplierList = supplierService.getAllSupplier();
        showSupplierDate(supplierList);
        delCol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        delCol.setCellFactory(param -> new TableCell<Supplier, Supplier>() {
            private final Button deleteButton = ComponentUtil.getButton("删除", "warning-theme");

            @Override
            protected void updateItem(Supplier supplier, boolean empty) {
                super.updateItem(supplier, empty);
                if (supplier == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(deleteButton);
                deleteButton.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("确认对话框");
                    alert.setHeaderText("供应商：" + supplier.getSupplierName());
                    alert.setContentText("确定要删除这行记录吗?");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        supplierData.remove(supplier);
                        supplierService.deleteSupplier(supplier.getId());
                    }
                });
            }
        });
        supplierTable.getColumns().add(delCol);
        supplierTable.setRowFactory(tv ->

        {
            TableRow<Supplier> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    long id = row.getItem().getId();

                    Supplier supplier = (Supplier) supplierService.getAllSupplier(id);
                    Stage supplierInfoStage = new Stage();
                    supplierInfoStage.setTitle("供应商详情界面");
                    VBox vBox = new VBox();
                    vBox.setSpacing(10);
                    vBox.setAlignment(Pos.CENTER);
                    vBox.setPrefSize(600, 400);
                    vBox.setPadding(new Insets(10, 10, 10, 10));
                    Label nameLabel = new Label("供应商：" + supplier.getSupplierName());
                    nameLabel.getStyleClass().add("font-title");
                    Label authorLabel = new Label("地址：" + supplier.getSupplierAddress());
                    Label phoneLabel = new Label("联系方式:" + supplier.getSupplierPhone());
                    Label linkmenLabel = new Label("称呼：" + supplier.getLinkman());
                    vBox.getChildren().addAll(nameLabel, authorLabel, phoneLabel, linkmenLabel);
                    Scene scene = new Scene(vBox, 640, 480);
                    scene.getStylesheets().add("/css/style.css");
                    supplierInfoStage.setScene(scene);
                    supplierInfoStage.show();
                }
            });
            return row;
        });
    }
    private void initComBox() {
        typeData.addAll(typeList);
        typeComboBox.setItems(typeData);


                }


    private void showSupplierDate(List<Supplier> supplierList) {
       supplierData.addAll(supplierList);
        supplierTable.setItems(supplierData);
    }

    public void newSupplierStage() throws Exception {
        Stage addsupplierStage = new Stage();
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/add_supplier.fxml"));
        AnchorPane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");
        AddSupplierController addSupplierController = fxmlLoader.getController();
        addSupplierController.setSuppliersData(supplierData);
        addsupplierStage.setTitle("新增供应商界面");
        addsupplierStage.setResizable(false);
        addsupplierStage.setScene(scene);
        addsupplierStage.show();
    }
}


