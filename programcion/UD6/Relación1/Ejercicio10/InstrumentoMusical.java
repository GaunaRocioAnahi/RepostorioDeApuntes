
/// lo declaramos con la palabra clave interface, y no "class".
/// Los metodos NO tienen cuerpo 
/// por defecto son public y abstract.

public interface InstrumentoMusical {
    void tocar(String nota);
    void afinar( int frecuencia);
    void mostrarInformacion(String tipo); 
}