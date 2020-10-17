package com.example.practica9;

import android.util.Log;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class UDPConnection extends Thread{

    private DatagramSocket socket;

    @Override
    public void run() {

        try {
            //1. Escucha
            socket = new DatagramSocket(6000);


            //2. Esperar mensajes: Datagramas
            while(true) {

                byte[] buffer = new byte[100];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                Log.e(">>>>>>>>>","Esperando datagrama");
                //System.out.println(packet.getSocketAddress());

                //3. Esperando datagrama
                socket.receive(packet);
                String mensaje = new String(packet.getData()).trim();

                Log.e(">>>>>>>","Datagrama recibido:"+mensaje);

            }

        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void sendMessage(String mensaje) {

        new Thread(
                () -> {

                    try {
                        //4. datagrama de envio
                        InetAddress ip = InetAddress.getByName("192.168.0.133");
                        DatagramPacket packet = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, ip, 5000);
                        socket.send(packet);


                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
        ).start();
    }

}

