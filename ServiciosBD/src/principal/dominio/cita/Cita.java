/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.dominio.cita;

import principal.dominio.consultorio.Consultorio;
import principal.dominio.medico.Medico;
import principal.dominio.paciente.Paciente;

/**
 *
 * @author PC
 */
public class Cita {
    private int numCita;
    private Consultorio cons;
    private Medico med;
    private String date;
    private Paciente pac;

    public Cita(Consultorio cons, Medico med, String date, Paciente pac) {
        this.cons = cons;
        this.med = med;
        this.date = date;
        this.pac = pac;
    }

    public Cita() {
    }

    public int getNumCita() {
        return numCita;
    }

    public void setNumCita(int numCita) {
        this.numCita = numCita;
    }

    public Consultorio getCons() {
        return cons;
    }

    public void setCons(Consultorio cons) {
        this.cons = cons;
    }

    public Medico getMed() {
        return med;
    }

    public void setMed(Medico med) {
        this.med = med;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Paciente getPac() {
        return pac;
    }

    public void setPac(Paciente pac) {
        this.pac = pac;
    }
    
    
    
    
}