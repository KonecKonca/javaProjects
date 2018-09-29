package de.springboot.web;

import de.springboot.model.StackoverflowWebsite;
import de.springboot.service.StackoverflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  // све методы отмесены responseBody
@Controller
public class StackOverFlowController {

    @Autowired
    private StackoverflowService stackoverflowService;

    @RequestMapping("/api/stackoverflow")
    public List<StackoverflowWebsite> getListOfProviders(){
        // ТУТ возвращаем не вьюху, а json(он по умолчанию) объект  @ResponseBody(для jsona)
        return stackoverflowService.findAll();
    }
}
