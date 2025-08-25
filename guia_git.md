# Guia para empezar en Git
### Qué es Git y qué es Github?
Git es un **Sistema de control de versiones** distribuido gratuito y de código abierto diseñado para manejar todo, desde pequeños hasta Proyectos muy grandes con rapidez y eficiencia. Github es una **plataforma remota** donde se almacena la informacion del repositorio local usando el git.

### Qué es un repositorio local y remoto?

Es como una carpeta en la que guardamos cosas, un repositorio git es una carpeta en la que trabajamos con git. En cuanto a repositorio local y remoto, uno local está guardado en nuestra máquina, mientras que uno remoto, se guardan en plataformas como Github o Gitlab, requiere de internet, ya que guarda la información en línea.

### Métodos generales de consola

1. clear = Limpia la consola


2. ls = Nos enseña un listado de los directorios (carpetas) de la carpeta en la que estamos,
          ej: Pictures, Searched, Saved Games, Documents, Downloads, Impresoras, etc.
 
 
3. cd carpeta = Se dirige a esta carpeta, ej: cd Documents. también podemos retroceder con 'cd ..' Si la carpeta tiene un espacio, el espacio se muestra como "\ " con el espacio incluido
                  asi que si tenemos una carpeta llamada Hola Mundo y queremos movernos ahí, hacemos 'cd Hola\ mundo'
 
 
  4. pwd = Nos enseña la carpeta en la que estamos y las carpetas anteriores (ruta)
           ej: /c/Users/Personal
 
 
  5. mkdir "nombreCarpeta" = Crea una carpeta con un nombre, se va a crear en la carpeta en la que estemos, 
                             si estamos en desktop, logicamente se creará en el escritorio.
 
 
  6. code . = Inicia visual studio code en la carpeta en la que estamos.
 
 
  7. touch = Crea un archivo en la carpeta en la que estás,
             ej: touch archivito.py (crea un archivo python)

### Cómo usar Git?

Antes de empezar, se tiene que aclarar que necesitamos dar un nombre y un email esto es un requerimiento, tenemos que hacerlo obligatoriamente para trabajar con git, esto se hace con git config, el cual simplemente afectan como nuestro nombre y email aparece cada vez que hacemos un commit, si nos equivocamos, simplemente podemos usar el mismo método para arreglarlo:
             
              git config --global user.name "Nombre"  
              git config --global user.email "email"
             
Usa --global para ponerlo en cada repositorio en tu computadora.
Usa --local(el predeterminado) para ponerlo solo en el repositorio actual.

### Métodos basicos y generales de Git

