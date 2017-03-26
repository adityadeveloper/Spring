package com.rcpfc.errors.controlller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rcpfc.base.BaseController;

@Controller
public class ErrorController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);
	
	@RequestMapping(value = "/errors", method = {RequestMethod.GET, RequestMethod.POST})
    public ErrorResponseVO renderErrorPage(HttpServletRequest httpRequest) {
		
        //ModelAndView errorPage = new ModelAndView("errorPage");
		ErrorResponseVO errorResponse = new ErrorResponseVO();
        String errorMsg = "";
        int httpErrorCode = getErrorCode(httpRequest);
 
        switch (httpErrorCode) {
            case 400: {
                errorMsg = "Bad Request";
                break;
            }
            case 401: {
                errorMsg = "Unauthorized";
                break;
            }
            case 404: {
                errorMsg = "Resource Not Found";
                break;
            }
            case 405: {
                errorMsg = "Method Not Allowed";
                break;
            }
            case 500: {
                errorMsg = "Internal Server Error";
                break;
            }
        }
  /*      logger.info("Error code : "+httpErrorCode);
        errorPage.addObject("errorMsg", errorMsg);
        return errorPage;*/
        logger.error("Error Occurred. Error code : "+httpErrorCode+"\tError Message : "+errorMsg);
        
        errorResponse.setErrorCode(String.valueOf(httpErrorCode));
        errorResponse.setErrorMessage(errorMsg);
        
        return errorResponse;
    }
     
    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
          .getAttribute("javax.servlet.error.status_code");
    }
}
