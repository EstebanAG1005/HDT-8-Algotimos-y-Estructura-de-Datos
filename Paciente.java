/**
 * Clase Paciente
 * HDT#8 - Algoritmos y Estructura de Datos
 * Ultima modificacion: 19/04/2021
 * @author Esteban Aldana Guerra 20591
 * Referencias:
 * https://cs.colby.edu/courses/F17/cs231/LectureNotes/Topic09_PriorityQueues.pdf
 * https://beginnersbook.com/2013/12/java-string-compareto-method-example/#:~:text=The%20Java%20String%20compareTo(),returns%20positive%20or%20negative%20value.
 */

public class DPaciente implements Comparable<Paciente>{
    String PacienteN;
    String Sintomas;
    String Prioridad;
    /**
     * Regresa informacion del paciente
     * @param PacienteN Nombre del paciente 
     * @param Sintomas Sintomas que presenta el paciente 
     * @param Prioridad Prioridad en Cola
     */
    Paciente(String PacienteN, String Sintomas, String Prioridad) {
        this.PacienteN = PacienteN;
        this.Sintomas = Sintomas;
        this.Prioridad = Prioridad;
    }

     /**
      * Compara prioridades
      *@param otroPaciente paciente comparado
      */
    @Override
    public int compareTo(Paciente otroPaciente) {
        if(this.Prioridad.compareTo(otroPaciente.Prioridad) > 0) {
            return 1;   // paciente con menos prioridad
        } else if (this.Prioridad.compareTo(otroPaciente.Prioridad) < 0) {
            return -1;  // paciente tiene mas prioridad
        }
        return 0;   // paciente tiene misa prioridad
    }

    /**
     * nombre de paciente
     * @return nombre del paciente 
     */
    public String getPacienteN() {
        return PacienteN;
    }

    /**
     * Sintomas del paciente
     * @return Sintomas
     */
    public String getSintomas() {
        return Sintomas;
    }

    /**
     * Prioridad del paciente 
     * @return Prioridad
     */
    public String getPrioridad() {
        return Prioridad;
    }
}