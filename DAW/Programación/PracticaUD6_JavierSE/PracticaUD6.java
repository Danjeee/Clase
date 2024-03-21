import java.util.*;
public class PracticaUD6 {
    static Scanner sc = new Scanner(System.in);
    static String generaDNI(){
        String dni = "";
        int rn1 = 99999999-10000000+1;
        int rn2 = 90-65+1;
        dni += Integer.toString((int)(Math.random()*rn1)+10000000);
        dni += Character.toString((char)(Math.random()*rn2)+65);
        return dni;
    }
    public static void main(String[] args) {
        Map<String, Paciente> pacientes = new HashMap<>();
        Map<String, PersonalHospital> medicos = new HashMap<>();
        Map<Integer, Consulta> consultas = new HashMap<>();

        // INICIALIZAR EJEMPLOS, SE PUEDE BORRAR O COMENTAR //
        
        pacientes.put("11223344A", new Paciente("Juan García Rodriguez", "11223344A"));
        pacientes.put("12332112B", new Paciente("Elena Zamora Pineda", "12332112B"));
        pacientes.put("43243344E", new Paciente("Ruben Mijas Tormo", "43243344E"));
        medicos.put("43243344S", new Enfermero("Ramón lopez", 'M', 1, "43243344S"));
        medicos.put("12345678P", new Enfermero("Marisa Ruiz", 'F', 2, "12345678P"));
        medicos.put("69696969H", new Medico("Eloisa Blazquez", 'F', "Electrocardiograma", "69696969H"));
        consultas.put(Consulta.totalConsultas, new Consulta("Analitica"));
        consultas.put(Consulta.totalConsultas, new Consulta("Electrocardiograma"));
        consultas.get(0).añadirconsulta(pacientes.get("11223344A"));
        consultas.get(0).añadirconsulta(pacientes.get("12332112B"));
        consultas.get(0).añadirconsulta(pacientes.get("43243344E"));
        consultas.get(1).añadirconsulta(pacientes.get("11223344A"));
        pacientes.get("11223344A").añadirconsulta("- " +consultas.get(0) +" (Atendido por " +medicos.get("43243344S").getApodo() +" " +medicos.get("43243344S").getNombre() +")");
        pacientes.get("11223344A").añadirconsulta("- " +consultas.get(0) +" (Atendido por " +medicos.get("12345678P").getApodo() +" " +medicos.get("12345678P").getNombre() +")");
        pacientes.get("11223344A").añadirconsulta("- " +consultas.get(1) +" (Atendido por " +medicos.get("69696969H").getApodo() +" " +medicos.get("69696969H").getNombre() +")");
        pacientes.get("12332112B").añadirconsulta("- " +consultas.get(0) +" (Atendido por " +medicos.get("43243344S").getApodo() +" " +medicos.get("43243344S").getNombre() +")");
        pacientes.get("43243344E").añadirconsulta("- " +consultas.get(0) +" (Atendido por " +medicos.get("69696969H").getApodo() +" " +medicos.get("69696969H").getNombre() +")");
        
        // FIN EJEMPLOS //

        boolean exit = false;
        while (!exit){
            System.out.println("""
                    Menu
                    1.- Añadir Paciente
                    2.- Iniciar Consulta
                    3.- Añadir Medico
                    4.- Añadir Enfermero
                    5.- Ver pacientes
                    6.- Ver enfermeros
                    7.- Ver medicos
                    8.- Ver personal
                    9.- Ver consultas
                    0.- Salir
                    """);
            int menu = sc.nextInt();
            switch (menu) {
                case 1 -> {
                    System.out.println("Nombre del paciente: ");
                    String nombre = sc.next();
                    boolean corr = false;
                    String dni; 
                    dni = "";
                    while (!corr) {
                        dni = generaDNI();
                        corr = true;
                        if (pacientes.containsKey(dni)) {
                            corr = false;
                            dni = generaDNI();
                        }
                    }
                    pacientes.put(dni, new Paciente(nombre, dni));
                }
                case 2 -> {
                    if (pacientes.isEmpty()) {
                        System.out.println("No hay pacientes, añada uno primero");
                        break;
                    }
                    if (medicos.isEmpty()) {
                        System.out.println("No hay personal, añada un medico/enfermero primero");
                        break;
                    }
                    System.out.println("DNI del paciente: ");
                    for (Paciente i : pacientes.values()) {
                        System.out.println(i.getDNI() +": " +i.getNombre());
                    }
                    String keyp = sc.next();
                    if (!pacientes.containsKey(keyp)) {
                        System.out.println("Ese paciente no existe, intentalo de nuevo");
                        break;
                    }
                    System.out.println("Numero del personal: ");
                    for (PersonalHospital i : medicos.values()) {
                        System.out.println(i.getDNI() +": " +i.getNombre());
                    }
                    String keym = sc.next();
                    if (!medicos.containsKey(keym)) {
                        System.out.println("Ese medico no existe, intentalo de nuevo");
                        break;
                    }
                    System.out.println("Tipo de consulta: ");
                    for (int i=0; i<consultas.size(); i++){
                        System.out.println(i +" " +consultas.get(i));
                    }
                    int consulta;
                    if (consultas.isEmpty()) {
                        System.out.println("No hay consultas aun, vamos a crear la primera");
                        System.out.println("Como se llama el tipo de consulta (Pulse -1 si quiere añadir un tipo no existente)");
                        String tipo =  sc.next();
                        consulta = Consulta.totalConsultas;
                        consultas.put(Consulta.totalConsultas, new Consulta(tipo));
                    } else {
                        consulta = sc.nextInt();
                        if (!consultas.containsKey(consulta)) {
                        System.out.println("Este tipo de consultas no existe, ¿quiere añadir un nuevo tipo de consultas?");
                        String res = sc.next();
                        res = res.toLowerCase();
                        if (res.charAt(0) == 's') {
                            System.out.println("Como se llama el tipo de consulta");
                            String tipo =  sc.next();
                            consultas.put(Consulta.totalConsultas, new Consulta(tipo));
                        } else {
                            break;
                        }
                    }}
                    consultas.get(consulta).añadirconsulta(pacientes.get(keyp));
                    pacientes.get(keyp).añadirconsulta("- " +consulta +" (Atendido por " +medicos.get(keym).getApodo() +" " +medicos.get(keym).getNombre());
                }
                case 3 -> {
                    System.out.println("Nombre del medico: ");
                    String nombre = sc.next();
                    System.out.println("Genero: (M o F)");
                    char g = sc.next().charAt(0);
                    System.out.println("Especialidad: ");
                    String especialidad = sc.next();
                    boolean corr = false;
                    String dni = ""; 
                    while (!corr) {
                        dni = generaDNI();
                        corr = true;
                        if (pacientes.containsKey(dni)) {
                            corr = false;
                            dni = generaDNI();
                        }
                    }
                    medicos.put(dni , new Medico(nombre, g, especialidad, dni));
                }
                case 4 -> {
                    System.out.println("Nombre del Enfermero: ");
                    String nombre = sc.next();
                    System.out.println("Genero: (M o F)");
                    char g = sc.next().charAt(0);
                    System.out.println("Planta: ");
                    int planta = sc.nextInt();
                    boolean corr = false;
                    String dni; 
                    dni ="";
                    while (!corr) {
                        dni = generaDNI();
                        corr = true;
                        if (pacientes.containsKey(dni)) {
                            corr = false;
                            dni = generaDNI();
                        }
                    }
                    medicos.put(dni , new Enfermero(nombre, g, planta, dni));
                }
                case 5 -> {
                    if (pacientes.isEmpty()) {
                        System.out.println("No hay ningun paciente, añada uno");
                        break;
                    }
                    for (Paciente i : pacientes.values()) {
                        System.out.println(i.getDNI() +": " +i.getNombre());
                    }
                    System.out.println("¿Quiere ver las consultas de algun paciente?");
                    String res = sc.next();
                    res = res.toLowerCase();
                    if (res.charAt(0) == 's') {
                        System.out.println("De quien");
                        String pac = sc.next();
                        if (pacientes.containsKey(pac)) {
                            pacientes.get(pac).getConsultas();
                        } else {
                            System.out.println("Ese paciente no existe, vuelve a intentarlo");
                        }
                    }
                }
                case 6 -> {
                    boolean hay = false;
                    for (PersonalHospital i : medicos.values()) {
                        if (i.getClass().getSimpleName().equals("Enfermero")) {
                            System.out.println(i.getDNI() +": " +i);
                            hay = true;
                        }
                    }
                    if (!hay) {
                        System.out.println("No hay enfermeros, añada uno");
                    }
                }
                case 7 -> {
                    boolean hay = false;
                    for (PersonalHospital i : medicos.values()) {
                        if (i.getClass().getSimpleName().equals("Medico")) {
                            System.out.println(i.getDNI() +": " +i);
                            hay = true;
                        }
                    }
                    if (!hay) {
                        System.out.println("No hay medicos, añada uno");
                    }
                }
                case 8 -> {
                    if (medicos.isEmpty()) {
                        System.out.println("No hay personal, añada un medico y/o enfermero");
                    }
                    for (Paciente i : pacientes.values()) {
                        System.out.println(i.getDNI() +": " +i);
                    }
                }
                case 9 -> {
                    System.out.println("Que tipo de consulta quiere ver (Numero)");
                    for (int i=0; i<consultas.size(); i++){
                        System.out.println(i +" " +consultas.get(i));
                    }
                    int cons = sc.nextInt();
                    if (!consultas.containsKey(cons)) {
                        System.out.println("Esa consulta no existe, intentalo de nuevo");
                    } else {
                        consultas.get(cons).mostrarConsultas();
                    }
                }
                case 0 -> {
                    exit = true;
                }
            }
        }
    }
}