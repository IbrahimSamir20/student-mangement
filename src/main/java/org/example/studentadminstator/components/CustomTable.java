package org.example.studentadminstator.components;
import org.example.studentadminstator.AppStyle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class CustomTable<T> extends VBox {
    private final TableView<T> tableView;
    public CustomTable() {
        this.tableView = new TableView<>();
        applyCustomStyle();
        this.getChildren().add(tableView);
        this.setSpacing(5);
    }

    private void applyCustomStyle() {
        this.tableView.setBorder(AppStyle.border);
        this.tableView.setBackground(AppStyle.background);
        this.tableView.setStyle("-fx-font-size: 18px; -fx-font-family: 'Arial';");
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
    public void deleteColumns(){ this.tableView.getColumns().clear(); }
    public TableView<T> getTableView() {
        return tableView;
    }
}

