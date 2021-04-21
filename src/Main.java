/**
 * Clase Main
 * HDT#8 - Algoritmos y Estructura de Datos
 * Ultima modificacion: 19/04/2021
 * @author Esteban Aldana Guerra 20591
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {

            /*
             * Data contiene a todos los pacientes
             */
            ArrayList<Paciente> Data = new ArrayList<>();
            int op;
            boolean salir = true;
            Scanner scan = new Scanner(System.in);
            while (salir) {
                try {
                    //Menu
                    System.out.println(" ");
                    System.out.println("---------------------------------- Hoja de Trabajo #8 -----------------------------------");
                    System.out.println(" Bienvenido al Programa, Por favor Seleccione que tipo de implementacion desea realizar: ");
                    System.out.println("1. Implementacion de VectorHeap con PriorityQueue");
                    System.out.println("2. Implementacion de JCF");
                    System.out.println("3. Salir");
                    op = scan.nextInt();

                    /*
                     * Se lee el Documento
                     */
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("pacientes.txt"));
                        String line;

                        /*
                         * Se guardan a los pacientes encontrados
                         */
                        while ((line = reader.readLine()) != null) {
                            String Info [] = line.split(",");
                            Paciente patient = new Paciente(Info[0], Info[1], Info[2]);
                            Data.add(patient);
                        }

                        /*
                         * Si no se encuentra el documento tira error
                         */
                    } catch (Exception E) {
                        System.out.println("Hubo un error al leer el documento");
                    }

                    /*
                     * Si selecciona 1, Se hace la implementacion con VectorHeap
                     */
                    if (op == 1) {
                        System.out.println("Implementacion de VectorHeap con PriorityQueue\n");
                        VectorHeap<Paciente> Heap = new VectorHeap<>();  // Using VectorHeap with PriorityQueue

                        /*
                         * Añade los pacientes al heap
                         */
                        for (Paciente datum : Data) {
                            Heap.add(datum);
                        }

                        /*
                         * Regresa a los pacientes ordenados por prioridad
                         */
                        while (Heap.size() > 0) {
                            Paciente actual = Heap.remove();
                            Atendiendo(actual);
                        }

                        /*
                         * Si selecciona 2, Se hace implementación de JCF
                         */
                    } else if (op == 2) {
                        System.out.println("Implementacion de JCF\n");

                        /*
                         * Añade los pacientes a la cola
                         */
                        // Using JCF
                        PriorityQueue<Paciente> Cola = new PriorityQueue<Paciente>();

                        /*
                            Añade los pacientes a la colaD
                         */
                        for(int i = 0; i < Data.size(); i++) {
                            Cola.add(Data.get(i));
                        }

                        /*
                            Regresa al paciente segun la prioridad
                         */
                        while(Cola.size() > 0) {
                            Paciente actual = Cola.remove();
                            Atendiendo(actual);
                        }

                    } else if (op == 3) {
                        System.out.println("Gracias por usar el programa, Que tenga un buen dia :)");
                        System.exit(0);
                        salir = false;
                    }
                    /*
                     * Si ingresa un numero que no esta especificado en el rango
                     */
                    else{
                        System.out.println("Por favor seleccione una de las opciones presentadas (Numeros del 1-3)");
                    }
                    /*
                     * Si no ingresa numeros
                     */
                }catch (Exception e) {
                    System.out.println("Solo se pueden ingresar numeros\n");
                    scan.next();
                }
            }
        }
    
        /**
         * Method that displays the current patient and waits for the next one
         */
        public static void Atendiendo(Paciente paciente) {
    
            /*
             *Scan Para enter
             */
            Scanner next = new Scanner(System.in);
            /*
             * Informacion del paciente
             */
            String nombre = paciente.getPacienteN();
            String sintomas = paciente.getSintomas();
            String prioridad = paciente.getPrioridad();
 
            /*
             * Imprime la informacion del paciente
             */
            System.out.println("Paciente a Atender: ");
            System.out.println("Nombre:" + nombre);
            System.out.println("Sintomas:" + sintomas);
            System.out.println("Prioridad:" + prioridad);
            System.out.println(" ");
            /*
             * Cuando muestra la informacion, con enter pasa al siguiente paciente
             */
            System.out.println("Presione enter para continuar");
            next.nextLine();
        }
    }

