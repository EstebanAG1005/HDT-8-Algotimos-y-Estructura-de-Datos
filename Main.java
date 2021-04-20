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

            /**
             * Data contiene a todos los pacientes
             */
            ArrayList<Paciente> Data = new ArrayList<>();
            int op = 0;
            boolean salir = true;
            Scanner scan = new Scanner(System.in);
            while (salir) {
                try {
                    //Menu
                    System.out.println("---------------------------------- Hoja de Trabajo #8 -----------------------------------");
                    System.out.println(" Bienvenido al Programa, Por favor Seleccione que tipo de implementacion desea realizar: ");
                    System.out.println("1. Implementacion de VectorHeap con PriorityQueue");
                    System.out.println("2. Implementacion de JCF");
                    System.out.println("3. Salir");
                    System.out.println("-----------------------------------------------------------------------------------------");
                    op = scan.nextInt();

                    /**
                     * Se lee el Documento
                     */
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("pacientes.txt"));
                        String line;

                        /**
                         * Se guardan a los pacientes encontrados
                         */
                        while ((line = reader.readLine()) != null) {
                            String patientIntel[] = line.split(",");
                            Paciente patient = new Paciente(patientIntel[0], patientIntel[1], patientIntel[2]);
                            Data.add(patient);
                        }

                        /**
                         * Si no se encuentra el documento tira error
                         */
                    } catch (Exception E) {
                        System.err.println("Hubo un error al leer el documento");
                        System.err.println("Revise que tenga el documento 'pacientes.txt'");
                    }

                    /**
                     * Si selecciona 1, Se hace la implementacion con VectorHeap
                     */
                    if (op == 1) {
                        System.out.println("Utilizando VectorHeap con PriorityQueue");
                        VectorHeap<Paciente> patientHeap = new VectorHeap<>();  // Using VectorHeap with PriorityQueue

                        /**
                         * Añade los pacientes al heap
                         */
                        for (int i = 0; i < Data.size(); i++) {
                            patientHeap.add(Data.get(i));
                        }

                        /**
                         * Regresa a los pacientes ordenados por prioridad
                         */
                        while (patientHeap.size() > 0) {
                            Paciente currentPatient = patientHeap.remove();
                            attendPatient(currentPatient);
                        }

                        /**
                         * Si selecciona 2, Se hace implementación de JCF
                         */
                    } else if (op == 2) {
                        System.out.println("Utilizando Java Collections Framework");
                        PriorityQueue<Paciente> patientQueue = new PriorityQueue<Paciente>();   // Using JCF

                        /**
                         * Añade los pacientes a la cola
                         */
                        for (int i = 0; i < Data.size(); i++) {
                            patientQueue.add(Data.get(i));
                        }

                        /**
                         * Regresa a los pacientes ordenados por prioridad
                         */
                        while (patientQueue.size() > 0) {
                            Paciente currentPatient = patientQueue.remove();
                            attendPatient(currentPatient);
                        }
                        /**
                         * Si selecciona 3, Termina el Programa
                         */
                    } else if (op == 3) {
                        System.out.println("Gracias por usar el programa, Que tenga un buen dia :)");
                        System.exit(0);
                    }
                    else{
                        System.out.println("Por favor seleccione una de las opciones presentadas (Numeros del 1-3)");
                    }
                    /**
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
        public static void attendPatient(Paciente patient) {
    
            // To wait for input
            Scanner next = new Scanner(System.in);
            /**
             * Informacion del paciente
             */
            String nombre = patient.getPacienteN();
            String sintomas = patient.getSintomas();
            String prioridad = patient.getPrioridad();

            /**
             * Imprime la informacion del paciente
             */
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Paciente a Atender:");
            System.out.println("Nombre: " + nombre);
            System.out.println("Padecimientos:" + sintomas);
            System.out.println("Prioridad:" + prioridad);
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println();
            /**
             * Cuando muestra la informacion con enter pasa al siguiente paciente
             */
            System.out.println("Presione enter para continuar");
            next.nextLine();
        }
    }

