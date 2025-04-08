
package com.mycompany.peluqueriacaninaproject.logica;

import com.mycompany.peluqueriacaninaproject.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMascota, String raza, String color, String observaciones, 
            String alergico, String atencionEsp, String nombreDueno, String celDueno) {
      
        //Creamoes el dueño y le asignamos sus valores
        Dueno dueno = new Dueno();
        dueno.setNombre(nombreDueno);
        dueno.setCelDueno(celDueno);
        
         //Creamoes la mascota y le asignamos sus valores
        Mascota mascota = new Mascota();
        mascota.setNombre(nombreMascota);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setObservaciones(observaciones);
        mascota.setAlergico(alergico);
        mascota.setAtencionEspecial(atencionEsp);
        mascota.setDueno(dueno);
        
        controlPersis.guardar(dueno, mascota);
    }

    public List<Mascota> traerMascotas() {
      
        return controlPersis.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
      controlPersis.borrarMascota(num_cliente);
      
    }

    public Mascota traerMascota(int num_cliente) {
   
       return controlPersis.traerMascota(num_cliente);

    }

    public void modificarMascota(Mascota masco, String nombreMascota, String raza, String color, 
          String observaciones, String alergico, String atencionEsp, String nombreDueno, String celDueno) {
        
        //Seteamos los datos solo de la mascota
        masco.setAlergico(alergico);
        masco.setAtencionEspecial(atencionEsp);
        masco.setColor(color);
        masco.setNombre(nombreMascota);
        masco.setObservaciones(observaciones);
        masco.setRaza(raza);
        
        //Modifico mascota
        controlPersis.modificarMascota(masco);
        
        //traigo desde un método para buscar dueño, al dueño que quiero modificar
        Dueno dueno = this.buscarDueno(masco.getDueno().getIdDueno());
        //Le seteamos los datos a Dueño
        dueno.setNombre(nombreDueno);
        dueno.setCelDueno(celDueno);
        
        //Ahora que tenemos seteado el dueño, tenemos que modificarlo con un método
        this.modificarDueno(dueno);
    }

    private Dueno buscarDueno(int idDueno) {

        return controlPersis.buscarDueno(idDueno);
    }

    private void modificarDueno(Dueno dueno) {

        controlPersis.modificarDueno(dueno);
                
                
                
                
    }
    

   
    
}
