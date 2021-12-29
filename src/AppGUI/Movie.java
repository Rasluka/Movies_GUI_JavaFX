package AppGUI;

public class Movie {
    Integer peliculaID;
    String tituloPelicula;
    Integer anioPelicula;
    Integer tipoPelicula;
    Integer clasificacion;
    Integer cantidadEnExistencia, opiasDisponible, nEstrellas;

    public Movie(Integer peliculaID, String tituloPelicula, Integer anioPelicula, Integer tipoPelicula, Integer clasificacion, Integer cantidadEnExistencia, Integer opiasDisponible, Integer nEstrellas) {
        this.peliculaID = peliculaID;
        this.tituloPelicula = tituloPelicula;
        this.anioPelicula = anioPelicula;
        this.tipoPelicula = tipoPelicula;
        this.clasificacion = clasificacion;
        this.cantidadEnExistencia = cantidadEnExistencia;
        this.opiasDisponible = opiasDisponible;
        this.nEstrellas = nEstrellas;
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

    public Integer getTipoPelicula() {
        return tipoPelicula;
    }

    public Integer getClasificacion() {
        return clasificacion;
    }

    public Integer getCantidadEnExistencia() {
        return cantidadEnExistencia;
    }

    public Integer getOpiasDisponible() {
        return opiasDisponible;
    }

    public Integer getnEstrellas() {
        return nEstrellas;
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

    public void setTipoPelicula(Integer tipoPelicula) {
        this.tipoPelicula = tipoPelicula;
    }

    public void setClasificacion(Integer clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setCantidadEnExistencia(Integer cantidadEnExistencia) {
        this.cantidadEnExistencia = cantidadEnExistencia;
    }

    public void setOpiasDisponible(Integer opiasDisponible) {
        this.opiasDisponible = opiasDisponible;
    }

    public void setnEstrellas(Integer nEstrellas) {
        this.nEstrellas = nEstrellas;
    }
}

