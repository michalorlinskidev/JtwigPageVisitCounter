package tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageVisitCounterController {

    private final PageVisitCounterService service;

    @Autowired
    private PageVisitCounterController(PageVisitCounterService service) {
        this.service = service;
    }

    @GetMapping
    public String index(ModelMap model) {

        model.addAttribute("pageVisitCounter", service.count());

        return "index";
    }

}
