import javax.lang.model.type.NullType;

public class Motos extends Vehiculos {


        int cilindrada;


    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public Motos(String matricula, String marca, String modelo, int cilindrada) {


            super(matricula, marca, modelo);
            this.cilindrada = cilindrada;
        }




}


