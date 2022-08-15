package src.Conta;

import java.util.ArrayList;

public class Conta {
   public String usuario;
   protected String senha;

   public String getUser(){
      return this.usuario;
   }

   public String getPass(){
      return this.senha;
   }
   
   public void setUser(String value){
      this.usuario = value;
   }

   public void setPass(String value){
      this.senha = value;
   }

   public boolean equals(Conta adm){
      return this.getUser().equals(adm.getUser()) && this.getPass().equals(adm.getPass());
  }

   public boolean equalsUser(Conta adm){
      return this.getUser().equals(adm.getUser());
   }
}
