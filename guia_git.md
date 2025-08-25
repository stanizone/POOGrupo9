# Guia para empezar en Git
### Qué es Git y qué es Github?
Git es un **Sistema de control de versiones** distribuido gratuito y de código abierto diseñado para manejar todo, desde pequeños hasta Proyectos muy grandes con rapidez y eficiencia. Github es una **plataforma remota** donde se almacena la informacion del repositorio local usando el git.

---
### Qué es un repositorio local y remoto?

Es como una carpeta en la que guardamos cosas, un repositorio git es una carpeta en la que trabajamos con git. En cuanto a repositorio local y remoto, uno local está guardado en nuestra máquina, mientras que uno remoto, se guardan en plataformas como Github o Gitlab, requiere de internet, ya que guarda la información en línea.

---
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
---
### Cómo usar Git?

Antes de empezar, se tiene que aclarar que necesitamos dar un nombre y un email esto es un requerimiento, tenemos que hacerlo obligatoriamente para trabajar con git, esto se hace con git config, el cual simplemente afectan como nuestro nombre y email aparece cada vez que hacemos un commit, si nos equivocamos, simplemente podemos usar el mismo método para arreglarlo:
             
              git config --global user.name "Nombre"  
              git config --global user.email "email"
             
Usa --global para ponerlo en cada repositorio en tu computadora.
Usa --local(el predeterminado) para ponerlo solo en el repositorio actual.

---
### Métodos basicos y generales de Git

Estos comandos se ejecutan en Git Bash (Terminal de Git en Windows)

1. **GIT INIT** Crea un repositorio git vacío en la carpeta en la que estamos, o también reinicializa uno existente. Se muestra como una carpeta llamada .git (y esta como una carpeta oculta). Este es el primer paso para usar comandos git en una carpeta.

2. **BRANCHES y GIT SWITCH**
  
   Por defecto, estamos dentro de la rama master/main/trunk (es lo mismo), la cual es la principal. Ahora veremos comandos para las ramas.
  
   2.1. **git branch** = crea una nueva rama desde el commit en el que estás o te menciona la rama en la que estas.
                     
                     git branch (muestra las ramas)
                     git branch ramita (crea una rama llamada ramita)
  
   2.2. **git branch -m nombre** = Renombra la rama en la que estás.
  
   2.3. **git switch nombreRama** = Te cambia de rama.
  
   Si en git log ves como hay también un "main" o "master" es porque ese es el último commit de la rama master. HEAD nos indica en qué commit nos encontramos.
  
   Para unir una rama a otra, tenemos q usar Merge

3. **MERGE**
  
   Une una rama a otra rama. ej: git merge 2daRama (la rama 2daRama con la rama se une en la rama que estamos)
  
   Al hacer merge, se crea un commit para juntar ambos. Los nuevos archivos que creamos en la segundaa rama se van a agregar a la primera.
  
   3.1 **Conflictos**

   Si editamos una parte de un archivo el cual ya tenía informacion, empiezan los conflictos, porque git no sabe con cuál de los 2 quedarse. 
   
   Git marca los conflictos de la siguiente forma:
   
        <<<<<<<< 
        Codigo Nuevo 
        =========== 
        Codigo Antiguo 
        >>>>>>>>>
   
   Lo que está en Codigo Nuevo, es el código que hicimos la rama donde esta el HEAD, y el Codigo Antiguo, es lo que hicimos en la otra rama. 
  
   Una vez solucionemos los problemas en los archivos, hacemos un git add a esos archivos y luego un git commit para poder hacer realmente el merge.

     
4. **GIT LOG y "Git Tree"**
  
   Git log nos muestra los commits que hemos hecho, cada commit tiene un identificador o hash (ese montón de caracteres)
  
   Si queremos verlo como un árbol, podemos hacer esto: git config --global alias.tree "log --graph --decorate --all --oneline". Ahora explicaremos lo que es un alias.

   
5. **GIT ALIAS**
  
   Permite asignarle un comando git a un nombre, ej: git config --global alias.historialRamas "log" Entonces, si ejecutamos el comando git historialRamas, se ejecuta el git log
  
6. **GIT STATUS** 
   
   Nos enseña si hay cambios que todavía no hemos hecho commit, o si están o no en el stage.

7. **GIT ADD Y GIT COMMIT**
      
   Git add se usa para subir cambios al stage y tiene 2 formas de usarse: 

   7.1. **git add documento** = Manda un documento con cambios al stage. Por ejemplo: git add archivito.py
   
   7.2. **git add .** = Manda todos los cambios al stage.
  
   ¿Qúe es y cómo hacer un commit? 
  
   7.3. **git commit -m "Mensaje"** = Crea un commit, el cual es como una versión de tus archivos, como una captura de pantalla de tus archivos, al cual puedes acceder en cualquier momento. 

 8. **GIT COMMIT --AMEND**
  
    Esto solo funciona para el último commit que hiciste.
  
    8.1. **Git commit --amend -m "Mensaje"**: Se usa igual que el git commit normal para hacer un commit, o sea, se usa después de un stage, pero en vez de crear un commit, reescribe el último, por ejemplo si agregamos cambios, y hacemos el amend, los cambios van a estar en el último commit, es como que estamos "tapandole agujeros por donde sale el agua", "poniendole curitas" NO CREA OTRO COMMIT, edita el último. 
  
    8.2. **git commit --amend --no-edit**: Es lo mismo que el primero, pero el no edit es para no tener que editar el mensaje del commit.

9. **GIT CHECKOUT**
              
   Cuando modificamos un archivo, por ejemplo el archivito.py, como ya tenemos un commit hecho antes, podemos usar esto para volver a como estaba en ese commit.
              
   9.1. **git checkout archivo** = Te restaura ese archivo a como estaba en el último commit.

   9.2. **git checkout** = Te restaura todo a como estaba en el último commit.
              
   Cuidado, checkout te regresa este archivo a como estaba en el último commit, perdiendo los cambios que realizarás EN CASO NO HAYAS HECHO UN COMMIT.
   
   Basicamente checkout vuelve al ultimo commit q hiciste por defecto. también puede hacer que un archivo vuelva a como estaba cuando.se hizo el ultimo commit.
              
   También podemos especificar a cuál commit queremos ir, por lo tanto podemos cambiar de posicion en la rama (también es posible pero se recomienda usar git switch en este caso).
                
10. **GIT RESET**

    Por defecto, si no especificamos el commit, hace referencia al último (el más reciente).
    También puede sacar un archivo del stage que estás haciendo.

    10.0. **Git reset archivo** = Te quita un archivo del stage.

    10.1. **Git reset** = Elimina el último commit, pero conservamos los cambios de forma local, tenemos que hacerle stage nosotros.

    10.2. **git reset --soft** = Elimina el último commit, pero conservamos los cambios de forma local y se quedan en stage. 

    10.3. **Git reset -h** = ELIMINA los commits después del commit en el que usemos este comando o del que especifiquemos. NO conserva los cambios de los commits siguientes.


    QUE PASA EN CASO HAY MAS COMMITS DESPUES?

    No importa, el reset normal y el soft conservan sus cambios.

11. **GIT REFLOG**
  
    Si nos equivocamos al hacer un git reset hard, ponemos este comando, y luego, tenemos que hacer git reset -h de nuevo, pero con el commit hasta el que queremos recuperar. 
  
    o sea: git reflog ---> git reset -h idCommit

12. **GIT REVERT**
  
    Borra el commit, pero enlaza el anterior commit con el siguiente commit (si es que existen)
   