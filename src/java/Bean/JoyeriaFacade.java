/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Joyeria;

/**
 *
 * @author LENOVO
 */
@Stateless
public class JoyeriaFacade extends AbstractFacade<Joyeria> {

    @PersistenceContext(unitName = "JoyeriaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JoyeriaFacade() {
        super(Joyeria.class);
    }
    
}