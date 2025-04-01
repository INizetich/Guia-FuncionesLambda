import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> listaNumeros = new ArrayList<>();
        List<String> listaNombres = new ArrayList<>();
        listaNombres.add("samy");
        listaNombres.add("nize");
        listaNombres.add("arian");
        listaNombres.add("tucu");
        listaNombres.add("lautaro");
        for (int i = 10; i > 0; i--) {
            listaNumeros.add(i);
            // listaNumeros.add(i);
        }


/*1.Dada una lista de números enteros, utiliza filter para
obtener solo los números pares y guárdalos en una nueva
lista.*/
        List<Integer> nuevaLista = listaNumeros.stream()
                .filter(num -> num % 2 == 0)
                .toList();
        /// guardamos los numeros pares en la lista nueva y la mostramos
        nuevaLista.forEach(System.out::println);


       /*2.Usa map para convertir cada nombre de una lista en su
versión en mayúsculas*/
        listaNombres.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);


        /*3.Usa sorted para ordenar una lista de números enteros de
menor a mayor*/

        nuevaLista.stream()
                .sorted()
                .forEach(System.out::println);

        /*4. Contar elementos mayores a un valor */

        Long cantidad = nuevaLista.stream()
                .filter(num -> num > 7)
                .count();

        System.out.println("La cantidad de numeros mayores a 7 son: " + cantidad);

        /*5 Obtener los primeros 5 elementos de una lista
        Usa limit para extraer solo los primeros 5 elementos de una lista de números.*/

        System.out.printf("Primeros cinco elementos de la lista: \n");
        nuevaLista.stream()
                .limit(5)
                .forEach(System.out::println);

        /*6. Convertir una lista de palabras en su longitud*/

        System.out.println("Palabras por cantidad: ");
        listaNombres.stream()
                .map(String::length)
                .forEach(System.out::println);

        /*7. Concatenar nombres con una separación*/

        /// PRIMER FORMA (UN POCO FALOPA)

//        String concat = listaNombres.stream()
//                .reduce("", (acumulador, nombre) ->  /// <- Identificamos que la variable es string.
//                        acumulador.isEmpty() ? nombre : acumulador + ", " + nombre ///
//                        );


        /// SEGUNDA FORMA (UN POCO MAS SIMPLE Y FACIL DE ACORDAR)
        String concat = listaNombres.stream()
                .map(msg -> msg.concat(","))
                .reduce("", String::concat);

        System.out.println("las palabras concatenadas quedan asi: " + concat);



        /*8.Usa distinct para remover duplicados de una lista de números enteros.*/
        listaNumeros.stream()
                .distinct()
                .forEach(System.out::println);


        /*9. Obtener los 3 números más grandes de una lista Usa sorted y limit para encontrar los 3 números más
            grandes en una lista de enteros.*/

        System.out.println("Lista Sorted: ");
        listaNumeros.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(System.out::println);

        System.out.println("cambio en la rama dev");

        /*10.Usa Collectors.groupingBy para agrupar una lista de
        palabras según su cantidad de caracteres.*/

        Map<Integer, List<String>> palabras = listaNombres.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(palabras);

        /*11. Usa reduce para calcular el producto de todos los
            números de una lista.*/

        int producto = listaNumeros.stream()
                .reduce(listaNumeros.get(0),  (acum, numero) -> acum = acum * numero );

        System.out.println("Productos de los numeros de: " + listaNumeros + ":" + producto);
    }
}
