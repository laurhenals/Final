import java.text.DecimalFormat;
import java.util.Scanner;

public class ObjetoGeografico {

    static Scanner input = new Scanner(System.in);
    static CuerpoDeAgua[] cuerpo;

    public static void main(String[] args) {
        agregarDatos();
        procesosDatos();

        input.close();
    } // EndMain


    public ObjetoGeografico() {
    }

    public static void agregarDatos(){
        int cantidad = Integer.parseInt(input.nextLine());
        cuerpo = new CuerpoDeAgua[cantidad];
        for(int i=0; i<cantidad; i++){
            String datos = input.nextLine();
            String[] datosSeparados = datos.split(" ");
                cuerpo[i] = new CuerpoDeAgua();
                cuerpo[i].setNombreCuerpoAgua(datosSeparados[0]);
                cuerpo[i].setIdCuerpoAgua(Integer.parseInt(datosSeparados[1]));
                cuerpo[i].setMunicipio((datosSeparados[2]));
                cuerpo[i].setTipoAgua((datosSeparados[3]));
                cuerpo[i].setTipoCuerpo(datosSeparados[4]);
                cuerpo[i].setIrca(Double.parseDouble(datosSeparados[5]));
                cuerpo[i].setDPoblacional(Integer.parseInt(datosSeparados[6]));
            
        }
    }
    public static void procesosDatos(){
        DecimalFormat formato = new DecimalFormat("0.00");
        CuerpoDeAgua c = new CuerpoDeAgua();
        int contador = 0;
        int contador2 = 0;
        double menor = 100;
        for (CuerpoDeAgua cuerpoDeAgua : cuerpo) {
            System.out.println(cuerpoDeAgua.getNombreCuerpoAgua() + " " + formato.format(cuerpoDeAgua.getIdCuerpoAgua()));

            double nivelIRCA = cuerpoDeAgua.getIrca();
            if (c.nivel(nivelIRCA).equals("ALTO")) {
                contador += 1;
            } else if (c.nivel(nivelIRCA).equals("INVIABLEMENTE SANITARIO")) {
                contador += 1;}
        }
        System.out.println(formato.format(contador));

        for (CuerpoDeAgua cuerpoDeAgua : cuerpo) {
            double nivelIRCA = cuerpoDeAgua.getIrca();
            if (c.nivel(nivelIRCA).equals("ALTO")) {
                System.out.print(cuerpoDeAgua.getMunicipio() + " ");
            } else { contador2 += 1;}
        }
        if(contador2 == cuerpo.length){
            System.out.print("NA");}
        for (CuerpoDeAgua cuerpoDeAgua : cuerpo) {
            double nivelIRCA = cuerpoDeAgua.getIrca();
            if (nivelIRCA < menor) {
                menor = nivelIRCA;}
        }
        System.out.println();
        System.out.println(c.nivel(menor));
    }
}// EndClass

