package com.shop.controllers;

import com.shop.storage.Warehouse;
import com.shop.support.DatabaseConnector;
import com.shop.wares.Product;
import com.shop.wares.ProductBuilderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by RSzczygielski on 2016-01-28.
 */
@Controller
@RequestMapping("/allProducts")
public class AvailabilityImpl implements Availability {
    @Autowired
    DatabaseConnector databaseConnector;

    @Override
    @RequestMapping(value = "inventory", method = RequestMethod.GET)
    public String getRequestFromAllProductsButton(ModelMap modelMap) {
        String message = "<br><div style='text-align:center;'> All product in warehouse </div><br><br>";


        modelMap.addAttribute("showInventory", message);
        modelMap.addAttribute("products", databaseConnector.readFromDatabase());

        return "allProducts/inventory";
    }

    @Override
    @RequestMapping(value = "inventory", method = RequestMethod.POST, params = "MainView")
    public String getRequestForMainView() {
        return "redirect:/";
    }
}
