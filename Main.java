import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {

            //Data contiene a todos los pacientes 
            ArrayList<Paciente> Data = new ArrayList<>();
            int op = 0;
            boolean salir = true;
            Scanner scan = new Scanner(System.in);
            while (salir) {
                // Prints the main menu by default, JCF implementation is used
                System.out.println("-----------------Hoja de Trabajo #8 --------------------------------");
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println(" Bienvenido al Programa, Por favor Seleccione que tipo de implementacion desea realizar: ");
                System.out.println("1. Implementacion de VectorHeap con PriorityQueue");
                System.out.println("2. Implementacion de JCF");
                System.out.println("3. Salir");
                System.out.println("-----------------------------------------------------------------------------------------");
                op = scan.nextInt();

                // Reads the document
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("pacientes.txt"));
                    String line;

                    // Saves each patient found
                    while ((line = reader.readLine()) != null) {
                        String patientIntel[] = line.split(",");
                        Paciente patient = new Paciente(patientIntel[0], patientIntel[1], patientIntel[2]);
                        Data.add(patient);
                    }

                    // If document is not found
                } catch (Exception E) {
                    System.err.println("Hubo un error al leer el documento");
                    System.err.println("Por favor asegurese de que el nombre de este sea 'pacientes.txt'");
                }

                // VectorHeap implementation
                if (op == 1) {
                    System.out.println("Utilizando VectorHeap con PriorityQueue");
                    VectorHeap<Paciente> patientHeap = new VectorHeap<>();  // Using VectorHeap with PriorityQueue

                    // Adds all patients to the heap
                    for (int i = 0; i < Data.size(); i++) {
                        patientHeap.add(Data.get(i));
                    }

                    // Returns the patients according to priority
                    while (patientHeap.size() > 0) {
                        Paciente currentPatient = patientHeap.remove();
                        attendPatient(currentPatient);
                    }

                    // JCF implementation
                } else if (op == 2) {
                    System.out.println("Utilizando Java Collections Framework");
                    PriorityQueue<Paciente> patientQueue = new PriorityQueue<Paciente>();   // Using JCF

                    // Adds all patients to the queue
                    for (int i = 0; i < Data.size(); i++) {
                        patientQueue.add(Data.get(i));
                    }

                    // Returns the patients according to priority
                    while (patientQueue.size() > 0) {
                        Paciente currentPatient = patientQueue.remove();
                        attendPatient(currentPatient);
                    }
                } else if (op == 3) {
                    System.out.println("Gracias por usar el programa, Que tenga un buen dia :)");
                    System.exit(0);
                }
            }
        }
    
        /**
         * Method that displays the current patient and waits for the next one
         */
        public static void attendPatient(Paciente patient) {
    
            // To wait for input
            Scanner next = new Scanner(System.in);
            // Patient information
            String nombre = patient.getPacienteN();
            String sintomas = patient.getSintomas();
            String prioridad = patient.getPrioridad();
    
            // Prints needed data
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Atendiendo al paciente");
            System.out.println("Nombre: " + nombre);
            System.out.println("Padecimientos:" + sintomas);
            System.out.println("Prioridad:" + prioridad);
    
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println();
            // Waits for confirmation that the doctor is finished
            System.out.println("Presione enter cuando desee atender al siguiente");
            next.nextLine();
        }
    }

