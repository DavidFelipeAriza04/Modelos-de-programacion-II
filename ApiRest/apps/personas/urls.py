from apps.personas.views import *
from django.urls import path
urlpatterns = [
    path('personas/', PersonaApiView.as_view(), name='persona_api'),
]