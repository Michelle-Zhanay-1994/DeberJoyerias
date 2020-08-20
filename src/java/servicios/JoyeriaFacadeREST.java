/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.Cliente;
import modelo.Joyeria;

/**
 *
 * @author LENOVO
 */
@Stateless
@Path("modelo.joyeria")
public class JoyeriaFacadeREST extends AbstractFacade<Joyeria> {

    @PersistenceContext(unitName = "JoyeriaPU")
    private EntityManager em;

    public JoyeriaFacadeREST() {
        super(Joyeria.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Joyeria entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Joyeria entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Joyeria find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Joyeria> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Joyeria> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    @POST
    @Path("obtener")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Joyeria> buscarClientes() {
        return super.findAll();
    }

    @POST
    @Path("Crear")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crear(@FormParam("idJoyeriaLoja") int idJoyeriaLoja, @FormParam("nombre") String nombre, @FormParam("ubicacion") String ubicacion, @FormParam("nombreEncargado") String nombreEncargado, @FormParam("dimensionLocal") int dimensionLocal, @FormParam("ciudad") String ciudad,@FormParam("direccion") String direccion){
        Joyeria ob= new Joyeria(idJoyeriaLoja);
        ob.setCiudad(ciudad);
        ob.setDimensionLocal(dimensionLocal);
        ob.setNombre(nombre);
        ob.setDireccion(direccion);
        ob.setNombreEncargado(nombreEncargado);
        ob.setUbicacion(ubicacion);
        super.create(ob);
        return ("Se creo el Cliente exitosamente");
    }

    @POST
    @Path("Editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar(@FormParam("idJoyeriaLoja") int idJoyeriaLoja, @FormParam("nombre") String nombre,@FormParam("ubicacion") String ubicacion, @FormParam("nombreEncargado") String nombreEncargado, @FormParam("dimensionLocal") int dimensionLocal, @FormParam("ciudad") String ciudad,@FormParam("direccion") String direccion) {
        Joyeria ob = super.find(idJoyeriaLoja);
        ob.setCiudad(ciudad);
        ob.setDimensionLocal(dimensionLocal);
        ob.setNombre(nombre);
        ob.setNombreEncargado(nombreEncargado);
        ob.setUbicacion(ubicacion);
        ob.setDireccion(direccion);
        super.edit(ob);
        return ("Se edito el Cliente");
    }
    
    @POST
    @Path("Eliminar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String eliminar(@FormParam ("idJoyeriaLoja") int idJoyeriaLoja){
        Joyeria ob= super.find(idJoyeriaLoja);
        super.remove(ob);
        return ("Se elimino el Cliente");
    }
    @POST
    @Path("readciudad")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Joyeria> leerciudad (@FormParam ("ciudad") String ciudad){
        TypedQuery consulta =getEntityManager().createQuery("SELECT j FROM Joyeria j WHERE j.ciudad = :ciudad",Joyeria.class);
        consulta.setParameter("ciudad",ciudad);
        return consulta.getResultList();
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
