package org.example.studentadminstator.components;

import org.example.studentadminstator.AppStyle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class CustomTable<T> extends VBox {
    private TableView<T> tableView;

    public CustomTable() {
        this.tableView = new TableView<>();
        applyCustomStyle();
        this.getChildren().add(tableView);
        this.setSpacing(5);
    }

    private void applyCustomStyle() {
        this.tableView.setBorder(AppStyle.border);
        this.tableView.setBackground(AppStyle.background);
    }

    public void addColumn(String title, String property, double width) {
        TableColumn<T, String> column = new TableColumn<>(title);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
        column.setPrefWidth(width);
        this.tableView.getColumns().add(column);
    }

    public void addRow(T item) {
        this.tableView.getItems().add(item);
    }

    public void setTableData(ObservableList<T> data) {
        this.tableView.setItems(data);
    }

    public void setTableData(T[] dataArray) {
        this.tableView.setItems(FXCollections.observableArrayList(dataArray));
    }

    public TableView<T> getTableView() {
        return tableView;
    }}

//    public static class TestApp extends Application {
//        @Override
//        public void start(Stage primaryStage) {
//            CustomTable<Person> table = new CustomTable<>();
//            table.addColumn("Name", "name", 150);
//            table.addColumn("Age", "age", 100);
//
//            ObservableList<Person> data = FXCollections.observableArrayList(
//                    new Person("Alice", 25),
//                    new Person("Bob", 30)
//            );
//            table.setTableData(data);
//
//            VBox root = new VBox(table);
//            Scene scene = new Scene(root, 400, 300);
//            primaryStage.setScene(scene);
//            primaryStage.setTitle("Custom Table Example");
//            primaryStage.show();
//        }
//
//        public static void main(String[] args) {
//            launch(args);
//        }
//    }
//
//    public static class Person {
//        private String name;
//        private int age;
//
//        public Person(String name, int age) {
//            this.name = name;
//            this.age = age;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public int getAge() {
//            return age;
//        }
//    }
//}
