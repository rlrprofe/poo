# POO · Programación Orientada a Objetos

Curso de fundamentos de la programación orientada a objetos con Java, creado con MkDocs Material. Es la base conceptual para el diseño de diagramas de clases con UML.

## Puesta en marcha

```powershell
python -m pip install -r requirements.txt
python -m mkdocs serve
```

Visita `http://127.0.0.1:8000/`.

## Publicación

El workflow `.github/workflows/deploy.yml` construye el sitio y lo publica en la rama `gh-pages` con cada `push` a `main`.

Solo la primera vez, en GitHub: **Settings → Pages → Source: Deploy from a branch → `gh-pages` / `(root)`**.

Si prefieres desplegar a mano: `python -m mkdocs gh-deploy --force`.

## Estructura

```text
docs/
  index.md                  Portada y recorrido
  capitulos/                Capítulos 1 a 8
  anexos/                   Glosario y mapa mental
  descargas/caso-practico/  Proyecto Java del capítulo 7 (zip)
  img/                      Imágenes (coches, mapa mental)
```
