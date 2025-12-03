
/**
 * genera una variable de usuario
 * @type {string} identifica que es esa variable es para escribir un string, no puede recibir numeros
 */
const fullName = "Rayan Ray"

//---------


/**
 * @Ts_check
 * analiza el codigo par aque respete si se uno es tipo string o tipo number " busca el error!" sirve para corregir numero. lo vamos a colocar arrib de todo. 
 */

//-------
//------- docs js.  arrays 



/**
 * lista de edades de ususarios
 * @type {array} para todo tipo de de array cualquier sea el dato
 *  */
let edades = [19, 20, 30, 100, {}, true,]


/** 
 * array de puntajes. 
 * @type {arrays<Number>} para que acepte numeros*/

let puntajes = [10, 199.7, 99]
/**  
 * array de puntajes y "string" 
 * @type {arrays<Number | string>} admite Numeros y strings 
 * */

let puntajesYstring = [10, "10", 20, "300"]
/**
 * array de nombres
 * @type { arrays<String>}admite solo strings.
 *  */
let nombres = ["nombres", "nombres2"]


//------ Para objetos-----


/**
 * @type {{id:number, primerNombre: string, ultimoNombre: string, anio: number}};
 * 
 */
let persona = {
    id: 1,
    primerNombre: "Ryan",
    ultimoNombre: "Ray",
    anio: 20
}
/**
 * @type {{ Id: number | string, primerNombre: string, ultimoNombre: string, anio: number | string}}
 * 
 */
let persona2 = {
    id: 1,
    primerNombre: "Ryan",
    ultimoNombre: "Ray",
    anio: 20
}


//--------- FUNCIONES-----

/**
 * Añade 2 numeros
 * @param {number} n1 primerNumero
 * @param {number} n2 segundoNumero
 * @returns {number} puede ser el numero o el {void} que es vacio. va el total del resultado
 */
function aniadir(n1, n2) {
    return n1 + n2
}

// para repetir datos y especificarlo solo son typedef, es una definicion, no tiene orden especifica,  
/**
 * Usario 
 * @typedef {object} user
 * @property {number} id user id
 * @property {string} nombre user id
 * @property {number} anio user id
 * 
 */











