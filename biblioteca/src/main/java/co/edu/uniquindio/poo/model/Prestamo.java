package co.edu.uniquindio.poo.model;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
    
    public class Prestamo {
        private String codigo;
        private Estudiante estudiante;
        private Bibliotecario bibliotecario;
        private List<DetallePrestamo> detalles;
        private Date fechaPrestamo;
        private Date fechaEntrega;
    
        /*
         * Constructor de la clase Prestamo
         */
        public Prestamo(String codigo, Estudiante estudiante, List<DetallePrestamo> detalles, Date fechaPrestamo, Date fechaEntrega) {
            this.codigo = codigo;
            this.estudiante = estudiante;
            this.detalles = detalles;
            this.fechaPrestamo = fechaPrestamo;
            this.fechaEntrega = fechaEntrega;
        }
    
        /*
         * Metodos gets y sets
         */
        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public Estudiante getEstudiante() {
            return estudiante;
        }

        public void setEstudiante(Estudiante estudiante) {
            this.estudiante = estudiante;
        }

        public List<DetallePrestamo> getDetalles() {
            return detalles;
        }

        public void setDetalles(List<DetallePrestamo> detalles) {
            this.detalles = detalles;
        }

        public Date getFechaPrestamo() {
            return fechaPrestamo;
        }

        public void setFechaPrestamo(Date fechaPrestamo) {
            this.fechaPrestamo = fechaPrestamo;
        }

        public Date getFechaEntrega() {
            return fechaEntrega;
        }

        public void setFechaEntrega(Date fechaEntrega) {
            this.fechaEntrega = fechaEntrega;
        }

        public Bibliotecario getBibliotecario() {
            return bibliotecario;
        }

        public void setBibliotecario(Bibliotecario bibliotecario) {
            this.bibliotecario = bibliotecario;
        }

        
        /*
         *  Metodo que calcula el costo total del préstamo
         */
        public double calcularCosto() {
            long dias = TimeUnit.DAYS.convert(fechaEntrega.getTime() - fechaPrestamo.getTime(), TimeUnit.MILLISECONDS);
            double costo = 0;
            for (DetallePrestamo detalle : detalles) {
                costo += detalle.getSubtotal();
            }
            return costo * dias;
        }
}


