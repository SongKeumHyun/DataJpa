package com.song.communicatioins;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("tib")
public class TibConfigration {
	
	private String netwrok;
	
	private String deamon;
	
	private String service;
	
	private String sendSubject;
	
	private String reciveSubject;

	public String getNetwrok() {
		return netwrok;
	}


	public void setNetwrok(String netwrok) {
		this.netwrok = netwrok;
	}


	public String getDeamon() {
		return deamon;
	}


	public void setDeamon(String deamon) {
		this.deamon = deamon;
	}


	public String getService() {
		return service;
	}


	public void setService(String service) {
		this.service = service;
	}


	public String getSendSubject() {
		return sendSubject;
	}


	public void setSendSubject(String sendSubject) {
		this.sendSubject = sendSubject;
	}


	public String getReciveSubject() {
		return reciveSubject;
	}


	public void setReciveSubject(String reciveSubject) {
		this.reciveSubject = reciveSubject;
	}



	
	
	@Override
	public String toString() {
		return "TibConfigration [netwrok=" + netwrok + ", deamon=" + deamon + ", service=" + service + ", SendSubject="
				+ sendSubject + ", ReciveSubject=" + reciveSubject + "]";
	}


}
