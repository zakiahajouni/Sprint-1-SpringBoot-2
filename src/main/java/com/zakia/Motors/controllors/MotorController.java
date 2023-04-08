package com.zakia.Motors.controllors;

import com.zakia.Motors.entities.Motor;
import com.zakia.Motors.service.MotorService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MotorController {
    @Autowired
    MotorService motorService;
    @RequestMapping("/showCreate")
    public String showCreate()
    {
        return "createMotor";
    }
    @RequestMapping("/saveMotor")
    public String saveMotor(@ModelAttribute("motor") Motor motor,
                              @RequestParam("date") String date,
                              ModelMap modelMap) throws
            ParseException
    {
//conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        motor.setDateCreation(dateCreation);

        Motor saveMotor = motorService.saveMotor(motor);
        String msg ="Motor Added Successfully"+saveMotor.getIdMotor();
        modelMap.addAttribute("msg", msg);
        return "createMotor";
    }
    @RequestMapping("/ListeMotors")
    public String listeMotors(ModelMap modelMap,
                                @RequestParam (name="page",defaultValue = "0") int page,
                                @RequestParam (name="size", defaultValue = "2") int size)
    {
        Page<Motor> motos = motorService.getAllMotorsParPage(page, size);
        modelMap.addAttribute("motors", motos);
        modelMap.addAttribute("pages", new int[motos.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listeMotors";
    }


    @RequestMapping("/supprimerMotor")
    public String supprimerMotor(@RequestParam("id") Long id,
                                   ModelMap modelMap,
                                   @RequestParam (name="page",defaultValue = "0") int page,
                                   @RequestParam (name="size", defaultValue = "2") int size)
    {
        motorService.deleteMotorById(id);
        Page<Motor> motos = motorService.getAllMotorsParPage(page,
                size);
        modelMap.addAttribute("motors", motos);
        modelMap.addAttribute("pages", new int[motos.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeMotors";
    }



    @RequestMapping("/modifierMotor")
    public String editerMotor(@RequestParam("id") Long id,ModelMap modelMap)
    {
        Motor m= motorService.getMotor(id);
        modelMap.addAttribute("motor", m);
        return "editerMotor";
    }
    @RequestMapping("/updateMotor")
    public String updateMotor(@ModelAttribute("motor") Motor motor, @RequestParam("date") String date, ModelMap modelMap) throws ParseException {
        //conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        motor.setDateCreation(dateCreation);

        motorService.updateMotor(motor);
        return "redirect:/ListeMotors";
    }




}