    package com.lista.listadetareas.riuz.unbording.accounts;

    public class userData {

        private static String nombre;
        private static String id;
        private static String correo;
        private static String token;
        private static String apellido;
        private static boolean baneo;

        public boolean getBaneo () {
            return userData.baneo;
        }
        public void setBaneo (boolean baneo) {
            userData.baneo = baneo;
        }
        public String getNombre() {
            return nombre;
        }
        public String getId() {
            return id;
        }
        public String getCorreo() {
            return correo;
        }
        public String getToken() {
            return token;
        }
        public String getApellido() {
            return apellido;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public void setId(String id) {
            this.id = id;
        }
        public void setCorreo(String correo) {
            this.correo = correo;
        }
        public void setToken(String token) {
            this.token = token;
        }
        public void setApellido(String apellido) {
            this.apellido = apellido;
        }
    }

