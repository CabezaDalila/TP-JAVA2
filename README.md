
Trabajo Práctico Grupal. Desarrollo en Java Año 2023 2do. cuatrimestre

Enunciado del problema
Una empresa que organiza Ferias y Exposiciones comercializa el alquiler de los espacios (stands) de una Feria.
Se informa que:
Cada stand está identificado por un código alfanumérico unívoco, y se tienen los siguientes datos:
superficie (en mts cuadrados), precio del m2, el cliente que contrató el stand y un conjunto de accesorios contratados por el cliente.
Cada accesorio tiene un número que lo identifica, una descripción (ej: mesa, silla, TV, etc) y un precio de alquiler.
Los clientes también se identifican con un número unívoco, y se registra una descripción con el apellido y nombre o la razón social, según corresponda.
Para los stands interiores se registra la cantidad de luminarias utilizadas para iluminar el stand. El valor total del stand se calcula mediante la sumatoria de los precios de los accesorios más el precio
del metro cuadrado multiplicado por la superficie y un adicional de mil pesos por cada luminaria.
El valor total de cada stand exterior se calcula según la siguiente fórmula: superficie * precio m2 + suma precios accesorios (si se contrataron 3 o más accesorios, se aplica un descuento del 10% sobre el precio de cada accesorio)
Se solicita que el sistema:
  ● Permita cargar los datos de los stands, clientes y accesorios desde un archivo XML, JSON, o un archivo de texto delimitado por comas u otro separador.
    o Los stands deberán estar ordenados alfabéticamente por su código.
    o Deberá verificarse la validez, completitud y consistencia de los datos a cargar, emitiendo un informe con los errores encontrados.
    o Considerar que un cliente puede alquilar varios stands, y que un accesorio puede ser utilizado en varios stands.
  ● Permita la consulta de los datos completos de los stands contratados por un cliente cuyo código se solicita al operador.
  ● Genere los siguientes reportes (por pantalla y en archivos de texto):
    o Listado completo de stands ordenados descendentemente por su valor total. Al final del listado, informar valor total promedio por stand. o Listado alfabético de accesorios, detallando para cada uno el código, la descripción, el precio y la cantidad de usos en los stands.

Sugerencias y comentarios
  ● La interfaz de usuario puede ser elegida por el grupo (caracter, gráfica (Swing), web (html + Servlets ó JSP) u otra dominada por los integrantes del grupo.
  ● La persistencia debe implementarse mediante serialización (clásica o XML)
  ● Considerar:
    o el uso de las clases Containers provistas por Java (TreeSet, ArrayList, LinkedList, TreeMap) para administrar listas y conjuntos.
    o el uso de clases específicas para el manejo de los reportes.
    o el uso de Enum para los valores discretos.
    o Aplicar el lanzamiento de excepciones en las validaciones de las clases del dominio con el objetivo de desacoplarla de la Interfaz de Usuario.


● En la Entrega Final:
  o presentar, en la tarea del aula virtual, copia digital de los archivos fuentes (.java) y la documentación en HTML generada automáticamente con javadoc.
  o No se permitirán modificaciones posteriores a la entrega.
  o Todos los integrantes del grupo serán evaluados de manera individual en la clase del día posterior a la entrega grupal. Los integrantes que estén ausentes deberán recuperar esta instancia de evaluación el 29/11.
  o los docentes podrán proponer la implementación del sistema con un lote de datos propuesto por la cátedra.

● Otros conceptos que incidirán en la aprobación del trabajo práctico son:
  o Reutilización adecuada del código.
  o Eficiencia en los algoritmos (ej: búsquedas, ordenamientos)
  o Bajo acoplamiento entre interfaz y lógica de dominio
  o Empaquetamiento criterioso de las clases.
  o Utilización de operadores, métodos y técnicas propias del lenguaje Java (ej: manejo de errores con excepciones propias, métodos compareTo, toString)
  o Validaciones de ingresos de datos y consistencia de la información.
  o Código prolijo, claro y correctamente comentado. (ej: nombres representativos, crear variables e instancias necesarias, sobrecargar métodos)
  o Amigabilidad de las interfaces de usuario
