package com.dupas.fy;


public class User {
    private String account;
    private Song[] history;
    
  
    public User(){}

    public User(String new_account){
		this.account = new_account;
	}
	


    public String getAccount() {
        return account;
    }
    
    public void setAccount(String account) {
        this.account = account;
    }
   
    public Song[] getHistory() {
        return history;
    }
    
    public void setHistory(Song[] history) {
        this.history = history;
    }
}
