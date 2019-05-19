package com.example.demo;

import com.example.demo.model.Binary;
import com.example.demo.model.Decimal;
import com.example.demo.model.Hexadecimal;
import com.example.demo.model.Roman;
import com.example.demo.service.converter.*;
import org.junit.Assert;
import org.junit.Test;

public class ConvertersTests {

	@Test
	public void DecimalToBinaryTest() {
		DecimalBinaryConverter converter = new DecimalBinaryConverter();

		Assert.assertEquals(new Binary("0").getValue(), converter.convert(new Decimal("0")).getValue());
		Assert.assertEquals(new Binary("111").getValue(), converter.convert(new Decimal("7")).getValue());
		Assert.assertEquals(new Binary("1010").getValue(), converter.convert(new Decimal("10")).getValue());
	}

	@Test
	public void DecimalToHexTest() {
		DecimalHexConverter converter = new DecimalHexConverter();

		Assert.assertEquals(new Hexadecimal("0").getValue(), converter.convert(new Decimal("0")).getValue());
		Assert.assertEquals(new Hexadecimal("7").getValue(), converter.convert(new Decimal("7")).getValue());
		Assert.assertEquals(new Hexadecimal("a").getValue(), converter.convert(new Decimal("10")).getValue());
		Assert.assertEquals(new Hexadecimal("10").getValue(), converter.convert(new Decimal("16")).getValue());

	}

	@Test
	public void DecimalToRomanTest() {
		DecimalRomanConverter converter = new DecimalRomanConverter();

		Assert.assertEquals(new Roman("I").getValue(), converter.convert(new Decimal("1")).getValue());
		Assert.assertEquals(new Roman("II").getValue(), converter.convert(new Decimal("2")).getValue());
		Assert.assertEquals(new Roman("VII").getValue(), converter.convert(new Decimal("7")).getValue());
	}

	@Test
	public void HexToDecimalTest() {
		HexDecimalConverter converter = new HexDecimalConverter();

		Assert.assertEquals(new Decimal("0").getValue(), converter.convert(new Hexadecimal("0")).getValue());
		Assert.assertEquals(new Decimal("1").getValue(), converter.convert(new Hexadecimal("1")).getValue());
		Assert.assertEquals(new Decimal("10").getValue(), converter.convert(new Hexadecimal("a")).getValue());
		Assert.assertEquals(new Decimal("255").getValue(), converter.convert(new Hexadecimal("ff")).getValue());

	}

	@Test
	public void BinToDecimalTest(){
		BinaryDecimalConverter converter = new BinaryDecimalConverter();

		Assert.assertEquals(new Decimal("0").getValue(), converter.convert(new Binary("0")).getValue());
		Assert.assertEquals(new Decimal("7").getValue(), converter.convert(new Binary("111")).getValue());
		Assert.assertEquals(new Decimal("10").getValue(), converter.convert(new Binary("1010")).getValue());
	}

}
