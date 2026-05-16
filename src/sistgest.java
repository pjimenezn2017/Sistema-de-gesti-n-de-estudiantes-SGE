import java.util.ArrayList;
import java.util.Scanner;

//Clase Estudiante para representar a cada estudiante con sus atributos
class Estudiante {
    //Atributos de la clase estudiante
    private int id;
    private String nombre;
    private int edad;
    private String carrera;

    //Constructor de la clase estudiante para inicializar los atributos
    public Estudiante(int id, String nombre, int edad, String carrera) {
        this.id =id;
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
    }
    //metodo para obtener el id del estudiante
    public int getId()
    {
        return id;
    }
    //Convierte el objeto estudiante a una cadena de texto para mostrar su información de manera legible
    @Override
    public String toString() {
        return "\nID: " +id +"\tNombre: " + nombre + "\tEdad: " + edad+ "\tCarrera: "+ carrera;
                        }
    }

public class sistgest {
    //scanner para leer las entradas del usuario
    static Scanner scanner = new Scanner(System.in);
    //lista dinamica para guardar los estudiantes registrados
    static ArrayList<Estudiante> lista = new ArrayList<>();
    //bandera para controlar la salida del programa
    static boolean banderaSalir = false;
    //Contador para llevar el registro del numero de estudiantes registrados
    static int contador = 0;
    

    public static void main(String[] args) {
       //Ciclo del menu principal
        while (!banderaSalir) {
            mostrarMenu();
            //Captura la opcion seleccionada por el usuario y ejecuta la accion correspondiente
            int opcion = leerEntero("");
            //Estructura multiple para escoger las opciones del menu
            switch (opcion) {
                case 1:
                    agregarEstudiante();
                    break;
                case 2:
                    mostrarEstudiantes();
                    break;
                case 3:
                    buscarPorId();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema de gestión academica...");
                    banderaSalir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
    //Mostrar menu principal
    static void mostrarMenu() {
        System.out.println("\nMenu Sistema de gestion de estudiantes");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agregar estudiante");
        System.out.println("2. Mostrar estudiantes");
        System.out.println("3. Buscar estudiante por ID");
        System.out.println("4. Salir");
    }        
    
    static void agregarEstudiante() {
        int id = 0;
        boolean idValido = false;
       //Verifica el ID ingresado por el usuario para asegurarse de que sea único antes de agregar un nuevo estudiante a la lista 
        while (!idValido) {
            id = leerEntero("Ingrese el ID del estudiante:");
            if (existeId(id)) {
                System.out.println("El ID ya existe. Por favor, ingrese un ID único.");
            } else {
                idValido = true;
            }
        }
        
        System.out.println("Ingrese el nombre del estudiante:");
        String nombre = scanner.nextLine();
        int edad = leerEntero ("Ingrese la edad del estudiante:");
        System.out.println("Ingrese la carrera del estudiante:");
        String carrera = scanner.nextLine();
        
        //Almacena estudiante en la lista
        lista.add(new Estudiante(id, nombre, edad, carrera));
        contador++;
        System.out.println("Estudiante agregado exitosamente.");
    }

    static void mostrarEstudiantes() {
        //verifica que no existan estudiantes registrados
        if (lista.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        } else {
            System.out.println("\nLista de estudiantes:");
            //Recorre la lista completa para buscar al estudiante por su ID
            for (Estudiante estudiante : lista) {
                System.out.println(estudiante);
            }
        System.out.println("Total de estudiantes registrados: " +contador);
            }
        }   


        static void buscarPorId() {
            int id = leerEntero("Ingrese el ID del estudiante a buscar:");
            //bandera para indicar si se encontro el estudiante con el ID ingresado por el usuario
            boolean encontrado = false;

            for (Estudiante estudiante : lista) {
                if (estudiante.getId() == id) {
                    System.out.println("Estudiante encontrado: " + estudiante);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Estudiante no encontrado.");
            }
                
    }
    //verificar si el ID ingresado ya existe
    static boolean existeId(int id) {
        for (Estudiante estudiante : lista) {
            if (estudiante.getId() == id) {
                return true;
            }
        }
        return false;
    }

    static int leerEntero(String mensaje) {
        int numero;
        while (true) {
            System.out.println(mensaje);
            try {
                numero = Integer.parseInt(scanner.nextLine());
                return numero;
            } catch (NumberFormatException e) {
                //evita que el usuario ingrese un valor no numerico y le solicita que intente nuevamente
                System.out.println("Entrada no válida. Por favor, intente nuevamente.");
            }
        }
    }
}

