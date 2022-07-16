package com.aplicacion.ejercicio24.Configuraciones;

public class Signaturess {
    // Nombre de la base de datos
    public static final String NameDatabase = "DBFIRMA";


    public static final String tablafirma = "Firma";

    public static final String id = "id";
    public static final String descripcion = "descripcion";
    public static final String firmaDigital = "firmaDigital";



    public static final String CreateTableFirma = "CREATE TABLE firma" +
            "( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "descripcion TEXT" +
            "firmaDigital BLOB)";

    public static final String DropTableFirma ="DROP TABLE IF EXISTS firma";
    //Seleccionar todas las personas
    public static final String SELECT_ALL_TABLE_PICTURE = "SELECT * FROM " + tablafirma;
}
