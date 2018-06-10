package com.example.demo;

import com.example.demo.ServiceImpl.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class reportsController {

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    BrandServiceImpl brandService;

    @RequestMapping(path = "/pdf", method = RequestMethod.GET)
    public ModelAndView report() {

        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:reports/report1.jrxml");
        view.setApplicationContext(appContext);

        Map<String, Object> params = new HashMap<>();
        params.put("datasource", brandService.getAll());

        return new ModelAndView(view, params);
    }

}
