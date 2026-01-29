# flexBox :
 
 el eje horizontal se controla con `justify-content.`

A la izquierda (por defecto );
 ``` css
.contenedor{
    display: flex;
  justify-content: flex-start;
}
 ```

Centrados. 

```css
  display: flex;
  justify-content: center;
```

A la derecha:

```css
  display: flex;
  justify-content: flex-end;
```

espacios entre elementos:

```css
.contenedor {
  display: flex;
  justify-content: space-between;
}

```

Espacio Uniforme. 

```css
.contenedor {
  display: flex;
  justify-content: space-around;
}

```