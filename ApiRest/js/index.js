const API = "http://127.0.0.1:8000/api/personas/"
const getPersonas=async()=>{
    const response = await fetch(API)
    const data = await response.json()
    console.log(data)
}

window.addEventListener('load',()=>{    
    getPersonas();
});