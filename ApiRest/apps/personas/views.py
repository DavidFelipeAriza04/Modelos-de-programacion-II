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
        data = {"message":"Success","personas": personas}

        return JsonResponse(data)

    def post(self, request):
        persona = Persona()
        persona.name = request.data.get("name", "")
        persona.save()
        datos = {"message":"Persona creada con exito", "status":"success"}
        return JsonResponse(datos)

    # def delete(self, request):
    #     id = request.data.get("id")
    #     project = Project.objects.get(id=id)
    #     project = Project.objects.get(id=request.data.get("id", ""))
    #     project.delete()
    #     return Response({})

    # def patch(self, request):
    #     id = request.data.get("id")
    #     project = Project.objects.get(id=id)
    #     project.name = request.data.get("name", project.name)
    #     project.save()
    #     return Response({"id": project.id, "name": project.name})
