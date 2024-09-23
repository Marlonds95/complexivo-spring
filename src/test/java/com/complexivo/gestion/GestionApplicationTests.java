package com.complexivo.gestion;

import com.complexivo.gestion.model.Aula;
import com.complexivo.gestion.model.Curso;
import com.complexivo.gestion.model.Docente;
import com.complexivo.gestion.model.Estudiante;
import com.complexivo.gestion.model.Matricula;
import com.complexivo.gestion.service.AulaService;
import com.complexivo.gestion.service.CursoService;
import com.complexivo.gestion.service.DocenteService;
import com.complexivo.gestion.service.EstudianteService;
import com.complexivo.gestion.service.MatriculaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GestionApplicationTests {

	@Autowired
	private EstudianteService estudianteService;
	@Autowired
	private AulaService aulaService;
	@Autowired
	private CursoService cursoService;
	@Autowired
	private DocenteService docenteService;
	@Autowired
	private MatriculaService matriculaService;

	private Estudiante estudiante;
	private Aula aula;
	private Curso curso;
	private Docente docente;
	private Matricula matricula;

	@BeforeEach
	public void setUp() {
		// Configurar Aula
		aula = new Aula();
		aula.setNombreAula("Aula 101");
		aula.setCapacidad(30);
		aulaService.saveAula(aula); // Guardar aula para asociar más tarde

		// Configurar Estudiante
		estudiante = new Estudiante();
		estudiante.setNombre("Juan Pérez");
		estudiante.setFechaNacimiento(Date.valueOf("2005-05-15"));
		estudiante.setDireccion("Calle Falsa 123");
		estudiante.setAula(aula);
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testCrearEstudiante() {
		Estudiante savedEstudiante = estudianteService.saveEstudiante(estudiante);
		assertThat(savedEstudiante).isNotNull();
		assertThat(savedEstudiante.getIdEstudiante()).isGreaterThan(0);
	}

	@Test
	void testLeerEstudiante() {
		Estudiante savedEstudiante = estudianteService.saveEstudiante(estudiante);
		Estudiante foundEstudiante = estudianteService.findById(savedEstudiante.getIdEstudiante());
		assertThat(foundEstudiante).isNotNull();
		assertThat(foundEstudiante.getNombre()).isEqualTo("Juan Pérez");
	}

	@Test
	void testActualizarEstudiante() {
		Estudiante savedEstudiante = estudianteService.saveEstudiante(estudiante);
		savedEstudiante.setNombre("Juanito Pérez");
		Estudiante updatedEstudiante = estudianteService.saveEstudiante(savedEstudiante);
		assertThat(updatedEstudiante.getNombre()).isEqualTo("Juanito Pérez");
	}

	@Test
	void testEliminarEstudiante() {
		Estudiante savedEstudiante = estudianteService.saveEstudiante(estudiante);
		estudianteService.deleteEstudiante(savedEstudiante.getIdEstudiante());
		Estudiante foundEstudiante = estudianteService.findById(savedEstudiante.getIdEstudiante());
		assertThat(foundEstudiante).isNull();
	}

}
