public class Autobus extends Vehiculos {

    int numero_plazas;
    String compañía;

    public int getNumero_plazas() {
        return numero_plazas;
    }

    public void setNumero_plazas(int numero_plazas) {
        this.numero_plazas = numero_plazas;
    }

    public String getCompañía() {
        return compañía;
    }

    public void setCompañía(String compañía) {
        this.compañía = compañía;
    }

    public Autobus(String matricula, String marca, String modelo, int numero_plazas, String compañía) {
        super(matricula,marca,modelo);
        this.numero_plazas = numero_plazas;
        this.compañía = compañía;
    }

}
