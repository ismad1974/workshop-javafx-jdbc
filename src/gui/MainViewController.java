package gui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.service.DepartmentService;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemSeller;

	@FXML
	private MenuItem menuItemDepartment;

	@FXML
	private MenuItem menuItemAbout;

	@FXML
	private Button btAviso;

	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction");
	}

	public void onMenuItemDepartmentAction() {
		loadView("/gui/DepartmentList.fxml", (DepartmentListController controller) -> {
			controller.setService(new DepartmentService());
			controller.updateTableView();
		});
	}

	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml", x -> {
		});
	}

	public void onAvisoAction() {
		Alerts.showAlert("Aviso", null, "O Senhor é a minha força", AlertType.INFORMATION);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializeAction) {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVbox = loader.load();

			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			Node mainMenu = mainVBox.getChildren().get(0);
			Node mainButtonBar = mainVBox.getChildren().get(1);

			mainVBox.getChildren().clear();

			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().add(mainButtonBar);
			mainVBox.getChildren().addAll(newVbox.getChildren());

			T controller = loader.getController();
			initializeAction.accept(controller);

		} catch (Exception e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		}
	}

}
