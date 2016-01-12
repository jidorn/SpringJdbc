package fr.afcepf.al26.spring.entity;

import javax.persistence.*;

@Entity
public class Adresse {
    private Integer id;
    private String num;
    private String rue;
    private String ville;
    private String cp;
    private String pays;

    public Adresse(Integer id, String num, String rue, String ville, String cp, String pays) {
        this.id = id;
        this.num = num;
        this.rue = rue;
        this.ville = ville;
        this.cp = cp;
        this.pays = pays;
    }

    public Adresse() {
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", rue='" + rue + '\'' +
                ", ville='" + ville + '\'' +
                ", cp='" + cp + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "num")
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Basic
    @Column(name = "rue")
    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    @Basic
    @Column(name = "ville")
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Basic
    @Column(name = "cp")
    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    @Basic
    @Column(name = "pays")
    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adresse adresse = (Adresse) o;

        if (id != null ? !id.equals(adresse.id) : adresse.id != null) return false;
        if (num != null ? !num.equals(adresse.num) : adresse.num != null) return false;
        if (rue != null ? !rue.equals(adresse.rue) : adresse.rue != null) return false;
        if (ville != null ? !ville.equals(adresse.ville) : adresse.ville != null) return false;
        if (cp != null ? !cp.equals(adresse.cp) : adresse.cp != null) return false;
        if (pays != null ? !pays.equals(adresse.pays) : adresse.pays != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (rue != null ? rue.hashCode() : 0);
        result = 31 * result + (ville != null ? ville.hashCode() : 0);
        result = 31 * result + (cp != null ? cp.hashCode() : 0);
        result = 31 * result + (pays != null ? pays.hashCode() : 0);
        return result;
    }
}
