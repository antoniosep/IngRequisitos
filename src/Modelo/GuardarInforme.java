package Modelo;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.Component;
import java.nio.file.*;
import javax.swing.JFileChooser;

public class GuardarInforme {

    public static void main(String[] args) throws IOException {

        String txt="a tope jefe de equipo";
        String filepath="none";
        String archivo="e2.csv";
        Path path = Paths.get("");
        String origen = path.toAbsolutePath().normalize().toString();
        origen=origen+"\\"+archivo;
        filepath=explorer();
        if(filepath!="none") {
        filepath=filepath+"\\"+archivo;

            GuardarCrear(txt, archivo);
            System.out.println("Origen:"+origen);
            System.out.println("Destino:"+filepath);
            moverArchivo(origen, filepath);
            //System.out.println("hola");
        }
    }

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
