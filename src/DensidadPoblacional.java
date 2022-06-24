public class DensidadPoblacional extends ObjetoGeografico {
    
    public DensidadPoblacional() {
        super();
    }

    public int afeccion(int poblacion) {
        int afeccion = 0;
        if(poblacion < 10000) {
            afeccion = 0;
        } else if(poblacion >= 10000 && poblacion <= 50000) {
            afeccion = 1;
        } else if(poblacion > 50000) {
            afeccion = 2;
        }
        return afeccion;
    }
}
