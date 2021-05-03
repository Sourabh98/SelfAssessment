package com.telusko.demorest;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Alien.class)
public class AlienList {

	private List<Alien> alienList;

	@XmlElement
	public List<Alien> getAlienList() {
		return alienList;
	}

	public void setAlientList(List<Alien> alienList) {
		this.alienList = alienList;
	}

}
