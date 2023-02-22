package sg.edu.nus.iss.day16workshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.day16workshop.models.Payload;
import sg.edu.nus.iss.day16workshop.repositories.PayloadRepo;

@RestController
@RequestMapping(path="/api/payload")
public class PayloadController {
    @Autowired
    PayloadRepo payloadRepo;

    @PostMapping
    public ResponseEntity<Payload> save(@RequestBody Payload payload){
        Payload pload = payloadRepo.save(payload);
        return new ResponseEntity<Payload>(pload, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Payload>>findAll(){
        List<Payload> payloads = payloadRepo.findAll();
        return new ResponseEntity<List<Payload>>(payloads, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payload> findById(@PathVariable Integer Id){
        Payload pLoad = payloadRepo.findPayloadById(Id);
        return new ResponseEntity<Payload>(pLoad,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer Id){
        String result = payloadRepo.deletePayloadById(Id);
        return new ResponseEntity<String>(result,HttpStatus.OK);
    }
}
