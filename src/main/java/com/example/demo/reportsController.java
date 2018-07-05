package com.example.demo;

import com.example.demo.ServiceImpl.BrandServiceImpl;
import com.example.demo.ServiceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class reportsController {

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    ProductServiceImpl poductService;

    @RequestMapping(path = "/products/{businessId}", method = RequestMethod.GET)
    public ModelAndView reportProducts(@PathVariable String businessId) {

        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:reports/products.jrxml");
        view.setApplicationContext(appContext);

        Map<String, Object> params = new HashMap<>();
        params.put("datasource", poductService.getAll().stream().filter(ee -> {
            return ee.getBusiness().getId() == Integer.parseInt(businessId);
        }).collect(Collectors.toSet()));

        return new ModelAndView(view, params);
    }


    @RequestMapping(path = "/productUnits/{businessId}", method = RequestMethod.GET)
    public ModelAndView reportProductsUnits(@PathVariable String businessId) {

        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:reports/productUnits.jrxml");
        view.setApplicationContext(appContext);

        Map<String, Object> params = new HashMap<>();
        params.put("datasource", poductService.getAll().stream().filter(ee -> {
            return ee.getUnitStock() <= 3;
        }).collect(Collectors.toSet()));

        return new ModelAndView(view, params);
    }


}
