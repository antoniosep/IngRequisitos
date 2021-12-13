package Modelo;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.Component;
import java.nio.file.*;
import javax.swing.JFileChooser;

public class GuardarInforme {

    private String texto;
    private String nombre;

    public GuardarInforme(String txt,String name){
        this.texto=txt;
        this.nombre=name;

    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void ejecutar(String txt, String nombre) throws IOException {

        if(nombre==null || nombre.length()==0){
            nombre="informe";
        }
        if(txt==null || txt.length()==0){
            txt="vacio";
        }

        String filepath="none";
        String archivo=nombre+".csv";
        Path path = Paths.get("");
        String origen = path.toAbsolutePath().normalize().toString();
        origen=origen+"\\"+archivo;
        filepath=explorer();
        if(filepath!="none") {
            filepath=filepath+"\\"+archivo;

            GuardarCrear(txt, archivo);
            //System.out.println("Origen:"+origen);
            //System.out.println("Destino:"+filepath);
            moverArchivo(origen, filepath);
            //System.out.println("hola");
    }}


    public static void GuardarCrear(String txt,String archivo){

        try{
            FileWriter fw=new FileWriter(archivo,true);
            BufferedWriter bw= new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(txt);
            pw.flush();
            pw.close();

            JOptionPane.showMessageDialog(null,"Archivo guardado");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public  static String explorer(){

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        Component parent = null;
        int aux = chooser.showSaveDialog(parent);
        String path="none";
        if (aux == JFileChooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().getPath();

        }
        return path;
    }

    public static void moverArchivo(String origen, String destino) throws IOException {

        Path mover = Files.move(Paths.get(origen),Paths.get(destino));
        /*
        if(mover != null) {
            System.out.println("File renamed and moved successfully");
        } else {
            System.out.println("Failed to move the file");
        }
        */

    }

}
