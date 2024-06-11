package com.lgs;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lgs.auxiliares.AuxMethods;
import com.lgs.auxiliares.CalcFunc;
import com.lgs.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

	private static final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!AuxMethods.isNumeric(numberOne) || !AuxMethods.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return   CalcFunc.sum(AuxMethods.convertToDouble(numberOne),AuxMethods.convertToDouble(numberTwo)) ;
	}

	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!AuxMethods.isNumeric(numberOne) || !AuxMethods.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return   CalcFunc.sub(AuxMethods.convertToDouble(numberOne),AuxMethods.convertToDouble(numberTwo)) ;	}

	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!AuxMethods.isNumeric(numberOne) || !AuxMethods.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return   CalcFunc.div(AuxMethods.convertToDouble(numberOne),AuxMethods.convertToDouble(numberTwo)) ;
	}

	@RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double average(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!AuxMethods.isNumeric(numberOne) || !AuxMethods.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return   CalcFunc.average(AuxMethods.convertToDouble(numberOne),AuxMethods.convertToDouble(numberTwo)) ;
	}

	@RequestMapping(value = "/squareroot/{numberOne}", method = RequestMethod.GET)
	public Double squareroot(@PathVariable(value = "numberOne") String numberOne) throws Exception {
		if (!AuxMethods.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return Math.sqrt(AuxMethods.convertToDouble(numberOne));
	}

}
