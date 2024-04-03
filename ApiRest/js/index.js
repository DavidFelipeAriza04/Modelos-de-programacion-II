const API = "http://127.0.0.1:8000/api/personas/"
const getPersonas = async () => {
    const response = await fetch(API)
    const data = await response.json()
    data['personas'].forEach(persona => anadirFilaTabla(persona))
    console.log(data)
}

function MostrarAnadirPersona() {
    document.getElementById('div_agregar').classList.toggle('hidden');
    document.getElementById('div_agregar').classList.toggle('flex');
}

function AgregarPersona() {
    const nombre = document.getElementById('InputNombre').value;
    const apellido = document.getElementById('InputApellido').value;
    const edad = parseInt(document.getElementById('InputEdad').value);
    if (nombre == '' || apellido == '' || edad == '') {
        alert('Debe llenar todos los campos');
        return;
    }
    const persona = {
        nombre: nombre,
        apellido: apellido,
        edad: edad,
    }
    fetch(API, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(persona)
    })
        .then(response => response.json())
        .then(data => {
            MostrarAnadirPersona()
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}

function EliminarPersona(id) {
    const idPersona = {
        id: id,
    }
    fetch(API, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(idPersona)
    })
        .then(response => response.json())
        .catch((error) => {
            console.error('Error:', error);
        });

}
function anadirFilaTabla(persona) {
    document.getElementById('tabla_personas').innerHTML += `
            <tr>
                <th scope="row">${persona.id}</th>
                <td>${persona.nombre}</td>
                <td>${persona.apellido}</td>
                <td>${persona.edad}</td>
                <td><button type="button" class="btn btn-outline-danger" onclick="EliminarPersona(${persona.id})">Eliminar</button></td>
            </tr>
        `
}
window.addEventListener('load', () => {
    getPersonas();
});