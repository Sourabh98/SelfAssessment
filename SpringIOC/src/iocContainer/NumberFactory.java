package iocContainer;

import entity.*;
import entity.Number;

public class NumberFactory {
	
	private  String numberType;
	
	public NumberFactory(String numberType)
	{
		this.numberType=numberType;
	}
	
	public Number getNumber()
	{
		
		if(this.numberType.equalsIgnoreCase("complex"))
		{
			return Complex2.getComplex2();
		}
		else if(this.numberType.equalsIgnoreCase("rational"))
		{
			return Rational2.getRational2();
		}
		return null;
	}

}
