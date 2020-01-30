package app.persistencia;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.modelo.Contacto;


public class AccesoContactos extends Conexion{
	
	public Contacto VerContacto(int idContacto) throws ClassNotFoundException, SQLException {
		//1. Definir variables
		String sql = "Select nombre, email, telefono from contactos where idcontacto = ?";
		PreparedStatement comando;
		ResultSet rs;
		Contacto c1= null;
		//2. Abrir conexion
		abrirConexion();
		//3. Obtener comando
		comando=miConexion.prepareStatement(sql);		
		comando.setInt(1, idContacto);
		//4. Ejecutar comando
		rs = comando.executeQuery();
		//5. Recoger resultset
		if (rs.next()) {
            c1 = new Contacto (rs.getString("nombre"), rs.getString("email"), rs.getString("telefono"));            
		}
		//6. Cerrar conexion
		cerrarConexion();
		//7. Devolver datos
		return c1;		
	}
	
	public ArrayList<Contacto> verTodos() throws ClassNotFoundException, SQLException{
		
		String sql = "Select idcontacto, nombre, email, telefono from contactos";
		PreparedStatement comando;
		ResultSet rs;
		ArrayList<Contacto> lista = new ArrayList<Contacto>();
		
		abrirConexion();
		
		comando = miConexion.prepareStatement(sql);
		
		rs = comando.executeQuery();
		
		while(rs.next()) {
			
			Contacto c= new Contacto(rs.getInt("idcontacto"), rs.getString("nombre"), rs.getString("email"), rs.getString("telefono"));
			lista.add(c);
		}
		
		cerrarConexion();
		
		return lista;
	}
	
	public boolean registrarContacto(Contacto c) throws ClassNotFoundException, SQLException{
        //1. Definir variables
        String sql = "Insert into contactos (nombre, email, telefono) values (?,?,?);";
        PreparedStatement comando;
        int numeroRegistrosInsertados;
        //2. Abrir conexion 
        abrirConexion();
        //3. Obtener comando
        comando = miConexion.prepareStatement(sql);      
        comando.setString(1, c.getNombre());
        comando.setString(2, c.getEmail());
        comando.setString(3, c.getTelefono());
        //4. Ejecutar comando
        numeroRegistrosInsertados = comando.executeUpdate();           
        //5. Cerrar conexion
        cerrarConexion();
        //6. Devolver verdadero si se dio de alta y falso en caso contrario
        System.out.println(numeroRegistrosInsertados);
        return numeroRegistrosInsertados>=1;
    }
	
	public boolean modificarContacto(int idContacto, String nombre, String email, String telefono) throws ClassNotFoundException, SQLException{
        //1. Definir variables
        String sql = "Update contactos set nombre = ?, email = ?, telefono = ? where idcontacto = ?;";
        PreparedStatement comando;
        Contacto c2 = new Contacto();
        int numeroRegistrosModificados;
        //2. Abrir conexion 
        abrirConexion();
        //3. Obtener comando        		
        comando = miConexion.prepareStatement(sql);      
        comando.setString(1, nombre);
        comando.setString(2, email);
        comando.setString(3, telefono);
        comando.setInt(4, idContacto);        
        //4. Ejecutar comando
        numeroRegistrosModificados = comando.executeUpdate();        
        //5. Cerrar conexion
        cerrarConexion();
        //6. Devolver verdadero si se dio de alta y falso en caso contrario
        System.out.println(numeroRegistrosModificados);		
        return numeroRegistrosModificados>=1;
    }
    
	public boolean borrarContacto(int idContacto) throws ClassNotFoundException, SQLException{
        //1. Definir variables
        String sql = "Delete from contactos where idcontacto = ?;";
        PreparedStatement comando;
        Contacto c2 = new Contacto();
        int numeroRegistrosBorrados;
        //2. Abrir conexion 
        abrirConexion();
        //3. Obtener comando        		
        comando = miConexion.prepareStatement(sql);      
        comando.setInt(1, idContacto);        
        //4. Ejecutar comando
        numeroRegistrosBorrados = comando.executeUpdate();        
        //5. Cerrar conexion
        cerrarConexion();
        //6. Devolver verdadero si se dio de alta y falso en caso contrario
        System.out.println(numeroRegistrosBorrados);		
        return numeroRegistrosBorrados>=1;
    }
}
