package com.example.homeworkres2.service.serviceMpl;

import com.example.homeworkres2.apiResponse.VenuesRespone;
import com.example.homeworkres2.exception.NotFoundExceptionHandler;
import com.example.homeworkres2.model.Venuse;
import com.example.homeworkres2.repository.VenuseRepository;
import com.example.homeworkres2.request.VenuesRequest;
import com.example.homeworkres2.service.VenuesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VenuseServiceImp implements VenuesService  {
    private final VenuseRepository venuseRepository;
    @Override
    public List<Venuse> getAllVenuse(int size, int page) {
        if(size <0 || page <0){
            throw new NotFoundExceptionHandler("Invalid number ! please make sure your size of page number need to be greater than 0 ");
        }
        return venuseRepository.getAllVenuse(size, page);
    }

    @Override
    public Venuse getById(int id) {
        Venuse venuseId = venuseRepository.getById(id);
        if(venuseId == null){
            throw new NotFoundExceptionHandler("user with this Id " + id + " not found");
        } else if (id < 0) {
            throw new NotFoundExceptionHandler("Id can't be negative number ");
        }
        return venuseRepository.getById(id);
    }

    @Override
    public Venuse updateVenues(VenuesRequest request, int id) {
        Venuse venuseId = venuseRepository.getById(id);
        if(venuseId == null){
            throw new NotFoundExceptionHandler("Can't update with this ID: " + id + " , ID not found");
        }
        else if (id < 0) {
            throw new NotFoundExceptionHandler("Id can't be negative number ");
        }
        return venuseRepository.updateVenu(request, id);
    }

    @Override
    public Venuse createVenues(VenuesRequest request) {


        return venuseRepository.createVenu(request);
    }

    @Override
    public void deleteVenues(int id) {
        Venuse venuseId = venuseRepository.getById(id);
        if(venuseId == null){
            throw new NotFoundExceptionHandler("Can't Delete with this ID: " + id + " , ID not found");
        }
        else if (id < 0) {
            throw new NotFoundExceptionHandler("Id can't be negative number ");
        }
        venuseRepository.deleteVenue(id);
    }
}
