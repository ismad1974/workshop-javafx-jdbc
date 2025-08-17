package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Main extends Application {

	private static Scene mainScene;

	@Override
	public void start(Stage primarySatage) {
		String absolutePath = "/gui/MainView.fxml";

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutePath));
			ScrollPane scrollPane = loader.load();

			// ajusta o scrollPane a Janela (altura e largura)
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);

			mainScene = new Scene(scrollPane);
			primarySatage.setScene(mainScene);
			primarySatage.setTitle("Sample JavaFX Application");
			primarySatage.show();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	public static Scene getMainScene() {
		return mainScene;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
