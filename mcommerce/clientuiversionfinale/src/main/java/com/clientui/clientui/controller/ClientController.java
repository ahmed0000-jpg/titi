package com.clientui.clientui.controller;

import com.clientui.clientui.beans.ProductBean;
import com.clientui.clientui.proxy.MicroservicesProduitsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private MicroservicesProduitsProxy microservicesProduitsProxy;
    @RequestMapping("/")
    public String acceuil(Model model)
    {
        List<ProductBean> listes=microservicesProduitsProxy.listeDesProduits();
        model.addAttribute("produits",listes);
        return "Acceuil";
    }
}
