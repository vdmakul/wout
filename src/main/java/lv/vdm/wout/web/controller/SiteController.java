package lv.vdm.wout.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SiteController {

    @RequestMapping("/")
    public String index() {
        return "wout";
    }
}
