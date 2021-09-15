package ar.edu.undec.cardioprotection.defibrillator;

import ar.edu.undec.cardioprotection.response.Response;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DefibrillatorService {

    private final DefibrillatorRepository defibrillatorRepository;

    public Response findAll() {
        Response response = new Response();
        try {
            response.setData(defibrillatorRepository.findAll());
            response.setMessage("Returning all desfibrillators");
            response.setStatus("OK");
        } catch (Exception exception) {
            response.setData("Something went wrong!");
            response.setStatus("ERROR");
        } return response;
    }


    public Response findById(Long id) {
        Response response = new Response();
        try {
            response.setData(defibrillatorRepository.findById(id));
            response.setStatus("OK");
        } catch (Exception exception){
            response.setStatus("ERROR");
            response.setMessage("Something went wrong!");
        } return  response;
    }


    public Response create(Defibrillator defibrillator) {
        Response response = new Response();
        try {
            //if (defibrillatorRepository.exists(defibrillator.getSerialNumber())){
                //response.setMessage("The defibrillator already exists.");
            //} else {
                defibrillatorRepository.save(defibrillator);
                response.setData(defibrillator);
                response.setStatus("OK");
                response.setMessage("Desfibrillator saved.");
            //}
        } catch (Exception exception) {
            response.setStatus("ERROR");
            response.setMessage("Something went wrong!");
        } return response;
    }


    public Response delete(Long id) {
        Response response = new Response();
        try {
            if (defibrillatorRepository.existsById(id)) {
                defibrillatorRepository.deleteById(id);
                response.setStatus("OK");
                response.setMessage("Desfibrillator deleted.");
            } else {
                response.setMessage("The desfibrillator with that id doesn't exists.");
            }

        } catch (Exception exception) {
            response.setStatus("ERROR");
            response.setMessage("Something went wrong!");
        } return response;
    }


    public Response update(Long id, Defibrillator defibrillator){
        Response response = new Response();
        Defibrillator desfibrillatorSave = new Defibrillator();

        try {
            if (defibrillatorRepository.existsById(id)){

                desfibrillatorSave = defibrillator;
                desfibrillatorSave.setId(id);
                defibrillatorRepository.save(desfibrillatorSave);
                response.setData(desfibrillatorSave);
                response.setStatus("OK");
                response.setMessage("Defibrillator updated.");
            }
            else{
                response.setMessage("The id doesn't exists.");
            }

        } catch (Exception exception){
            response.setStatus("ERROR");
            response.setMessage("Something went wrong!");
        } return response;
    }


    public Response changeAvailability(Long id, Boolean availabity) {
        Response response = new Response();
        Defibrillator defibrillatorSave = new Defibrillator();
        try {
            if (defibrillatorRepository.existsById(id)){
                defibrillatorSave = defibrillatorRepository.getById(id);
                defibrillatorSave.setAvailable(availabity);
                defibrillatorRepository.save(defibrillatorSave);
                response.setStatus("OK");
                response.setMessage("Availability of defibrillator changed.");
            }else{
                response.setMessage("The id doesn't exists.");
            }

        } catch (Exception exception){
            response.setStatus("ERROR");
            response.setMessage("Something went wrong!");
        } return response;
    }
}
