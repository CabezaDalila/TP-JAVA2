Este proyecto fue desarrollado durante la cursada de Algoritmo y Estructura de Datos 2 en la Universidad Caece, el cual  tiene como objetivo desarrollar un sistema en Java para gestionar el alquiler de stands en ferias y exposiciones.
Este sistema permite:
	1.	Gestión de datos
	•	Carga de información: Los datos de los stands, clientes y accesorios se ingresan desde un archivo (XML, JSON o texto delimitado).
	•	Validación y ordenamiento: Los datos se verifican para garantizar que sean correctos y consistentes. Además, los stands se ordenan alfabéticamente por su código.
	2.	Cálculo de costos de los stands
	•	Stands interiores: Se calcula el costo sumando el precio por m² (según la superficie), el costo de los accesorios contratados y un adicional por luminarias.
	•	Stands exteriores: Se calcula considerando la superficie, el precio por m² y los accesorios, aplicando un descuento del 10% en los accesorios si se contratan tres o más.
	3.	Consultas personalizadas
	•	Permite consultar todos los stands contratados por un cliente específico ingresando su código.
	4.	Generación de reportes
	•	Stands ordenados por valor total: Incluye el promedio de costos por stand.
	•	Accesorios: Lista alfabética con detalles como código, descripción, precio y número de usos.
	5.	Interfaz flexible y almacenamiento
	•	El sistema puede tener diferentes tipos de interfaz: de consola, gráfica (Swing) o web (HTML + Servlets/JSP).
	•	La información se almacena de manera persistente utilizando técnicas de serialización.
