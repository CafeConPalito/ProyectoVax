/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.socket;

import com.cafeconpalito.proyectovax.EntryPoint;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Collections;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.*;

/**
 *
 * @author damt207
 */
public class SocketZipGameDownload implements Runnable {

    private Socket servidor;
    private static final int PUERTO = 6663;

    private String gameName;
    private String dirGames = "games";

    public SocketZipGameDownload(String gameName) {
        this.gameName = gameName;
        run();
    }

    @Override
    public void run() {
        
        String zipFilePath = null;

        //Creo la carpeta Games si no existe
        File f = new File(dirGames);
        if (!f.isDirectory()) {
            f.mkdir();
        }

        //Ruta de la carpeta para el juego
        String dirGamesGame = dirGames + File.separator + gameName;

        //Creo la carpeta del juego para almacenarlo
        File fg = new File(dirGamesGame);
        if (!fg.isDirectory()) {
            fg.mkdir();
        }

        BufferedOutputStream bos = null;
        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;
        try {

            servidor = new Socket(EntryPoint.serverIP, PUERTO);

            this.servidor.setSoLinger(true, 10);

            bufferDatosEntrada = new DataInputStream(servidor.getInputStream());
            bufferDatosSalida = new DataOutputStream(servidor.getOutputStream());

            // ENVIAR AL SERVER EL NOMBRE DEL JUEGO A DESCARGAR
            String nombreArchivo = gameName + ".zip";
            bufferDatosSalida.writeUTF(nombreArchivo);

            zipFilePath = dirGamesGame + File.separator + nombreArchivo;

            bos = new BufferedOutputStream(new FileOutputStream(zipFilePath)); // pongo el nombre.

            byte[] bufferEntrada = new byte[1024];

            int numBytesLeidos = bufferDatosEntrada.read(bufferEntrada);

            while (numBytesLeidos != -1) {

                bos.write(bufferEntrada, 0, numBytesLeidos);
                // 2 * recibo el paquete de datos
                numBytesLeidos = bufferDatosEntrada.read(bufferEntrada);

            }

        } catch (IOException ex) {
            Logger.getLogger(SocketZipGameDownload.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (bufferDatosEntrada != null) {
                    bufferDatosEntrada.close();
                }
                if (bufferDatosSalida != null) {
                    bufferDatosSalida.close();
                }
                servidor.close();
            } catch (IOException ex) {
                Logger.getLogger(SocketZipGameDownload.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        descomprimirZip(zipFilePath, dirGamesGame);
        borrarZip(zipFilePath);
        
    }

    public void  borrarZip(String zipFilePath){
        File f = new File(zipFilePath);
        if (f.exists()) {
            f.delete();
        }
    }
    
    
    public static void descomprimirZip(String zipFilePath, String directorioDestino) {
        byte[] buffer = new byte[1024];
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath))) {
            // Recorrer cada entrada en el archivo ZIP
            ZipEntry ze = zis.getNextEntry();
            while (ze != null) {
                String nombreArchivo = ze.getName();
                File nuevoArchivo = new File(directorioDestino + File.separator + nombreArchivo);
                // Si la entrada es un directorio, crearlo
                if (ze.isDirectory()) {
                    nuevoArchivo.mkdirs();
                } else {
                    // Si la entrada es un archivo, asegurarse de que el directorio padre exista
                    File directorioPadre = nuevoArchivo.getParentFile();
                    if (!directorioPadre.exists()) {
                        directorioPadre.mkdirs();
                    }
                    // Escribir el archivo
                    try (FileOutputStream fos = new FileOutputStream(nuevoArchivo)) {
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }
                // Cerrar la entrada actual y avanzar a la siguiente
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    /*
    private static void unzip(String zipFilePath, String destDirPath) {
        try {

            File destDir = new File(destDirPath);

            byte[] buffer = new byte[1024];
            ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath));
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                File newFile = newFile(destDir, zipEntry);
                if (zipEntry.isDirectory()) {
                    if (!newFile.isDirectory() && !newFile.mkdirs()) {
                        throw new IOException("Failed to create directory " + newFile);
                    }
                } else {
                    // fix for Windows-created archives
                    File parent = newFile.getParentFile();
                    if (!parent.isDirectory() && !parent.mkdirs()) {
                        throw new IOException("Failed to create directory " + parent);
                    }

                    // write file content
                    FileOutputStream fos = new FileOutputStream(newFile);
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    fos.close();
                }
                zipEntry = zis.getNextEntry();
            }

            zis.closeEntry();
            zis.close();
        } catch (IOException ex) {
            Logger.getLogger(SocketZipGameDownload.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }

    */
    
    /*
    private void unzip2(String zipFilePath, String destDirPath) {
        try {
            int BUFFER = 1024;
            File dirDestino = new File(destDirPath);
            BufferedOutputStream dest = null;
            FileInputStream fis = new FileInputStream(zipFilePath);
            ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
            FileOutputStream fos = null;
            ZipEntry entry;
            int count;
            int index = 0;
            byte data[] = new byte[BUFFER];
            String rutaarchivo = null;
            while ((entry = zis.getNextEntry()) != null) {
                System.out.println("Extracting: " + entry);
                rutaarchivo = entry.getName();
                // tenemos que quitar el primer directorio
                index = rutaarchivo.indexOf(File.separator);
                rutaarchivo = rutaarchivo.substring(index + 1);
                if (rutaarchivo.trim().length() > 0) {
                    // write the files to the disk
                    try {
                        dest = null;
                        File fileDest = new File(dirDestino.getAbsolutePath() + File.separator + rutaarchivo);
                        if (entry.isDirectory()) {
                            fileDest.mkdirs();
                        } else {
                            if (fileDest.getParentFile().exists() == false) {
                                fileDest.getParentFile().mkdirs();
                            }

                            fos = new FileOutputStream(fileDest);
                            dest = new BufferedOutputStream(fos, BUFFER);
                            while ((count = zis.read(data, 0, BUFFER)) != -1) {
                                dest.write(data, 0, count);
                            }
                            dest.flush();
                        }
                    } finally {
                        try {
                            if (dest != null) {
                                dest.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            zis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */

    /*
    public void decompress(String zipFilePath) {
        try {
            ZipFile zf = new ZipFile(new File(zipFilePath));
            try (zf) {
                Enumeration<? extends ZipEntry> entries = zf.entries();
                for (ZipEntry ze : Collections.list(entries)) {
                    System.out.printf("Inflating %s (compressed: %s, size: %s, ratio: %.2f)%n", ze.getName(), ze.getCompressedSize(), ze.getSize(), (double) ze.getSize() / ze.getCompressedSize());
                    InputStream is = zf.getInputStream(ze);
                    FileOutputStream fos = new FileOutputStream(new File("target", ze.getName()));
                    try (is; fos) {
                        fos.write(is.readAllBytes());
                    }
                }
            }
        }   catch (IOException ex) {
            Logger.getLogger(SocketZipGameDownload.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     */
 /*
    private void unzip(String zipFilePath, String destDir) {
        File dir = new File(destDir);
        // create output directory if it doesn't exist
        if(!dir.exists()) dir.mkdirs();
        FileInputStream fis;
        //buffer for read and write data to file
        byte[] buffer = new byte[1024];
        try {
            fis = new FileInputStream(zipFilePath);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while(ze != null){
                String fileName = ze.getName();
                File newFile = new File(destDir + File.separator + fileName);
                System.out.println("Unzipping to "+newFile.getAbsolutePath());
                //create directories for sub directories in zip
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
                }
                fos.close();
                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            //close last ZipEntry
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
     */
 /*

    private void unzip(String zipFilePath, String destDir) {
        File dir = new File(destDir);
        FileInputStream fis = null;
        ZipInputStream zis = null;
        FileOutputStream fos = null;
        //buffer for read and write data to file
        byte[] buffer = new byte[1024];

        try {
            fis = new FileInputStream(zipFilePath);
            zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while (ze != null) {
                String fileName = ze.getName();
                File newFile = new File(destDir + File.separator + fileName);
                
                System.out.println("Unzipping to " + newFile.getAbsolutePath());
                
                //create directories for sub directories in zip
                new File(newFile.getParent()).mkdirs();
                fos = new FileOutputStream(newFile);
                int len;
                
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();
            }

        } catch (IOException ex) {
            Logger.getLogger(SocketZipGameDownload.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (zis != null) {
                    zis.closeEntry();
                    zis.close();
                }
                        
                if (fos != null) {
                    fos.close();
                }
                
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(SocketZipGameDownload.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
     */
    
    
    
    
}
