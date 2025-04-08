
package com.mycompany.peluqueriacaninaproject.persistencia;

import com.mycompany.peluqueriacaninaproject.logica.Dueno;
import com.mycompany.peluqueriacaninaproject.logica.Mascota;
import com.mycompany.peluqueriacaninaproject.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ControladoraPersistencia {
    
    DuenoJpaController duenoJpa = new DuenoJpaController();
    MascotaJpaController mascotaJpa = new MascotaJpaController();

    public void guardar(Dueno dueno, Mascota mascota) {
      
        duenoJpa.create(dueno);
        mascotaJpa.create(mascota);
    } 

    public List<Mascota> traerMascotas() {
 
     return mascotaJpa.findMascotaEntities();
        
    }

    public void borrarMascota(int num_cliente) {
        try {
            mascotaJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Mascota traerMascota(int num_cliente) {

        return mascotaJpa.findMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco) {

        try {
            mascotaJpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }

    public Dueno buscarDueno(int idDueno) {

        return duenoJpa.findDueno(idDueno);
    }

    public void modificarDueno(Dueno dueno) {

        try {
            duenoJpa.edit(dueno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }

    
}
