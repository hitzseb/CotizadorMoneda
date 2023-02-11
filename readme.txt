Desarrollar dos servicios web que haran lo siguiente:


	1) Realizaran la conversion entre dos monedas pasandole los siguientes parametros:

		monedaFrom ---> ejemplo ARS
		monedaTo ---> ejemplo U$S
		monto ---> la cantidad de monedaFrom a ser transformada a monedaTo
	
		devuelve el valor en monedaTo
	

	2) Tasa de variacion entre dos tipos de cambio pasandole los siguientes parametros:

		monedaFrom ---> Ejemplo ARS
		monedaTo ---> Ejemplo US$
	
		devuelve el porcentaje de variacion que sufrio monedaTo indicandola con un signo + o -
		
		
Links de prueba:

	http://localhost:8080/comprar?monto=100&from=1&to=2
	
	http://localhost:8080/vender?monto=100&from=2&to=1
	
	http://localhost:8080/tasaDeVariacion?from=1&to=2