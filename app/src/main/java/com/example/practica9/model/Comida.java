package com.example.practica9.model;

    public class Comida {
        String fecha, type;
        int num, x, y;


        public Comida(){
        }


        public Comida(String type,int num, int y, String fecha){
            this.fecha = fecha;
            this.type = type;
            this.x = 240;
            this.y = y;
            this.num = num;

            //app.image(comida, x-170, y-50, 150,120);
        }


        public String getFecha() {
            return fecha;
        }
        public void setFecha(String fecha) {
            this.fecha = fecha;
        }
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
        public int getNum() {
            return num;
        }
        public void setNum(int num) {
            this.num = num;
        }
        public int getX() {
            return x;
        }
        public void setX(int x) {
            this.x = x;
        }
        public int getY() {
            return y;
        }
        public void setY(int y) {
            this.y = y;
        }
    }
