public class Coches extends Vehiculos {

    boolean electrico;

    String dni;


    public boolean isElectrico(boolean b) {
        return electrico;
    }

    public void setElectrico(boolean electrico) {
        this.electrico = electrico;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Coches(String matricula, String marca, String modelo, boolean electrico, String dni) {
        super(matricula, marca, modelo);
        this.electrico = electrico;
        this.dni = dni;
    }



}