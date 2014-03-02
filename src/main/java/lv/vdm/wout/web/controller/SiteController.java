package lv.vdm.wout.web.controller;

import lv.vdm.wout.web.domain.Workspace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class SiteController {

    private static final Logger LOG = LoggerFactory.getLogger(SiteController.class);

    @Autowired
    private Workspace workspace;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        LOG.info("Show index");
        return "/home";
    }

    @ModelAttribute("workspace")
    public Workspace getWorkspace() {
        return workspace;
    }
}
