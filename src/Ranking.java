package src;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Ranking {
    private String[] nombres = new String[10];
    private int[] puntos = new int[10];
    private int cantidad = 0;
    private boolean xmlCorrecto = true;

    public void añadirJugador(String nombre, int puntuacion) {

        if (cantidad == 10 && puntuacion <= puntos[9]) {
            System.out.println("No has conseguido entrar en el ranking.");
            return;
        }

        int posicion = 0;

        while (posicion < cantidad && puntuacion <= puntos[posicion]) {
            posicion++;
        }

        if (cantidad < 10) {
            cantidad++;
        }

        for (int i = cantidad - 1; i > posicion; i--) {
            nombres[i] = nombres[i - 1];
            puntos[i] = puntos[i - 1];
        }

        nombres[posicion] = nombre;
        puntos[posicion] = puntuacion;

        System.out.println("Jugador añadido al ranking.");
    }

    public void mostrarRanking() {

        System.out.println("\n============================");
        System.out.println("       RANKING DE HEROES");
        System.out.println("============================");

        if (cantidad == 0) {
            System.out.println("Todavia no hay jugadores en el ranking.");
        } else {

            for (int i = 0; i < cantidad; i++) {
                System.out.println((i + 1) + ". " + nombres[i] + " - " + puntos[i] + " puntos");
            }
        }

        System.out.println("============================");
    }

    public void cargarXML() {

        try {

            File archivo = new File("datos/ranking.xml");

            if (!archivo.exists()) {
                System.out.println("No existe el ranking. Se empezara con uno vacio.");
                return;
            }

            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();

            fabrica.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

            DocumentBuilder constructor = fabrica.newDocumentBuilder();

            Document documento = constructor.parse(archivo);

            documento.getDocumentElement().normalize();

            NodeList lista = documento.getElementsByTagName("jugador");
            if (lista.getLength() > 10) {
                throw new Exception("El ranking no puede tener mas de 10 jugadores.");
            }
            for (int i = 0; i < lista.getLength(); i++) {

                Element jugador = (Element) lista.item(i);

                String nombre = jugador.getElementsByTagName("nombre")
                        .item(0).getTextContent();

                int puntuacion = Integer.parseInt(jugador.getElementsByTagName("puntos").item(0).getTextContent());

                if (i > 0 && puntuacion > puntos[i - 1]) {
                    throw new Exception("El ranking XML no esta ordenado de mayor a menor.");
                }

                añadirJugador(nombre, puntuacion);
                if (nombre.trim().isEmpty()) {
                    throw new Exception("Hay un jugador sin nombre en el XML.");
                }

                if (puntuacion < 0) {
                    throw new Exception("Hay una puntuacion negativa en el XML.");
                }
            }

            System.out.println("Ranking cargado correctamente.");

        } catch (Exception e) {
            xmlCorrecto = false;
            cantidad = 0;

            System.out.println("Error al leer el ranking: " + e.getMessage());

        }
    }

    public void guardarXML() {
        if (xmlCorrecto == false) {
            System.out.println("No se puede guardar el ranking porque el XML tiene errores.");
            return;
        }
        try {

            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructor = fabrica.newDocumentBuilder();

            Document documento = constructor.newDocument();

            Element raiz = documento.createElement("ranking");
            documento.appendChild(raiz);

            for (int i = 0; i < cantidad; i++) {

                Element jugador = documento.createElement("jugador");
                raiz.appendChild(jugador);

                Element nombre = documento.createElement("nombre");
                nombre.setTextContent(nombres[i]);
                jugador.appendChild(nombre);

                Element puntuacion = documento.createElement("puntos");
                puntuacion.setTextContent(String.valueOf(puntos[i]));
                jugador.appendChild(puntuacion);
            }

            TransformerFactory transformerFabrica = TransformerFactory.newInstance();
            Transformer transformer = transformerFabrica.newTransformer();
            
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            DOMSource origen = new DOMSource(documento);
            StreamResult destino = new StreamResult(new File("datos/ranking.xml"));

            transformer.transform(origen, destino);

            System.out.println("Ranking guardado correctamente.");

        } catch (Exception e) {
            System.out.println("Error al guardar el ranking: " + e.getMessage());
        }
    }

}
