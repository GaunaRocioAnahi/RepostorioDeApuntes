package programcion.UD5.Relacion1;

public class Ejercicio6 {

    public static void main(String[] args) {
        Reloj reloj =new Reloj(14, 30, 45);
        reloj.sumarMinutos(35);
        System.out.println("Después de sumar 35 minutos: " + reloj);
        
        reloj.sumarSegundos(90);
        System.out.println("Después de sumar 90 segundos: " + reloj);
        
        reloj.restarMinutos(20);
        System.out.println("Después de restar 20 minutos: " + reloj);
        
        reloj.restarSegundos(60);
        System.out.println("Después de restar 60 segundos: " + reloj);

    }
}

class Reloj {
    // atributos
    int hora;
    int minuto;
    int segundo;

    // constructor
    Reloj(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    // metodo toString() - formato hh:mm:ss

    // Metodo para sumar con sumarMinutos

    void sumarMinutos(int minutos) {
        this.minuto += minutos;

        // si los numeros superan 59, ajustamos la hora.

        while (this.minuto >= 60) {
            this.minuto -= 60;
            this.hora++;
            // si las horas superan 23, volver a 0
            if (this.hora >= 24) {
                this.hora = 0;
            }
        }
    }

    // metodo para restar los minutos
    void restarMinutos(int minutos) {
        this.minuto -= minutos;

        // si los minutos son negaticos, ajustar horas

        while (this.minuto < 0) {
            this.minuto += 60;
            this.hora--;
            // si las horas son negativas, volver a 23
            if (this.hora < 0) {
                this.hora = 23;
            }

        }

    }

    // metodo para sumar segundos
    void sumarSegundos(int segundos) {
        this.segundo += segundos;
        // si los segundos seuperan los 59, ajustar minutos

        while (this.segundo >= 60) {
            this.segundo -= 60;
            this.minuto++;

            // si los minutos superan 59, ajustar horas
            if (this.minuto >= 60) {
                this.minuto = 0;
                this.hora++;

                // si las horas superan 23, volver a 0
                if (this.hora >= 24) {
                    this.hora = 0;
                }
            }
        }
    }

    // metodos para restar segundos
    void restarSegundos(int segundos) {
        this.segundo -= segundos;

        // si los segundos son negativos, ajustar minutos

        while (this.segundo < 0) {
            this.segundo += 60;
            this.minuto--;

            // Si los segundos son negativos, ajustar horas.

            if (this.minuto < 0) {
                this.minuto = 59;
                this.hora--;

                // si las horas son negativas, volver a 23
                if (this.hora < 0) {
                    this.hora = 23;
                }

            }
        }

    }

}