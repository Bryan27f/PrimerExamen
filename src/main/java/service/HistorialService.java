/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.Historial;
import repository.HistorialRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class HistorialService implements IHidtorialService{
    @Autowired
private HistorialRepository historialRepository;

    @Override
    public List<Historial> getAllHistory() {
         return (List<Historial>)historialRepository.findAll();
    }

    @Override
    public void saveEvent(Historial historial) {
        historialRepository.save(historial);
    }

    @Override
    public void delete(String artista) {
        historialRepository.deleteById(artista);
    }

    
}
