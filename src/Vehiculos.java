

public class Vehiculos {

    String matricula;
    String marca;
    String modelo;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Vehiculos(String matricula, String marca, String modelo){

        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;

    }



}