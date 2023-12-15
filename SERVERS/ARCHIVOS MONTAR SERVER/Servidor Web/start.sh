#!/bin/bash

# Ruta de los archivos .jar
ruta_jar="/var/www/vax"

# Ejecutar los archivos .jar
java -jar "$ruta_jar/serverImageGame.jar" &
java -jar "$ruta_jar/serverImageUser.jar" &
java -jar "$ruta_jar/serverZipDownload.jar" &
java -jar "$ruta_jar/serverZipUpload.jar" &
