/**
 * Clase Paciente
 * HDT#8 - Algoritmos y Estructura de Datos
 * Ultima modificacion: 19/04/2021
 * @author Esteban Aldana Guerra 20591
 */

public class Paciente implements Comparable<Paciente>{
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