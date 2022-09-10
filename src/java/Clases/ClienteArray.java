/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

public class ClienteArray {
    
ClientModell[] clientTable;
    int indexArray;
    
    public ClienteArray(){
        clientTable = new ClientModell[100];
        this.indexArray = 0;
    }
    
public void saveClient(ClientModell client){
        this.clientTable[this.indexArray] = client;
        this.indexArray = this.indexArray + 1;
    }
    
    public ClientModell[] getClient(){
        return clientTable;
    }

    public void deleteClient(String position){
          int pos = Integer.parseInt(position);
          this.clientTable[pos] = null;
          for(int i = pos; i < indexArray - 1; i++) {
                this.clientTable[i] = this.clientTable[i + 1];
          }
//          this.clientTable[indexArray - 1] = null;
//          indexArray --;
    }

}
