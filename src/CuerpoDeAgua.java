public class CuerpoDeAgua extends ObjetoGeografico {
    private String nombreCuerpoAgua;
    private int idCuerpoAgua;
    private String municipio;
    private String tipoAgua;
    private String tipoCuerpo;
    private double irca;
    private int dPoblacional;

    
    public CuerpoDeAgua() {
        super();}
        
        public String getNombreCuerpoAgua() {return nombreCuerpoAgua;}
        public void setNombreCuerpoAgua(String nombreCuerpoAgua) {this.nombreCuerpoAgua = nombreCuerpoAgua;}
        
        public int getIdCuerpoAgua() {return idCuerpoAgua;}
        public void setIdCuerpoAgua(int idCuerpoAgua) {this.idCuerpoAgua = idCuerpoAgua;}
        
        public String getMunicipio() {return municipio;}
        public void setMunicipio(String municipio) {this.municipio = municipio;}
        
        public String getTipoAgua() {return tipoAgua;}
        public void setTipoAgua(String tipoAgua) {this.tipoAgua = tipoAgua;}
        
        public String getTipoCuerpo() {return tipoCuerpo;}
        public void setTipoCuerpo(String tipoCuerpo) {this.tipoCuerpo = tipoCuerpo;}
        
        public double getIrca() {return irca;}
        public void setIrca(double irca) {this.irca = irca;}

        public int getDPoblacional() {return dPoblacional;}
        public void setDPoblacional(int dPoblacional) {this.dPoblacional = dPoblacional;}
    
        public String nivel(double nivelIRCA) {
        String nivRiesgo = "";
        if (nivelIRCA > 0 && nivelIRCA <= 5) {
            nivRiesgo = "SIN RIESGO";
        } else if (nivelIRCA > 5 && nivelIRCA <= 14) {
            nivRiesgo = "BAJO";
        } else if (nivelIRCA > 14 && nivelIRCA <= 35) {
            nivRiesgo = "MEDIO";
        } else if (nivelIRCA > 35 && nivelIRCA <= 80) {
            nivRiesgo = "ALTO";
        } else if (nivelIRCA > 80 && nivelIRCA <= 100) {
            nivRiesgo = "INVIABLEMENTE SANITARIO";
        }
        return nivRiesgo;}

        public void guardarDatos(String nombreCuerpoAgua, int idCuerpoAgua, String municipio, String tipoAgua, String tipoCuerpo, double irca, int dPoblacional) {
            this.nombreCuerpoAgua = nombreCuerpoAgua;
            this.idCuerpoAgua = idCuerpoAgua;
            this.municipio = municipio;
            this.tipoAgua = tipoAgua;
            this.tipoCuerpo = tipoCuerpo;
            this.irca = irca;
            this.dPoblacional = dPoblacional;
        }
        public String[] consultarDatos() {
            String[] datos = {nombreCuerpoAgua, idCuerpoAgua + "", municipio, tipoAgua, tipoCuerpo, irca + "", dPoblacional + ""};
            return datos;
        }
}
