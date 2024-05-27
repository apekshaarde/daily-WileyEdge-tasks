package com.trainees.app.controller;
import com.oracle.wls.shaded.org.apache.xpath.operations.Mod;
import com.trainees.app.dto.TraineeDto;
import com.trainees.app.service.TraineesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class TraineeController {

    @Autowired
    private TraineesService traineesService;

    @GetMapping("/navBar")
    public String welcome(){
        return "navBar";
    }

    @GetMapping("/register")
    public String registerTrainee(){
        return "registerTrainee";
    }

    @PostMapping("/save")
    public String saveTrainees(Model model,TraineeDto traineeDto){
        System.out.println("----------->Controller-->"+traineeDto);
       TraineeDto dto = traineesService.saveTrainee(traineeDto);
        System.out.println(dto);
        System.out.println("Hello");
        if(dto!=null){
            model.addAttribute("traineeInfo",dto);
            model.addAttribute("msg","trainee registered successfully");
        }else{
            model.addAttribute("msg","something problem is there");
        }
       return "registerTrainee";
    }

    @GetMapping("/view-all")
    public String getAllTrainees(Model model){
        List<TraineeDto> trainees = traineesService.getAllTrainees();
        model.addAttribute("trainees",trainees);
        if(trainees!=null){
            trainees.forEach(v-> System.out.println(v));
        }
        return "viewAll";
    }

    @GetMapping(value="/editTrainee/{id}")
    public String edit(@PathVariable("id") Integer id, Model m){
        System.out.println(id);
        TraineeDto traineeDto=traineesService.getTrainee(id);
        System.out.println(traineeDto);
        m.addAttribute("trainee",traineeDto);
        return "updateTrainee";
    }
    @PostMapping(value="/update")
    public String update(@ModelAttribute TraineeDto traineeDto) {
        traineesService.updateTrainee(traineeDto);
        return "redirect:/view-all";
    }

    @GetMapping("/delete-trainee")
    public String deleteTrainee(@RequestParam("id") Integer id){
        traineesService.deleteTrainee(id);
        return "redirect:/view-all";
    }

    @GetMapping(value = "/searchTrainee")
    @ResponseBody
    public String searchTrainee(@RequestParam("txt") String txt){
        List<TraineeDto> traineeName = traineesService.searchTraineeByName(txt);
        String table = "<table class='table'>";
        if(traineeName!=null){
            table = table+"<thead><tr><th>Name</th><th>Email</th><th>Location</th><th>Actions</th><th>Actions</th></tr></thead>";
            for (TraineeDto dto : traineeName){
                table = table+"<tbody><tr><td>"+dto.name()+"</td><td>"+dto.email()+"</td><td>"+dto.location()+"</td><td><a href='' class='btn btn-danger'>Delete</td><td><a href='' class='btn btn-primary'>Update</td></tr></tbody>";
            }
            table = table+"</table>";
        }
        return table;
    }

    //@GetMapping("/{id}")
//    public TraineeDto getTrainee(@PathVariable int id){
//        return traineesService.getTrainee(id);
//    }
//
//    @PostMapping
//    public TraineeDto saveTrainee(@RequestBody TraineeDto traineeDto){
//        return traineesService.saveTrainee(traineeDto);
//    }
//
//    @GetMapping
//    public List<TraineeDto> getAllTrainees(){
//        return traineesService.getAllTrainees();
//    }


//    @PostMapping("/updateTrainee/{id}")
//    public String update(Model model,TraineeDto traineeDto){
//        TraineeDto dto = traineesService.updateTrainee(traineeDto);
//        if(dto!=null){
//            model.addAttribute("updateTrainees",dto);
//            model.addAttribute("msg","trainee updated successfully");
//        }else{
//            model.addAttribute("msg","something problem is there");
//        }
//        return "updateTrainee";
//    }

//    @RequestMapping(value = "/updateTrainee/{id}",method =RequestMethod.POST)
//    public String update(@PathVariable Integer id, Model model,@ModelAttribute TraineeDto traineeDto){
//        TraineeDto updatedTraineeDto = new TraineeDto(id, traineeDto.name(), traineeDto.email(), traineeDto.location());
//        System.out.println(updatedTraineeDto);
//        TraineeDto dto = traineesService.updateTrainee(traineeDto);
//        if(dto!=null){
//            model.addAttribute("updateTrainees",dto);
//            model.addAttribute("msg","trainee updated successfully");
//        }else{
//            model.addAttribute("msg","something problem is there");
//        }
//        return "updateTrainee";
//    }

//    @PostMapping("/finalUpdateTrainee")
//    public String updateTrainees(@RequestParam("id") Integer id,
//                                @RequestParam("name") String name,
//                                @RequestParam("email") String email,
//                                @RequestParam("location") String location,Model model){
//        model.addAttribute("id",id);
//        model.addAttribute("name",name);
//        model.addAttribute("email",email);
//        model.addAttribute("location",location);
//
//        return "viewAll";
//    }
}
