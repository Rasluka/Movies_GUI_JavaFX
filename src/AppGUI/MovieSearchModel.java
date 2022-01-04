package AppGUI;

public class MovieSearchModel {
    Integer peliculaID;
    String tituloPelicula;
    Integer anioPelicula;
    String tipoPelicula;
    String clasificacionPelicula;
    Integer enExistencia;
    Integer copiasDisponibles;
    Integer estrellas;

    public MovieSearchModel(Integer peliculaID, String tituloPelicula, Integer anioPelicula, String tipoPelicula, String clasificacionPelicula, Integer enExistencia, Integer copiasDisponibles, Integer estrellas) {
        this.peliculaID = peliculaID;
        this.tituloPelicula = tituloPelicula;
        this.anioPelicula = anioPelicula;
        this.tipoPelicula = tipoPelicula;
        this.clasificacionPelicula = clasificacionPelicula;
        this.enExistencia = enExistencia;
        this.copiasDisponibles = copiasDisponibles;
        this.estrellas = estrellas;
    }

    public void setPeliculaID(Integer peliculaID) {
        this.peliculaID = peliculaID;
    }

    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }

    public void setAnioPelicula(Integer anioPelicula) {
        this.anioPelicula = anioPelicula;
    }

    public void setTipoPelicula(String tipoPelicula) {
        this.tipoPelicula = tipoPelicula;
    }

    public void setClasificacionPelicula(String clasificacionPelicula) {
        this.clasificacionPelicula = clasificacionPelicula;
    }

    public void setEnExistencia(Integer enExistencia) {
        this.enExistencia = enExistencia;
    }

    public void setCopiasDisponibles(Integer copiasDisponibles) {
        this.copiasDisponibles = copiasDisponibles;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }

    public Integer getPeliculaID() {
        return peliculaID;
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public Integer getAnioPelicula() {
        return anioPelicula;
    }

    public String getTipoPelicula() {
        return tipoPelicula;
    }

    public String getClasificacionPelicula() {
        return clasificacionPelicula;
    }

    public Integer getEnExistencia() {
        return enExistencia;
    }

    public Integer getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public Integer getEstrellas() {
        return estrellas;
    }
}
