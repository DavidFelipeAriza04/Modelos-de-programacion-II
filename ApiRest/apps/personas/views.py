from django.shortcuts import render

# Create your views here.
from rest_framework.views import APIView
from django.http.response import JsonResponse

# from rest_framework.response import Response

# self modules
from .models import *


class PersonaApiView(APIView):
    def get(self, request):
        personas = list(Persona.objects.values())
        data = {"personas": personas}

        return JsonResponse(data)

    def post(self, request):
        persona = Persona()
        persona.nombre = request.data.get("nombre", "")
        persona.apellido = request.data.get("apellido", "")
        persona.edad = request.data.get("edad", "")
        persona.save()
        datos = {"message": "Persona creada con exito", "status": "success"}
        return JsonResponse(datos)

    def delete(self, request):
        id = request.data.get("id")
        persona = Persona.objects.get(id=id)
        persona = Persona.objects.get(id=request.data.get("id", ""))
        persona.delete()
        datos = {"message": "Persona eliminada con exito", "status": "success"}
        return JsonResponse(datos)

    # def patch(self, request):
    #     id = request.data.get("id")
    #     project = Project.objects.get(id=id)
    #     project.name = request.data.get("name", project.name)
    #     project.save()
    #     return Response({"id": project.id, "name": project.name})
