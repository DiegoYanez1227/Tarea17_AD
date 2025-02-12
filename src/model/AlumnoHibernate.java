package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class AlumnoHibernate implements AlumnoDAO{

	StandardServiceRegistry sr= new StandardServiceRegistryBuilder().configure().build();

	SessionFactory sf= new MetadataSources(sr).buildMetadata().buildSessionFactory();

	Session session= sf.openSession();

	@Override
	public int aniadirAlumno(Alumno alumno) {
		if(alumno!=null) {
			Transaction transaction = session.beginTransaction();  
			try {
				session.persist(alumno);
				transaction.commit(); 
				return 1;
			} catch (Exception e) {
				transaction.rollback();  
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int aniadirAlumnos(List<Alumno> alumnos) {
		int contador=0;
		if(alumnos!=null) {
			Transaction transaction = session.beginTransaction();  
			try {
				for (Alumno alumno : alumnos) {
					session.persist(alumno);	
					contador++;
				}
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();  
				e.printStackTrace();
			}
			if (contador % 50 == 0) {  
				session.flush();  
				session.clear();
			}
		}
		return contador;
	}

	@Override
	public int aniadirGrupo(Grupo grupo) {
		if(grupo!=null) {
			Transaction transaction = session.beginTransaction();  
			try {
				session.persist(grupo);
				transaction.commit(); 
				return 1;
			} catch (Exception e) {
				transaction.rollback();  
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int aniadirGrupos(List<Grupo> grupos) {
		int contador=0;
		if(grupos!=null) {
			Transaction transaction = session.beginTransaction();  
			try {
				for (Grupo grupo : grupos) {
					session.persist(grupo);	
					contador++;
				}
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();  
				e.printStackTrace();
			}
			if (contador % 50 == 0) {  
				session.flush();  
				session.clear();
			}
		}
		return contador;
	}

	@Override
	public List<Alumno> obtenerTodosLosAlumnos() {
		List<Alumno> listaAlumnos=null;

		try {
			listaAlumnos= new ArrayList<>();
			listaAlumnos=session.createQuery("FROM alumno",Alumno.class).list();
		}catch(Exception e) {
			e.printStackTrace();
			//TODO Logger
			return null;
		}
		return listaAlumnos;
	}

	@Override
	public List<Grupo> obtenerTodosLosGrupos() {
		List<Grupo> listaGrupos=null;

		try {
			listaGrupos= new ArrayList<Grupo>();
			listaGrupos=session.createQuery("FROM grupo",Grupo.class).list();
		}catch(Exception e) {
			e.printStackTrace();
			//TODO Logger
			return null;
		}
		return listaGrupos;
	}

	@Override
	public Alumno obtenerAlumnoPorNIA(int nia) {
		Alumno alumno;
		try {
			alumno = (Alumno)session.getReference(Alumno.class, (int)nia);
			return alumno;
		}catch(ObjectNotFoundException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Alumno> obtenerAlumnosPorGrupo(Grupo grupo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modificarNombrePorNia(int nia, String nombre) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modificarGrupoDeAlumno(int nia, Grupo grupo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void eliminarPorNia(int nia) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarPorCurso(String curso) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> obtenerCursos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void cerrarSession() {
		session.close();
		sf.close();
	}

}
