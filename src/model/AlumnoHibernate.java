package model;

import java.util.List;

public class AlumnoHibernate implements AlumnoDAO{

	@Override
	public int aniadirAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int aniadirAlumnos(List<Alumno> alumnos) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int aniadirGrupo(Grupo grupo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int aniadirGrupos(List<Grupo> alumnos) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Alumno> obtenerTodosLosAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Grupo> obtenerTodosLosGrupos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno obtenerAlumnoPorNIA(int nia) {
		// TODO Auto-generated method stub
		return null;
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

}
