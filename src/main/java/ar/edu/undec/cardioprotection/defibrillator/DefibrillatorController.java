package ar.edu.undec.cardioprotection.defibrillator;


import ar.edu.undec.cardioprotection.response.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@RestController
@RequestMapping ("/defibrillators")
public class DefibrillatorController {

    private final DefibrillatorService defibrillatorService;

    @RequestMapping("/")
    public ResponseEntity<Response> list(){
        Response response = new Response();
        response.setStatus("OK");
        response.setMessage("OK");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /// Return all the defibrillators in the Database
    @GetMapping("/findall")
    public ResponseEntity<Response> findAll(){
        Response response = defibrillatorService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /// Search a defibrillator in the Database by its Id and return the data
    @GetMapping("/{id}")
    public ResponseEntity<Response> findOne(@PathVariable (value = "id") Long id){
        Response response = defibrillatorService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /// Create a new defibrillator in the Database
    @PostMapping("/create")
    public ResponseEntity<Response> create(@RequestBody Defibrillator defibrillator){
        Response response = defibrillatorService.create(defibrillator);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /// Delete a defibrillator
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> delete(@PathVariable(value = "id") Long id){
        Response response = defibrillatorService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /// Update the defibrillator's data
    @PatchMapping("/update/{id}")
    public ResponseEntity<Response> update(@PathVariable(value = "id") Long id, @RequestBody Defibrillator defibrillator){
        Response response = defibrillatorService.update(id, defibrillator);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /// Change the defibrillator's availability for public use
    @PutMapping("/changeavailability")
    public ResponseEntity<Response> changeAvailability(@RequestParam Long id, Boolean availability ){
        Response response = defibrillatorService.changeAvailability(id, availability);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
