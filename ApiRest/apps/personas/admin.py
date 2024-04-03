from django.contrib import admin
from .models import *

# Register your models here.
class AdminPersona(admin.ModelAdmin):
    list_display = ['id','name']

admin.site.register(Persona, AdminPersona)