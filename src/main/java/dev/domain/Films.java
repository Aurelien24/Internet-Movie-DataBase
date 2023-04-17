package dev.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "FILMS")
public class Films {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFilm;

    @Column(name = "NOM")
    private String nomF;
    @Column(name = "ANNEE")
    private String anneeF;
    @Column(name = "URL")
    private String urlF;
    @Column(name = "DESCRIPTION")
    private String descF;


    public Films() {
    }

    public Films(Integer idFilm, String nomF, String anneeF, String urlF, String descF) {
        this.idFilm = idFilm;
        this.nomF = nomF;
        this.anneeF = anneeF;
        this.urlF = urlF;
        this.descF = descF;
    }

    public Integer getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Integer idFilm) {
        this.idFilm = idFilm;
    }

    public String getNomF() {
        return nomF;
    }

    public void setNomF(String nomF) {
        this.nomF = nomF;
    }

    public String getAnneeF() {
        return anneeF;
    }

    public void setAnneeF(String anneeF) {
        this.anneeF = anneeF;
    }

    public String getUrlF() {
        return urlF;
    }

    public void setUrlF(String urlF) {
        this.urlF = urlF;
    }

    public String getDescF() {
        return descF;
    }

    public void setDescF(String descF) {
        this.descF = descF;
    }

    @Override
    public String toString() {
        return "Film{" +
                "idFilm=" + idFilm +
                ", nomF='" + nomF + '\'' +
                ", anneeF='" + anneeF + '\'' +
                ", urlF='" + urlF + '\'' +
                ", descF='" + descF + '\'' +
                '}';
    }
}