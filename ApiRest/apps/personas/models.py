from django.db import models

# Create your models here.
class Persona(models.Model):
    name = models.CharField(max_length=50, null=False, blank=False)
    
    def __str__(self) -> str:
        return self.name