package com.example.demo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;

@RestController
public class TycoonSimController {
  private final TycoonSimRepository TycoonSimRepository;

  public TycoonSimController(TycoonSimRepository TycoonSimRepository) {
    this.TycoonSimRepository = TycoonSimRepository;
  }

  @PostMapping("/saveTycoonSim")
  @CrossOrigin(origins = "*")
  public String saveTycoonSim(@RequestBody TycoonSim TycoonSim) {
    if (TycoonSim == null) {
      return "The TycoonSim is invalid";
    }
    this.TycoonSimRepository.save(TycoonSim);
    return "success";
  }



  @GetMapping("/findAllTycoonSims")
  @ResponseBody
  @CrossOrigin(origins = "*")
  public List<TycoonSim> findAllTycoonSims() {
  	Iterable<TycoonSim> TycoonSims = this.TycoonSimRepository.findAll();
    List<TycoonSim> TycoonSimList = new ArrayList<>();
    TycoonSims.forEach(TycoonSimList::add);
    return TycoonSimList;
  }

  @GetMapping("/findByAuthor")
  @ResponseBody
  @CrossOrigin(origins = "*")
  public List<TycoonSim> findByAuthor(@RequestParam String author) {
    Iterable<TycoonSim> TycoonSims = this.TycoonSimRepository.findByAuthor(author);
    List<TycoonSim> TycoonSimList = new ArrayList<>();
    TycoonSims.forEach(TycoonSimList::add);
    return TycoonSimList;
  }
  @GetMapping("/findByUserId")
  @ResponseBody
  @CrossOrigin(origins = "*")
  public List<TycoonSim> findByUserId(@RequestParam String userId) {
    Iterable<TycoonSim> TycoonSims = this.TycoonSimRepository.findByUserId(userId);
    List<TycoonSim> TycoonSimList = new ArrayList<>();
    TycoonSims.forEach(TycoonSimList::add);
    return TycoonSimList;
  }
}