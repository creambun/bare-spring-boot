package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Uoa;
import com.example.demo.models.UoaStatus;
import com.example.demo.models.UoaType;

@Service
public class UoaService {
	private final List<Uoa> uoas;
	private final List<Uoa> roUoas;
	
	public UoaService() {
		uoas = new ArrayList<>();
		roUoas = Collections.unmodifiableList(uoas);
		
		uoas.add(Uoa.builder().code("USD").type(UoaType.Currency).status(UoaStatus.Active).build());
		uoas.add(Uoa.builder().code("GBP").type(UoaType.Currency).status(UoaStatus.Active).build());
		uoas.add(Uoa.builder().code("BARREL").type(UoaType.Physical).status(UoaStatus.Pending).build());
	}
	
	public List<Uoa> getUoas() {
		return roUoas;
	}
	
	public Uoa getUoa(String code) {
		return roUoas.stream().filter(u -> u.getCode().equalsIgnoreCase(code)).findAny().orElse(null);
	}
}
