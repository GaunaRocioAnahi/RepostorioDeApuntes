regla mental: 
- Bits + velocidad --> transmision
- Distancia --> Propagacion
- Numero de paquetes --> tiempo total. 


*PARA ENVIOS DE bits*

ejemplo ¿cuantos bits tengo que enviar?.

Formula. 

Datos = pixeles * bits por pixel.

1920 *1080 = 2073600 pixeles
2073600pixeles * 32 = 66355200 bits (es lo que viaja por la red.)

**preguntaClave** **¿cuantos datos hay?**


*Cuantos paquetes necesito*

ejemplo:
¿puedo mandar todo de una vez o tengo que dividirlo?

datos por paquetes: 

4MB-50KB = 3.95MB

NUMERO DE PAQUETES : 

7.9MB/3.95MB = 2 PAQUETES

Conclusion: esto afecta al tiempo total, porque cada paquete necesita confirmacion.

*tiempo de transmision*

¿cuanto tardo en meter los bits en el cable?

usar esta formula cuando te dan la velocidad --> siempre la usa.

`Ttrans= bits/ velocidad`

Aplicacion:

4MB = 32*10^6 bits

Tt= 32*10^6bits / 10^9 = 0.032s resultado Tt= 32ms

**preguntaClave** **Si te dan velocidad** 

*tiempo de propagacion*

¿cuanto tiempo tarda la señal en recorrer la distancia?

usar cuando te dan kilometros o metros, siempre hay propagacion.

`Tprop = distancia / velocidad de propagacion `=

Aplicacion: 
Tprop= 80000 / 2*10^8 = 0.0004s resultado Tprop= 0.4ms

**preguntaClave** **si te dan distancia** 

*tiempo desde que empiezo a emitir hasta que llega a la ultima confimacion*

**si hablan de confirmacion**

significa:
envio de paquete.
viaja
llega
vuelve ACK
eso es un RTT 

formula de RTT =Tt + 2Tprop

RTT= 0.320 + 2 ( 0.0004) = 0.0328s respuesta 32.8ms por paquete

como hay 2 paquetes: 
**Si preguntan tiempo total**
Ttotal = 2* RTT = 0.0656s  respuesta tiempo total = 65.6ms

*timepo minimo de confirmacion antes de reenviar?*

significa cuanto espero antes de pensar que el paquete se perdio.


Regla real:   Timeout  > RTT   nunca igual. Siempre mayor.

RTT = 32ms
se pone margen Timeout=40ms

-Problema1 de ejemplo:

Enunciado (Resumindo y ordenado);

Un sistema tiene una jerarquia de protocolos de 3 capas.

Las aplicaciones generan mensajes de H bytes de longitud.
En cada capa se añade una cabecera de 3 bytes.
el sistema no usa numeracion de paquetes. 
se envia una respuesta que ocupa 100bytes de cabecera. 
el enlace de 500 Kbps
el emisor envia 4 mensajes.
que velocidad real de transmision se obtiene?

**PREGUNTA CLAVE**
velocidad real de transmision. 
significa Datos utiles / tiempo total.

NO ES VELOCIDAD DEL ENLACE, ES LA VELOCIDAD EFECTIVA QUE VE LA APLICACION.

**Tamaño real de cada mensaje**

Datos utiles : mensaje de la aplicacion H bytes.

Cabeceras: 3 capas x 3 bytes = 9 bytes
Tamaño total de enviado por mensaje : H + 9 bytes.

**MENSAJES + RESPUESTA**

El sistema:
 *envia 4 mensajes
 *recibe 1 respuesta de 100 bytes

 Total bytes transmitidos
 4(H +9 )+ 100

 **Pasar a bits**
las velocidades siempre estan a bits/s (b/s).
 bits = 8 x [4(H+9)] + 100

**Tiempo total de transmision**

velocidad de enlace:
50kbps = 500 000 bits/s

formula del tiempo = 

`T= bits transmitidos/ velocidad del enlace`

T= 8[4(h+9)+100] / 500.000

**velocidad real (pedida)**

Definicion 

`Velocidad real = datos utiles / tiempo total `

Datos utiles
solo cuenta lo que general la aplicacion:

4H bytes = 32H bits

Vreal = 32H / TIEMPO TOTAL DE TRANSMISION.
sustituimos:
V real = 32 H / 8[4(h+9)+100] / 500.000

**respuesta del problema** V real = 2.000.000H / 4 H + 136 bits /s

conclusion las cabeceras reducen la velocidad real. 
cuanto mas pequeño es H, peor eficiencia.
La velocidad real siempre es menor que la del enlace

**otro**




Parte B: Aplicación Numérica (Velocidad Real)Ahora sustituimos con los datos que te dan:Ancho de banda ($R$): $500 \text{ Kbps}$Datos útiles ($H$): $1300 \text{ Bytes}$Capas ($n$): $4$Tamaño cabecera ($s$): $100 \text{ Bytes}$1. Calculamos el tamaño total del paquete:$$Total = 1300 + (4 \text{ capas} \times 100 \text{ bytes}) = 1300 + 400 = 1700 \text{ Bytes}$$2. Calculamos la eficiencia (la fracción):$$\text{Eficiencia} = \frac{1300}{1700} \approx 0,7647$$(Esto significa que el 76,47% de la transmisión es útil).3. Calculamos la Velocidad Real:Para saber la velocidad real, multiplicamos la velocidad de la línea por la eficiencia.$$\text{Velocidad Real} = 500 \text{ Kbps} \times 0,7647$$$$\textbf{Velocidad Real} \approx \mathbf{382,35 \text{ Kbps}}$$




# Comandos 

`ssh usuario@ip` para conectarse.

pide contraseña.

ir al home:
`cd ~`

creamos un directorio: `mkdir nombre_apellido`

copiamos recursivamente el contenido de /ect.

`cp -r /etc nombre_apellido`

lo listamos `ls -R nombre_apellido` para ver todo

para borrarlo `rm -r nombre_apellido`


Para copiar el contenido de /etc con SCP
conmando completo
`scp -r usuario@IP:/etc nombre_apellido`

copiar del local al remoto

`scp archivo usuario@IP:/ruta/remota`

copiar del remoto al local
`scp usuario@IP:/ruta/remota destino_local`


**consejo**

Copiar archivos usando SCP
El enunciado continúa: "Una vez creada dicha carpeta, copia usando el comando scp tu repositorio de sistemas informáticos dentro de esta carpeta."

Importante: El comando scp se ejecuta desde tu ordenador local (no desde dentro de la conexión SSH). Si sigues conectado del paso anterior, escribe exit para salir primero o abre una terminal nueva.


orden necesaria :

`scp -r sistemas_informaticos alumnoT@192.168.1.179:~/TuNombreTuApellido/`
12