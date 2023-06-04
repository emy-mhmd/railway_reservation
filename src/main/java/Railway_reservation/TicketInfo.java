package Railway_reservation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.embed.swing.SwingFXUtils;


import javafx.scene.transform.Transform;

import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;



import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;

import java.io.IOException;



public class TicketInfo {

    @FXML
    private Label passenfername;
    @FXML
    private Label route;

    @FXML
    private Label ticketprice;
    @FXML
    private Label coachnumber;
    @FXML
    private Label trainnumber;
    @FXML
    private Label arrivingtime;
    @FXML
    private Label departuretime;

    @FXML
    private Label seatsnumber;
    @FXML
    private Label categore;
    @FXML
    private Label day;
    @FXML
    private AnchorPane ticketpane;


    public void setlabels(String passenger_name, String train_route, double ticket_price,
                          int coach_number, int train_number, String arriving_time, String departure_time
    , String train_categore,String selected_day,String seats_number)
    {
        passenfername.setText(passenger_name);
        route.setText(train_route);
        ticketprice.setText(ticket_price+"E£");
        coachnumber.setText(coach_number+" ");
        trainnumber.setText(train_number+" ");
        arrivingtime.setText(arriving_time);
        departuretime.setText(departure_time);
        day.setText(selected_day);
        categore.setText(train_categore);
        seatsnumber.setText(seats_number);
    }

    @FXML
    public void print(ActionEvent event) throws IOException, PrinterException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();

        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        //converting the ticketpane to image
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setTransform(Transform.scale(1.0, 1.0));
        WritableImage image = ticketpane.snapshot(parameters, null);
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
        PDImageXObject pdImage = LosslessFactory.createFromImage(document, bufferedImage);
        contentStream.drawImage(pdImage, 0, 0, page.getMediaBox().getWidth(), page.getMediaBox().getHeight());
        contentStream.close();
        document.save("ticket.pdf");
        document.close();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ticket Downloaded");
        alert.setHeaderText(null);
        alert.setContentText("The ticket has been downloaded.");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();


    }
}






