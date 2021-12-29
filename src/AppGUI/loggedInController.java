package AppGUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class loggedInController implements Initializable {
    @FXML
    private Button bttSignOut;

    @FXML
    private TableView<Movie> movieTableView;

    @FXML
    private TableColumn<Movie, Integer> anio;

    @FXML
    private TableColumn<Movie, String> clasificacion;

    @FXML
    private TableColumn<Movie, Integer> disponibles;

    @FXML
    private TableColumn<Movie, Integer> estrellas;

    @FXML
    private TableColumn<Movie, Integer> existencias;

    @FXML
    private TableColumn<Movie, Integer> id;

    @FXML
    private TableColumn<Movie, String> tipoPelicula;

    @FXML
    private TableColumn<Movie, String> titulo;

    ObservableList<Movie> movieObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connection connectDB = new SQLConnection().getDBConnection();

        String moviesViewQuery = "SELECT PeliculaID, Titulo, Anio, TipoPelicula, Clasificacion, CantidadEnExistencia, CopiasDisponible, nEstrellas FROM Peliculas";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(moviesViewQuery);


            while (resultSet.next()){
                Integer queryPeliculaID = resultSet.getInt("PeliculaID");
                String queryTitulo = resultSet.getString("Titulo");
                Integer queryAnio = resultSet.getInt("Anio");
                Integer queryTipoPelicula = resultSet.getInt("TipoPelicula");
                Integer queryClasificacion = resultSet.getInt("CantidadEnExistencia");
                Integer queryCantidadEnExistencia = resultSet.getInt("PeliculaID");
                Integer queryCopiasDisponible = resultSet.getInt("CopiasDisponible");
                Integer querynEstrellas = resultSet.getInt("nEstrellas");

                movieObservableList.add(new Movie(queryPeliculaID, queryTitulo, queryAnio, queryTipoPelicula, queryClasificacion, queryCantidadEnExistencia, queryCopiasDisponible, querynEstrellas));
            }

            id.setCellValueFactory(new PropertyValueFactory<>("peliculaID"));
            titulo.setCellValueFactory(new PropertyValueFactory<>("tituloPelicula"));
            anio.setCellValueFactory(new PropertyValueFactory<>("anioPelicula"));
            tipoPelicula.setCellValueFactory(new PropertyValueFactory<>("tipoPelicula"));
            clasificacion.setCellValueFactory(new PropertyValueFactory<>("clasificacion"));
            existencias.setCellValueFactory(new PropertyValueFactory<>("cantidadEnExistencia"));
            disponibles.setCellValueFactory(new PropertyValueFactory<>("copiasDisponible"));
            estrellas.setCellValueFactory(new PropertyValueFactory<>("nEstrellas"));
            titulo.setCellValueFactory(new PropertyValueFactory<>("tituloPelicula"));


            movieTableView.setItems(movieObservableList);



        }catch (SQLException e){
            e.printStackTrace();
        }


        bttSignOut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Signing out!");
                UtilsMethods.changeScene(actionEvent, "signInUI.fxml", false, true);
            }
        });
    }
}
