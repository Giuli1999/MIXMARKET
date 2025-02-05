/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author USUARIO
 */
public class Usuarios {
    
    private int id;
    private int DNI;
    private String name;
    private String lastNamePaternal;
    private String lastNameMaternal;
    private int codeVerification;
    private String codeVerificationLetter;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastNamePaternal() {
        return lastNamePaternal;
    }

    public void setLastNamePaternal(String lastNamePaternal) {
        this.lastNamePaternal = lastNamePaternal;
    }

    public String getLastNameMaternal() {
        return lastNameMaternal;
    }

    public void setLastNameMaternal(String lastNameMaternal) {
        this.lastNameMaternal = lastNameMaternal;
    }

    public int getCodeVerification() {
        return codeVerification;
    }

    public void setCodeVerification(int codeVerification) {
        this.codeVerification = codeVerification;
    }

    public String getCodeVerificationLetter() {
        return codeVerificationLetter;
    }

    public void setCodeVerificationLetter(String codeVerificationLetter) {
        this.codeVerificationLetter = codeVerificationLetter;
    }
    
    
    
}
