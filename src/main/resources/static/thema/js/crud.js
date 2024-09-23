// Función para editar Estudiante
function editarEstudiante(id) {
    fetch(`/estudiantes/${id}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById("idEstudiante").value = data.id;
            document.getElementById("nombre").value = data.nombre;
            document.getElementById("apellido").value = data.apellido;
            document.getElementById("correo").value = data.correo;
        })
        .catch(error => console.error('Error:', error));
}

// Función para eliminar Estudiante
function eliminarEstudiante(id) {
    if (confirm('¿Estás seguro de que deseas eliminar este estudiante?')) {
        fetch(`/estudiantes/${id}`, {
            method: 'DELETE'
        })
        .then(() => location.reload())
        .catch(error => console.error('Error:', error));
    }
}

// Función para editar Aula
function editarAula(id) {
    fetch(`/aulas/${id}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById("idAula").value = data.id;
            document.getElementById("nombreAula").value = data.nombreAula;
            document.getElementById("capacidad").value = data.capacidad;
        })
        .catch(error => console.error('Error:', error));
}

// Función para eliminar Aula
function eliminarAula(id) {
    if (confirm('¿Estás seguro de que deseas eliminar esta aula?')) {
        fetch(`/aulas/${id}`, {
            method: 'DELETE'
        })
        .then(() => location.reload())
        .catch(error => console.error('Error:', error));
    }
}

// Función para editar Docente
function editarDocente(id) {
    fetch(`/docentes/${id}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById("idDocente").value = data.id;
            document.getElementById("nombreDocente").value = data.nombre;
            document.getElementById("apellidoDocente").value = data.apellido;
            document.getElementById("correoDocente").value = data.correo;
        })
        .catch(error => console.error('Error:', error));
}

// Función para eliminar Docente
function eliminarDocente(id) {
    if (confirm('¿Estás seguro de que deseas eliminar este docente?')) {
        fetch(`/docentes/${id}`, {
            method: 'DELETE'
        })
        .then(() => location.reload())
        .catch(error => console.error('Error:', error));
    }
}

// Función para editar Materia
function editarMateria(id) {
    fetch(`/materias/${id}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById("idMateria").value = data.id;
            document.getElementById("nombreMateria").value = data.nombre;
            document.getElementById("creditos").value = data.creditos;
        })
        .catch(error => console.error('Error:', error));
}

// Función para eliminar Materia
function eliminarMateria(id) {
    if (confirm('¿Estás seguro de que deseas eliminar esta materia?')) {
        fetch(`/materias/${id}`, {
            method: 'DELETE'
        })
        .then(() => location.reload())
        .catch(error => console.error('Error:', error));
    }
}

// Función para editar Curso
function editarCurso(id) {
    fetch(`/cursos/${id}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById("idCurso").value = data.id;
            document.getElementById("nombreCurso").value = data.nombre;
            document.getElementById("anio").value = data.anio;
        })
        .catch(error => console.error('Error:', error));
}

// Función para eliminar Curso
function eliminarCurso(id) {
    if (confirm('¿Estás seguro de que deseas eliminar este curso?')) {
        fetch(`/cursos/${id}`, {
            method: 'DELETE'
        })
        .then(() => location.reload())
        .catch(error => console.error('Error:', error));
    }
}
