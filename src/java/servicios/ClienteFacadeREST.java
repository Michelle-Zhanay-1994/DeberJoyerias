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

/**
 *
 * @author LENOVO
 */
@Stateless
@Path("modelo.cliente")
public class ClienteFacadeREST extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "JoyeriaPU")
    private EntityManager em;

    public ClienteFacadeREST() {
        super(Cliente.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Cliente entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Cliente entity) {
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
    public Cliente find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    public List<Cliente> buscarClientes() {
        return super.findAll();
    }

    @POST
    @Path("Crear")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crear(@FormParam("idCliente") int idCliente, @FormParam("nombre") String nombre, @FormParam("direccion") String direccion, @FormParam("correo") String correo, @FormParam("telefono") int telefono, @FormParam("ciudad") String ciudad, @FormParam("edad") int edad, @FormParam("joyeriapreferencia") int joyeriapreferencia) {
        Cliente ob = new Cliente(idCliente);
        ob.setCiudad(ciudad);
        ob.setCorreo(correo);
        ob.setDireccion(direccion);
        ob.setEdad(edad);
        ob.setJoyeriapreferencia(joyeriapreferencia);
        ob.setNombre(nombre);
        ob.setTelefono(telefono);

        super.create(ob);
        return ("Se creo el Cliente exitosamente");
    }

    @POST
    @Path("Editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar(@FormParam("idCliente") int idCliente, @FormParam("nombre") String nombre, @FormParam("direccion") String direccion, @FormParam("correo") String correo, @FormParam("telefono") int telefono, @FormParam("ciudad") String ciudad, @FormParam("edad") int edad, @FormParam("joyeriapreferencia") int joyeriapreferencia) {
        Cliente ob = super.find(idCliente);
        ob.setCiudad(ciudad);
        ob.setCorreo(correo);
        ob.setDireccion(direccion);
        ob.setEdad(edad);
        ob.setJoyeriapreferencia(joyeriapreferencia);
        ob.setNombre(nombre);
        ob.setTelefono(telefono);
        super.edit(ob);
        return ("Se edito el Cliente");
    }

    @POST
    @Path("Eliminar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String eliminar(@FormParam("idCliente") int idCliente) {
        Cliente ob = super.find(idCliente);
        super.remove(ob);
        return ("Se elimino el Cliente");
    }

    @POST
    @Path("leerjoyeria")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Cliente> leerjoyeria(@FormParam("joyeriapreferencia") int joyeriapreferencia) {
        TypedQuery consulta = getEntityManager().createQuery("SELECT c FROM Cliente c WHERE c.joyeriapreferencia = :joyeriapreferencia", Cliente.class);
        consulta.setParameter("joyeriapreferencia", joyeriapreferencia);
        return consulta.getResultList();
    }
    @POST
    @Path("Mayor")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Cliente>mayor(@FormParam("edad")int edad){
        TypedQuery consulta = getEntityManager().createQuery("SELECT c FROM Cliente c WHERE c.edad >= :edad",Cliente.class);
        consulta.setParameter("edad",edad);
        return consulta.getResultList();
         
    }

    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
