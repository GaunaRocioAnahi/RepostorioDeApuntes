#SSH
para usar `sudo apt install openssh-server`
para `ifcong`
 ssh alumno@192.168.1.50 ejmplo
 contraseña y listo

192.168.1.205 IP jorge.
`sudo service ssh status`


script para apagar
 crear un directorio con un script con sudo shutdown 
```bash
#!/bin/bash

sudo shutdown -h now
```
para pararlo

```bash
etc/ssh 
cd ssh
ls
sudo nano sshd_config
```
luego en usuario vamos a quitarle la almohadilla 
Password authentication no 
para no conectarse por contraseña al otro ordenador. 


para meternos en la terminal del otro ordenador seria : 
en:

``` bash
 administrador$ scp `log2.txt alumnoT@192.168.1.IP`: ruta ejemplo /home/alumnoT/Descargas
 ```

 te despues te pide el password: 


TCP. tiene 4 capa, la mas de abajo es la que esta cerca de hardware.

- (la de mas abajo mas cercada al hardware) Capa fisica. : se encarga de enviar. cables nodos. se encarga de la conexion, que funcione. para poder leer. 

- Capa de red.: Encargada de interactual con la red. tranmision de paquetes y enrutamiento a traves de multiples redes.

- Capa transporte.: define como va a hacer la conexion. si es TCP O UDP. orientada a transmision.
-  
- Capa de aplicacion. : Proporciona servicios de la red a la aplicaciones del usuario(HTTP, FTP, SSH).





Ejericio 2. 
TRAMA A PAQUETES.
mas abajo de las capas mas espacio cabe. (mas grande); 





# lo visto en la unidad: 

  ssh: Security shell.
  scp: Secure copy protocol.
  tcp: transmision control Protocol.
  Ip:   Internet protocol.
  udp:  User datagra,  protocol. 
  ftp: file tranfer protocol. 
  sql: Query lenguaje. 




  ## FTP: 

   en terminal `sudo atp install vsftpd` para instalar FTP. 




## ejercicios de practica:

* Fórmulas para los Ejercicios:
Para resolver los problemas de transmisión, necesitas distinguir entre lo rápido que pones datos en el cable (ancho de banda) y lo rápido que viaja la señal (velocidad de propagación).

# A. Variables
* T tras= ( tiempo de transmision): Tiempo que tarda el dispositivo en escupir todos los bits al medio.
* T prop= (Tiempo de propagacion): Tiempo que tarda el primer bit en viajar de un punto A a B. 
* V(velocidad de la señal):
   - cabels de fibra/cobre: Aprox 200.000Km/s(2*10^8 m/s).
   - Aire/Radio (torres): aprox. $300.000$ km/s (3 * 10^8 m/s, velocidad de la luz).

# B. Formulas:

* tiempo de transmision: 
  
  T trans = Tamaño del paquete (bits) / Ancho de Banda (bits/s)

  (Recorda multiplicar Bytes x 8 para obtener bits)

* Tiempo de propagacion: 

 T prop = Distancia(m) / Velocidad ( m/s)


* Eficiencia( carga util): Determina que porcentaje del trafico es realmente datos de usuario y no cabeceras. 
 
Eficiencia = Datos de Aplicacion /  Datos + Cabeceras Totales

**Resolucion de Ejercicios**

 - Ejercicio 1: Tamaño de cabeceras: 

Pregunta: Sistema de 7 capas, mensaje de 1000 Bytes, cada capa añade 64 Bytes. Ancho de banda 400 Kbps.

* Calculos de la fraccion (Eficiencia):
   * Datos utiles ( M) = 1000 Bytes.
   * Cabeceras totales (Htotal) = 7 capas x 64 Bytes/capas = 448 Bytes.
   * Tamaño total del paquete = 1000 + 448 = 1448 Bytes.
   * Fraccion util : 1000/1448 = 0.69.
   * Respuestas: El 69% del ancho de banda llana con informacion de la aplicacion. 
  
 - Ejercicio 2. Transmision (Torras a 15Km):
   
  -Datos:
  - Archivos 2000 Bytes.
  - Paquetes: 1000 Bytes (Asumimos que esto es payload o datos por paqutes para simplificar o tamaño total. Dado el contexto academico habitual: 2000 B archivos --> 2 paquetes de 1000 B de datos c/u).
  - Cabeceras: 50 Bytes por paquete.
  - Paquete de confirmación (ACK): Solo cabecera (50 Bytes).
  - Enlace: 120 Mbps(120*10^6 bps).
  - Distancia: 15Km ( 15.000 m).
  - Velocidad (v): Al ser torres, asumimos C= 3*10^8 m/s.
  
  Calculos previos:

  - Tamaño Paquetes Total (Datos + Header) = 1000 + 50 = 1050 Bytes = 8400bits.
  - Tamaño ACK = 50 Bytes = 400 bits.
  - T trans_paquete= 8400/ 120*10^6 = 0,00007 s(70us).
  - T trans_ack = 400 / 120*10^6= 0,0000033 s (3,3us).
  - T prop= 15000 / 300.000.000= 0,00005 s ( 50us).
- 
Respuestas:
1. ¿Cuánto tardaremos en enviar el primer paquete? (Se refiere a ponerlo en la línea, o hasta que llega).
Solo ponerlo en el cable: 70 us.
Hasta que llega al destino (Ttrans + Tprop): 70 + 50 = 120 us (0,00012 s).
2. Tiempo total hasta recibir confirmación de todos (Stop-and-Wait):
   - Secuencia: Envío P1 --> Viaje P1 --> Envío ACK1 --> Viaje ACK1 --> Envío P2...
   - Ciclo por paquete =  T trans_pkt + T prop + T trans_ask + T prop.
   - Ciclo = 70+50+3.3+50= 173.3us
   - como son dos paquetes (2000 B total / 1000 B datos ): 173.3 *2 = 346.6 us.
  Respuesta: 0.0003466 segundos. 


* Ejercicio 3 : Direccionamiento IP (Subnetting):
  
  Red : 192.170.0.0/ 24  Objetivo: 3  subredes lo mas grandes posible.

  1 - Crear 3 subredes: 
   - Para tener 3 subredes, necesitamos pedir prestados bits de host Con 1 bit( 2^1 = 2) no basta. con 2 bits (2^2 = 4)  tenemos suficiente. 
   - Nueva máscara: /24 + 2 = /26 (255.255.255.192).
   - Esto crea 4 bloques de 64 direcciones (62 útiles). Usaremos las 3 primeras.
  Las Subredes (usando /26):

Subred A: 192.170.0.0 /26 (Rango: .0 - .63)

Subred B: 192.170.0.64 /26 (Rango: .64 - .127)

Subred C: 192.170.0.128 /26 (Rango: .128 - .191)


2 - Asignar 3 IPs en cada subred:

Subred A: 192.170.0.1, 192.170.0.2, 192.170.0.3

Subred B: 192.170.0.65, 192.170.0.66, 192.170.0.67

Subred C: 192.170.0.129, 192.170.0.130, 192.170.0.131

3- Definir 2 subredes más dentro de una (Subnetting VLSM):

Tomamos la Subred C (192.170.0.128 /26) y la dividimos en 2.

Pedimos 1 bit más: Máscara /27.

Subred C1: 192.170.0.128 /27 (30 hosts)

Subred C2: 192.170.0.160 /27 (30 hosts)


**Otros Ejemplos**

Para conectar necesitamos el comando ssh seguido del usuario y la IP. Una vez dentro, usas mkdir para crear el directorio. 

comando 
```bash
#1 Conexion al servidor
ssh alumnoT@192.168.1.179
# CONTRASEÑA. 
# Creamos la carpeta en el home (~)
mkdir "Nombre Apellido"
```
es importantes la comillas si el nombre contiene espacios. 

1.2. Copia de repositorio con SCP
Para copiar una carpeta completa (repositorio) desde tu máquina local al servidor remoto, se usa scp con la opción -r (recursivo). Debes ejecutar esto desde tu máquina local, no desde dentro del servidor.

```bash
scp -r /ruta/a/tu/repositorio alumnoT@192.168.1.179:"~/Nombre\ Apellido/"

```
2.1. Problema 1: Eficiencia y Velocidad Real
A- Expresión General :La fracción del ancho de banda útil (eficiencia) se calcula dividiendo los datos "reales" (carga útil) entre el tamaño total del paquete transmitido (datos + todas las cabeceras).
Tamaño del Mensaje (Datos): M (o H según la imagen).
Tamaño de Cabeceras Totales: n \ h (donde n es el número de capas y h el tamaño de cabecera por capa).
Tamaño Total Paquete: M + (n \ h).
 
 fraccion Util = M / M + (n.h)

 Datos:
  Ancho de banda R = 500Kbps
  Datos (M) : 1300 Bytes.
  Capas (n) : 4.
  Cabeceras por capa (h): 100 Bytes

  eficiencia:

  cabeceras total: 4 capas * 100 Bytes = 400 Bytes.
  Tamaño total paquetes: 1300 + 400 = 1700 Bytes.
  Eficiencia : 1300/ 1700 = 0.7647( 76.47%)

  velocidad real: multiplicamos el ancho de banda por eficiencia. 

  500 Kbps * 0.7647 = 382, 35 Kbps.

  Problema 2: Tiempos de Transmisión
Datos:
Archivo: 3000 KB. (Asumimos 1 KB = 1024  Bytes -->3000 * 1024 = 3.072.000 Bytes).
Paquete total : 1200 Bytes.
Cabeceras : 80 Bytes.
Payload (datos por pqtes): 1200 - 80 = 1120 Bytes
Enlaces : 180 Mbps (180.000.000 bps).
Distancia : 32Km (32.000m)
Velocidad señal: 300.000 km/s (3*10^8m/s al ser torres).

calculos numeros de pquetes y teimpo basico. 
 1. Numero de paquetes 
    3.072.000 Bytes TOTALES / 1120 Bytes utiles = 2742.85 --> 2743 paquetes.

2. T prop
   
   Tprop = 32000m / 300.000 m/s = 0.0001066 s (106.6 us)
3. Tiempo de transmision
   

   Ttrans_pkt = 1200 *8 bits / 180*10^6 bps = 9600/180.000.000 = 0.0000533 s (53.3us)

4. Tiempo de transmision ack (Ttrans_ack):( el ACK son solo cabeceras de 80 Bytes)
   
   Ttrans_ack = 80*8bits/ 180*10^6bps = 0.0000035s (3.5us)

   a. ¿Cuánto tiempo esperar como mínimo (Timeout) para reenviar? El temporizador debe ser mayor que el tiempo que tarda el paquete en ir y la confirmación en volver (RTT).

   RTT = Ttrans_pkt + Tprop + Ttrans_ack + Tprop

   RTT = 53.3 +106.6+03.5+0106.6 = 270 US = 0.27 ms

   respuesta deberia esperar algo mas de 0.27ms 
   b. ¿Tiempo total para recibir confirmación de todos? Asumiendo un protocolo de parada y espera (Stop-and-Wait) donde enviamos uno, esperamos ACK, enviamos el siguiente:
    
    TiempoTotal = Nº Pquetes * RTT

    Tiempo Total = 2743 * 0.00027S = 0.74 SEGUNDOS




    para no hacerlo manualmente: 

```bash
#!/bin/bash

# 1. Definimos las variables (IP, Usuario y Tu nombre)
IP="192.168.1.179"
USUARIO="alumnoT"
# IMPORTANTE: Pon tus nombres reales aquí dentro de las comillas
NOMBRE_CARPETA="Nombre Apellido"
# Pon aquí la ruta real de tu carpeta de sistemas en TU ordenador
RUTA_LOCAL="/home/usuario/sistemas_informaticos"

echo "--- Paso 1: Conectando y creando carpeta remota ---"
# Esta linea se conecta y ejecuta el mkdir directamente en el otro PC
ssh $USUARIO@$IP "mkdir -p '$NOMBRE_CARPETA'"

echo "--- Paso 2: Copiando repositorio con SCP ---"
# Esta linea copia tu carpeta local a la carpeta nueva remota
scp -r "$RUTA_LOCAL" $USUARIO@$IP:"'$NOMBRE_CARPETA'/"

echo "--- ¡Tarea completada! ---"

```
```bash 

cat ejercicio_copia.sh
```
```bash
chmod +x ejercicio_copia.sh
./ejercicio_copia.sh
```

```bash 
#!/bin/bash

# 1. Definimos la IP y el Usuario del ordenador remoto
IP="192.168.1.179"
USUARIO="alumnoT"

echo "Conectando con $IP para apagar el sistema..."

# 2. El comando MÁGICO.
# ssh conecta -> le pasa el comando entre comillas -> shutdown apaga el OTRO PC.
# -h significa 'halt' (detener/apagar)
# now significa 'ahora mismo'
ssh -t $USUARIO@$IP "sudo shutdown -h now"

```
damos permiso con chmod +x nombredelscript.sh 
./nombredelscrip.sh --> para ejecutarlo