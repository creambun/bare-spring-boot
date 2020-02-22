package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.demo.models.Uoa;
import com.example.demo.models.UoaStatus;
import com.example.demo.models.UoaType;

public class TestUoaService {
	@Test
	public void testVisitor() {
		final String code = "1234";
		
		//==================
		// Currency
		//==================
		Uoa uoa = Uoa.builder().code(code).status(UoaStatus.Pending).type(UoaType.Currency).build();
		assertEquals(uoa.getDescription(), uoa.getDescriptionByVisitor());
		
		uoa = Uoa.builder().code(code).status(UoaStatus.Active).type(UoaType.Currency).build();
		assertEquals(uoa.getDescription(), uoa.getDescriptionByVisitor());
		
		uoa = Uoa.builder().code(code).status(UoaStatus.Inactive).type(UoaType.Currency).build();
		assertEquals(uoa.getDescription(), uoa.getDescriptionByVisitor());
		
		uoa = Uoa.builder().code(code).status(UoaStatus.Deleted).type(UoaType.Currency).build();
		assertEquals(uoa.getDescription(), uoa.getDescriptionByVisitor());
		
		//==================
		// Equity
		//==================
		uoa = Uoa.builder().code(code).status(UoaStatus.Pending).type(UoaType.Equity).build();
		assertEquals(uoa.getDescription(), uoa.getDescriptionByVisitor());
		
		uoa = Uoa.builder().code(code).status(UoaStatus.Active).type(UoaType.Equity).build();
		assertEquals(uoa.getDescription(), uoa.getDescriptionByVisitor());
		
		uoa = Uoa.builder().code(code).status(UoaStatus.Inactive).type(UoaType.Equity).build();
		assertEquals(uoa.getDescription(), uoa.getDescriptionByVisitor());
		
		uoa = Uoa.builder().code(code).status(UoaStatus.Deleted).type(UoaType.Equity).build();
		assertEquals(uoa.getDescription(), uoa.getDescriptionByVisitor());
		
		//==================
		// Physical
		//==================
		uoa = Uoa.builder().code(code).status(UoaStatus.Pending).type(UoaType.Physical).build();
		assertEquals(uoa.getDescription(), uoa.getDescriptionByVisitor());
		
		uoa = Uoa.builder().code(code).status(UoaStatus.Active).type(UoaType.Physical).build();
		assertEquals(uoa.getDescription(), uoa.getDescriptionByVisitor());
		
		uoa = Uoa.builder().code(code).status(UoaStatus.Inactive).type(UoaType.Physical).build();
		assertEquals(uoa.getDescription(), uoa.getDescriptionByVisitor());
		
		uoa = Uoa.builder().code(code).status(UoaStatus.Deleted).type(UoaType.Physical).build();
		assertEquals(uoa.getDescription(), uoa.getDescriptionByVisitor());
		
		//==================
		// Countable
		//==================
		uoa = Uoa.builder().code(code).status(UoaStatus.Pending).type(UoaType.Countable).build();
		assertEquals(uoa.getDescription(), uoa.getDescriptionByVisitor());
		
		uoa = Uoa.builder().code(code).status(UoaStatus.Active).type(UoaType.Countable).build();
		assertEquals(uoa.getDescription(), uoa.getDescriptionByVisitor());
		
		uoa = Uoa.builder().code(code).status(UoaStatus.Inactive).type(UoaType.Countable).build();
		assertEquals(uoa.getDescription(), uoa.getDescriptionByVisitor());
		
		uoa = Uoa.builder().code(code).status(UoaStatus.Deleted).type(UoaType.Countable).build();
		assertEquals(uoa.getDescription(), uoa.getDescriptionByVisitor());
	}
}
