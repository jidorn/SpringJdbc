package fr.afcepf.al26.spring.entity;

public class Adresse {
    private Integer id;
    private String num;
    private String rue;
    private String ville;
    private String cp;
    private String pays;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

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
}
