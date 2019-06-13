package com.rafael.gerenciador.main.web.error;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Component
public class MyErrorView implements ErrorViewResolver {

	/*
	 * @Override public ModelAndView resolveErrorView(HttpServletRequest request,
	 * HttpStatus status, Map<String, Object> map) {
	 * 
	 * ModelAndView model = new ModelAndView("error"); model.addObject("status",
	 * status.value()); switch (status.value()) { case 404: model.addObject("error",
	 * "página não encontrada." ); model.addObject("message",
	 * "A url para a página'"+map.get("path")+"'não existe"); break; case 500:
	 * model.addObject("error", "Ocorreu um erro Interno no servidor." );
	 * model.addObject("message", "Ocorreu um erro Inesperado, tente mais tarde");
	 * break; default: model.addObject("error", map.get("error") );
	 * model.addObject("message", status.getReasonPhrase()); break; } return model;
	 * }
	 */

	/**
	 * Resolver para erros HTTP.
	 * 
	 * @author rafael_franca 22/05/2019
	 * @return ModelAndView
	 */
	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> map) {

		Exception exception = new Exception(status.getReasonPhrase());
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), 0,
				"Exception: " + exception.getMessage(), exception.toString(), request.getRequestURL().toString()
						+ (request.getQueryString() != null ? "?" + request.getQueryString() : ""));
		exception.printStackTrace();
		request.setAttribute("systemException", err);

		return new ModelAndView("error");
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception e, HttpServletRequest request) {

		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), 0,
				"Exception: " + e.getMessage(), e.toString(), request.getRequestURL().toString()
						+ (request.getQueryString() != null ? "?" + request.getQueryString() : ""));
		request.setAttribute("systemException", err);
		e.printStackTrace();
		return new ModelAndView("error");
	}

}
