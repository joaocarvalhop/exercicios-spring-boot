package br.com.joaocarvalhop.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

	// tinha esquecido do @PathVariable por isso não tava indo

	// /calculadora/somar/10/20
	@GetMapping("/somar/{a}/{b}")
	public int somar(@PathVariable int a, @PathVariable int b) {
		return a + b;
	}

	// quando tem ? é usado o @RequestParam

	// /calculadora/subtrair?a=100&b=39
	@GetMapping("/subtrair")
	public int subtrair(@RequestParam(name = "a") int a, @RequestParam(name = "b") int b) {
		return a - b;
	}

	// /calculadora/multiplicar/100/39
	@GetMapping("/multiplicar/{a}/{b}")
	public int multiplicar(@PathVariable int a, @PathVariable int b) {
		return a * b;
	}

	// /calculadora/dividir?a=100&b=39
	@GetMapping("/dividir")
	public int dividir(@RequestParam(name = "a") int a, @RequestParam(name = "b") int b) {
		return a / b;
	}
}
