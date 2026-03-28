package com.example.homeworkres2.service;

import com.example.homeworkres2.model.Venuse;
import com.example.homeworkres2.request.VenuesRequest;

import java.util.List;


public interface VenuesService {

    public List<Venuse> getAllVenuse(int size, int page);
    public Venuse getById(int id);
    public Venuse updateVenues(VenuesRequest request, int id);
    public Venuse createVenues (VenuesRequest request);
    public void deleteVenues(int id);

}
