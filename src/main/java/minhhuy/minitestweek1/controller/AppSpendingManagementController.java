package minhhuy.minitestweek1.controller;

import minhhuy.minitestweek1.moddel.AppSpendingManagement;
import minhhuy.minitestweek1.moddel.AppSpendingManagementForm;
import minhhuy.minitestweek1.service.IAppSpendingManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class AppSpendingManagementController {
    @Value("${file}")
    private String file;
    @Autowired
    private IAppSpendingManagementService appSpendingManagementService;
    @GetMapping("add")
    public ModelAndView showAddForm() {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("appForm",new AppSpendingManagement());
        return modelAndView;
    }
    @PostMapping("add")
    public ModelAndView addApp(@ModelAttribute AppSpendingManagementForm appSpendingManagementForm1){
        System.out.println(appSpendingManagementForm1);
        MultipartFile multipartFile1=appSpendingManagementForm1.getImage();
        String fileName=multipartFile1.getOriginalFilename();
        try{
            FileCopyUtils.copy(appSpendingManagementForm1.getImage().getBytes(),new File(file +fileName));
        }catch (IOException e){
            e.printStackTrace();
        }
        AppSpendingManagement app=new AppSpendingManagement(appSpendingManagementForm1.getId(),appSpendingManagementForm1.getName(),appSpendingManagementForm1.getPrice(),appSpendingManagementForm1.getDescription(),appSpendingManagementForm1.getSpendingList(),fileName);
        appSpendingManagementService.save(app);
        ModelAndView modelAndView=new ModelAndView("add");
        modelAndView.addObject("appForm",appSpendingManagementForm1);
        modelAndView.addObject("message","created new app successfully ^_^");
        return modelAndView;
    }
    @GetMapping("app")
    public ModelAndView listApp(){
        List<AppSpendingManagement> app=appSpendingManagementService.findAll();
        ModelAndView modelAndView=new ModelAndView("list");
        modelAndView.addObject("app",app);
        return modelAndView;
    }
    @GetMapping("edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        AppSpendingManagement app=appSpendingManagementService.findById(id);
        if(app!=null){
            ModelAndView modelAndView=new ModelAndView("edit");
            modelAndView.addObject("appForm",app);
            return modelAndView;
        }else {
            ModelAndView modelAndView=new ModelAndView("error.404");
            return modelAndView;
        }
    }
    @PostMapping("edit")
    public ModelAndView updateApp(@PathVariable("appForm")AppSpendingManagementForm appSpendingManagementForm){
        MultipartFile multipartFile=appSpendingManagementForm.getImage();
        String fileName=multipartFile.getOriginalFilename();
        try{
            FileCopyUtils.copy(appSpendingManagementForm.getImage().getBytes(),new File(file +fileName));
        }catch (IOException e){
            e.printStackTrace();
        }
        AppSpendingManagement app=new AppSpendingManagement(appSpendingManagementForm.getId(),appSpendingManagementForm.getName(),appSpendingManagementForm.getPrice(),appSpendingManagementForm.getDescription(),appSpendingManagementForm.getSpendingList(),fileName);
        appSpendingManagementService.save(app);
        ModelAndView modelAndView=new ModelAndView("edit");
      modelAndView.addObject("appForm",appSpendingManagementForm);
      modelAndView.addObject("message","app update");
      return modelAndView;
    }
    @GetMapping("delete/{id}")
    public ModelAndView deleteApp(@PathVariable Long id){
        AppSpendingManagement app=appSpendingManagementService.findById(id);
        if(app!=null){
            ModelAndView modelAndView=new ModelAndView("delete");
            modelAndView.addObject("appForm",app);
            return modelAndView;
        }else {
            ModelAndView modelAndView=new ModelAndView("error.404");
            return modelAndView;
        }
    }
    @PostMapping("delete")
    public String appDelete(@ModelAttribute("appForm")AppSpendingManagementForm appSpendingManagementForm){
        appSpendingManagementService.remove(appSpendingManagementForm.getId());
        return "redirect:app";
    }
}
