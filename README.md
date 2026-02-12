**Generador de Array Multidimensionales (1D, 2D, 3D):** Clase para generar arrays de diferentes dimensiones basandose en las especificaciones del usuario utilizando el Scanner, mostrando en el terminal toda la estructura del array con cada direccion (index) y su respectivo valor. Aspectos del codigo:

**1 - Validacion de los inputs del usuario:**
- Los metodos `readArrayType()`, `readValueType()`, `readInteger()`, `readPositiveInteger()`, `readRandomRange()`, se encargan de comprobar y validar que los inputs son los correctos, de lo contrario, el output sera un mensaje de invalidacion y se tendran mas oportunidades para ingresar el input valido.
- Los valores ingresados pueden estar en minusculas o mayusculas (case-insensitive), y con espacios al principio o al final; los numeros enteros que se almacenaran en el array pueden ser negativos, positivos o a '0', con excepcion de los numeros al especificar la cantidad de valores (1D), filas, columnas y profundidad del array, los cuales deben ser mayores a '0'; en el rango de valores aleatorios el valor minimo no puede ser mayor que el valor maximo.
- **readArrayType()**:
  - Inputs validos: `1d, 2d, 3d`
  - Mensaje error: `Invalid array type. Enter '1d', '2d' or '3d'.`
- **readValueType()**:
  - Inputs validos: `random, custom`
  - Mensaje error: `Invalid value type. Enter 'random' or 'custom'.`
- **readInteger()**:
  - Inputs validos: `'int'`
  - Mensaje error: `Invalid value. Enter a  integer.`
- **readPositiveInteger()**:
  - Inputs validos: `'int > 0'`
  - Mensaje error: `Invalid value. Enter a positive integer greater than '0'.`
- **readRandomRange()**:
  - Inputs validos: `'int && (min <= max)'`
  - Mensaje error: `The maximum must be greater than or equal to the minimum.`

**2 - Creacion del array:**
- Los metodos `createArray`, `create1DArray`, `create2DArray`, `create3DArray`, se encargaran de crear el array segun las especificaciones del usuario y se almacenara en el 'Object' `array`, una vez el array se haya guardado se podra acceder a el mediante el metodo `getArray()`, permitiendo hacer copias del mismo, acceder a valores concretos y modificar los datos.
- **createArray()**: comprueba el array que el usuario desea crear y llama al metodo correspondiente para ello.
- **create1DArray()**: crea un array 1D retornandolo como tipo de dato int[].
- **create2DArray()**: crea un array 2D retornandolo como tipo de dato int[][].
- **create3DArray()**: crea un array 3D retornandolo como tipo de dato int[][][].
- Tipo de array a crear, mensaje de inicio: `Enter the array type to create (1d, 2d, 3d):`
  - **1d**: array de una dimension con valores.
  - **2d**: array dimensional con filas y columnas.
  - **3d**: array tridimensional con filas, columnas y profundidad.
- Valores del array a almacenar, mensaje de inicio: `Enter the value type to store (random, custom):`
  - **random**: Los valores se generaran automaticamente dentro del rango especificado por el usuario.
  - **custom**: Los valores seran ingresados manualmente por el usuario uno por uno en cada direccion (index).
- Estructura del array:
  - **1d** mensaje start: `Enter number of values:`
    - **custom**: `Enter 'int' values for the 1D array:`
    - `Enter value for index array1D[i]:`
  - **2d** mensaje start: `Enter number of rows and columns:`
    - **custom**: `Enter 'int (rows * cols)' values for the 2D array:`
    - `Enter value for index array2D[row][col]:`
  - **3d** mensaje start: `Enter number of rows, columns and depth:`
    - **custom**: `Enter 'int (rows * cols * depth)' values for the 3D array:`
    - `Enter value for index array3D[row][col][dep]:`
  - **random** mensaje start: `Enter the minimum and maximum value for the random numbers:`

**3 - Visualizacion del array:**
- Los metodos `displayArray()`, `print1DArray()`, `print2DArray()`, `print3DArray()`, se encargaran de mostrar el array en el terminal con la estructura correspondiente segun el tipo de array con sus respectivas direcciones y valores almacenados.
- **displayArray()**: comprueba el array que el usuario quiere mostrar y llama al metodo correspondiente, tambien muestra una lista con las caracteriasticas del array, todos los arrays empezando con: `Array type: 'String', Value type: 'String'`
  - **1d** lista: `Number of values: 'int'`
  - **2d** lista: `Rows: 'int', Columns: 'int', Values: 'int'`
  - **3d** lista: `Rows: 'int', Columns: 'int', Depth: 'int', Values: 'int'`
  - **random**: `Range: 'int'|'int'`
- **print1DArray()**: muestra el array 1D con el formato `array1D[i]: 'int'`
- **print2DArray()**: muestra el array 2D con el formato `array2D[row][col]: 'int'`, separando cada fila.
- **print3DArray()**: muestra el array 3D con el formato `array3D[row][col][depth]: 'int'`, separando cada fila y columna.

**4 - Guardado del array:**
- La clase `MultiDArray` que hereda a la clase `MultiDArrayGenerator`, se empleara para crear los objectos que almacenaran los arrays creados con el metodo `createArray()`. Una vez se hayan creado los objetos pertenecientes a la subclase `MultiDArray`, el metodo `getArray()` se encargara de hacer copias de los objetos creados guardandolos en otro objecto con la referencia 'Object', y con los metodos `convert1DArray()`, `convert2DArray()`, `convert3DArray()` , se podran convertir los objectos a su correspondiente tipo de array, permitiendo asi, acceder a valores concretos y modificar los datos de cada direccion.
- **getArray()**: devuelve el array creado como tipo de dato 'Object'.
- **convert1DArray()**: castea el objeto a un array de tipo int[] y retorna el array 1D.
- **convert2DArray()**: castea el objeto a un array de tipo int[][] y retorna el array 2D.
- **convert3DArray()**: castea el objeto a un array de tipo int[][][] y retorna el array 3D.
