/*------------------------------------------------------------------------------
 * Nom de la classe : NetworkFile
 * Produit : Rondo
 * Module : Modele
 * Auteurs : Myfowo
 * CCopyright (c) 2017 Myfowo
 * 1e version : 30 mai 2017
 *------------------------------------------------------------------------------
 * Description :
 * Objet permettant de decrire et transporter un fichier au sein du reseau
 *------------------------------------------------------------------------------
 * v 1.0
 * Auteur : 
 * 1e version de la classe, avec les parametres importants 
 *------------------------------------------------------------------------------
 */
package com.globalsaas.rondo.model.service;

public class NetworkFile implements java.io.Serializable{
    //private static final long serialVersionUID = 1L;
    private String name; // Nom du fichier
    private String type; // Suffixe du fichier
    private byte[] data; // Donnees du fichier
    private Fichier userObject; // Descripteur en BD du fichier joint
    
    /** Creates a new instance of NetworkFile */
    public NetworkFile() {
    }
    public NetworkFile(String name, String type) {
        this.name=name;
        this.type=type;
    }
    public NetworkFile(String name, String type, int size) {
        this.name=name;
        this.type=type;
        this.data = new byte[size];
    }
    
    public NetworkFile(String name, String type, byte[] data) {
        this.name=name;
        this.type=type;
        this.data = data;
    }
    
    public byte[] getData() {
        return this.data;
    }
    public void setData(byte[] data) {
        this.data = data;
    }

    public byte getDataValue(int i) {
        return this.data[i];
    }
    public void setData(int i, byte value) {
        this.data[i] = value;
    }

    public java.lang.String getName() {
        return name;
    }
    public void setName(java.lang.String name) {
        this.name = name;
    }
    
    public java.lang.String getType() {
        return type;
    }
    public void setType(java.lang.String type) {
        this.type = type;
    }
    public Fichier getUserObject() {
        return userObject;
    }
    public void setUserObject(Fichier userObject) {
        this.userObject = userObject;
    }
    
}
