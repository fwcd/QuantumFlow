package com.fwcd.quantumflow.qscheme.lib;

import com.fwcd.quantum.gates.binary.CNOTGate;
import com.fwcd.quantum.gates.binary.SqrtSwapGate;
import com.fwcd.quantum.gates.binary.SwapGate;
import com.fwcd.quantum.gates.ternary.CCNOTGate;
import com.fwcd.quantum.gates.ternary.CSwapGate;
import com.fwcd.quantum.gates.unary.HadamardGate;
import com.fwcd.quantum.gates.unary.PauliXGate;
import com.fwcd.quantum.gates.unary.PauliYGate;
import com.fwcd.quantum.gates.unary.PauliZGate;
import com.fwcd.quantum.gates.unary.SqrtNOTGate;
import com.fwcd.quantum.simulator.SimulatedSuperpos;
import com.fwcd.quantumflow.qscheme.QSUtils;
import com.fwcd.quantumflow.qscheme.QSchemeConsole;

/**
 * The "standard-library" of QScheme that extends the functions
 * provided by JScheme.
 */
public class QSchemeLib {
	private static final QSchemeExpression[] EXPRESSIONS = {
			new CustomExp("(define false QSUtils.FALSE$)", QSUtils.class),
			new CustomExp("(define true QSUtils.TRUE$)", QSUtils.class),
			new CustomExp("(define hadamard (HadamardGate.))", HadamardGate.class),
			new CustomExp("(define paulix (PauliXGate.))", PauliXGate.class),
			new CustomExp("(define pauliy (PauliYGate.))", PauliYGate.class),
			new CustomExp("(define pauliz (PauliZGate.))", PauliZGate.class),
			new CustomExp("(define not (HadamardGate.))", HadamardGate.class),
			new CustomExp("(define sqrtnot (SqrtNOTGate.))", SqrtNOTGate.class),
			new CustomExp("(define cnot (CNOTGate.))", CNOTGate.class),
			new CustomExp("(define sqrtswap (SqrtSwapGate.))", SqrtSwapGate.class),
			new CustomExp("(define swap (SwapGate.))", SwapGate.class),
			new CustomExp("(define ccnot (CCNOTGate.))", CCNOTGate.class),
			new CustomExp("(define cswap (CSwapGate.))", CSwapGate.class),
			
			new CustomExp("print", "(define (print s) (QSchemeConsole.print s))", QSchemeConsole.class),
			new CustomExp("println", "(define (println s) (QSchemeConsole.println s))", QSchemeConsole.class),
			new CustomExp("boolarray", "(define (boolarray bitlist) (QSUtils.toBoolArray (map (lambda (b) (if (eq? b 1) true false)) bitlist)))", QSUtils.class),
			new CustomExp("qsupos", "(define (qsupos bitlist) (SimulatedSuperpos. (boolarray bitlist)))", SimulatedSuperpos.class),
			new CustomExp("qgate", "(define (qgate gate qindex supos) (.apply supos gate qindex))"),
			new CustomExp("collapse", "(define (collapse supos) (QSUtils.toSchemeIntList (.collapse supos)))", QSUtils.class)
	};
	
	public QSchemeExpression[] getFunctions() {
		return EXPRESSIONS;
	}
}
