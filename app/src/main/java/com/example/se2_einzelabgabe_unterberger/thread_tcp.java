package com.example.se2_einzelabgabe_unterberger;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class thread_tcp extends Thread {
    private String nachricht;
    private String server_output;
    static Socket clientSocket = null;


    private static final int SERVERPORT = 53212;
    private static final String SERVER = "se2-isys.aau.at";


    thread_tcp(String nachricht) {
        this.nachricht = nachricht;
    }

    public String getServer_output() {
        return this.server_output;
    }

    @Override


    public void run() {
        try {
            clientSocket = new Socket(SERVER, SERVERPORT);
            try {
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                outToServer.writeBytes(nachricht + "\n");
                server_output = inFromServer.readLine();



            } catch (Exception e) {
                Log.e("fail",e.toString());
                throw e;
            }


            finally {
                if (clientSocket != null) {
                    clientSocket.close();
                }
            }
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}















