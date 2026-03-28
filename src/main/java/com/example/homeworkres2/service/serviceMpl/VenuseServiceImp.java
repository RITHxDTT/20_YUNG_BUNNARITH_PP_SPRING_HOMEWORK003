package com.example.homeworkres2.service.serviceMpl;

import com.example.homeworkres2.model.Venuse;
import com.example.homeworkres2.repository.VenuseRepository;
import com.example.homeworkres2.request.VenuesRequest;
import com.example.homeworkres2.service.VenuesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VenuseServiceImp implements VenuesService {
    private final VenuseRepository venuseRepository;
    @Override
    public List<Venuse> getAllVenuse(int size, int page) {
        return venuseRepository.getAllVenuse(size, page);
    }

    @Override
    public Venuse getById(int id) {
        return venuseRepository.getById(id);
    }

    @Override
    public Venuse updateVenues(VenuesRequest request, int id) {
        return venuseRepository.updateVenu(request, id);
    }

    @Override
    public Venuse createVenues(VenuesRequest request) {
        return venuseRepository.createVenu(request);
    }

    @Override
    public void deleteVenues(int id) {
        venuseRepository.deleteVenue(id);
    }
}
