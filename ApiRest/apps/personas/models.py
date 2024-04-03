from django.db import models

# Create your models here.
class Persona(models.Model):
    nombre = models.CharField(max_length=50, null=False, blank=False)
    apellido = models.CharField(max_length=50, null=False, blank=False)
    edad = models.IntegerField(null=False, blank=False)
    def __str__(self) -> str:
        return self.nombre