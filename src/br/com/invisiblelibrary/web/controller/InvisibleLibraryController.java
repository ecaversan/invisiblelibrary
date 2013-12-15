package br.com.invisiblelibrary.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

public class InvisibleLibraryController extends SimpleFormController {

	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		// TODO Auto-generated method stub
		super.initBinder(request, binder);
	}

	protected ModelAndView disallowDuplicateFormSubmission(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BindException errors = getErrorsForNewForm(request);
		errors.reject("duplicateFormSubmission", "Duplicate form submission");
		return showForm(request, response, errors);
	}

	protected final ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object commandObject,
			BindException errors) throws Exception {
		try {
			return new ModelAndView("index.jsp");
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
			throw e;
		}
	}

}
