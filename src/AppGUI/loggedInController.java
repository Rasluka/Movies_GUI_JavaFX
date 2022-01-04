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
import java.util.logging.Level;
import java.util.logging.Logger;

public class loggedInController implements Initializable {
    @FXML
    private Button bttSignOut;

    @FXML
    private TableView<MovieSearchModel> movieTableView;
    @FXML
    private TableColumn<MovieSearchModel, Integer> idTableColumn;
    @FXML
    private TableColumn<MovieSearchModel, String> tituloTableColumn;
    @FXML
    private TableColumn<MovieSearchModel, Integer> anioTableColumn;
    @FXML
    private TableColumn<MovieSearchModel, String> tipoPeliculaTableColumn;
    @FXML
    private TableColumn<MovieSearchModel, String> clasificacionTableColumn;
    @FXML
    private TableColumn<MovieSearchModel, Integer> existenciasTableColumn;
    @FXML
    private TableColumn<MovieSearchModel, Integer> disponiblesTableColumn;
    @FXML
    private TableColumn<MovieSearchModel, Integer> estrellasTableColumn;

    ObservableList<MovieSearchModel> movieSearchModelobservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connection connectDB = null;

        String moviesViewQuery =
                "SELECT P.PeliculaID, P.Titulo, P.Anio, T.TipoPelicula, C.Simbolo AS 'Clasificacion', P.CantidadEnExistencia, P.CopiasDisponible, P.nEstrellas\n" +
                "FROM Peliculas AS P, ClasificacionPelicula AS C, TipoDePelicula AS T\n" +
                "WHERE P.TipoPelicula = T.TipoID AND P.Clasificacion = C.ClasificacionID;";

        try {
            connectDB = new SQLConnection().getDBConnection();
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(moviesViewQuery);

            while (resultSet.next()){
                Integer queryPeliculaID = resultSet.getInt("PeliculaID");
                String queryTitulo = resultSet.getString("Titulo");
                Integer queryAnio = resultSet.getInt("Anio");
                String queryTipoPelicula = resultSet.getString("TipoPelicula");
                String queryClasificacion = resultSet.getString("Clasificacion");
                Integer queryExistencia = resultSet.getInt("CantidadEnExistencia");
                Integer queryCopiasDisponible = resultSet.getInt("CopiasDisponible");
                Integer queryEstrellas = resultSet.getInt("nEstrellas");

                // Populate the Obsevable list
                movieSearchModelobservableList.add(new MovieSearchModel(queryPeliculaID, queryTitulo, queryAnio, queryTipoPelicula, queryClasificacion, queryExistencia, queryCopiasDisponible, queryEstrellas));
            }


            //
            idTableColumn.setCellValueFactory(new PropertyValueFactory<>("peliculaID"));
            tituloTableColumn.setCellValueFactory(new PropertyValueFactory<>("tituloPelicula"));
            anioTableColumn.setCellValueFactory(new PropertyValueFactory<>("anioPelicula"));
            tipoPeliculaTableColumn.setCellValueFactory(new PropertyValueFactory<>("tipoPelicula"));
            clasificacionTableColumn.setCellValueFactory(new PropertyValueFactory<>("clasificacionPelicula"));
            existenciasTableColumn.setCellValueFactory(new PropertyValueFactory<>("enExistencia"));
            disponiblesTableColumn.setCellValueFactory(new PropertyValueFactory<>("copiasDisponibles"));
            estrellasTableColumn.setCellValueFactory(new PropertyValueFactory<>("estrellas"));


            movieTableView.setItems(movieSearchModelobservableList);

        } catch (SQLException e){
            Logger.getLogger(MovieSearchModel.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        } finally {
            if (connectDB != null){
                try{
                    connectDB.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
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
