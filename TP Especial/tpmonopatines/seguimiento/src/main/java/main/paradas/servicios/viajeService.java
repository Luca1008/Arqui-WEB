package main.paradas.servicios;

import main.paradas.dtos.DtoViaje;
import main.paradas.model.viaje;
import main.paradas.repository.viajeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service("viajeService")
public class viajeService {
    @Autowired
    private viajeRepository viajeRepository;

    @Transactional
    public DtoViaje save(viaje viaje) {
        viaje resultado = viajeRepository.save(viaje);
        return new DtoViaje(resultado.getNro_viaje(), resultado.getFecha_inicio(), resultado.getHora_inicio(), resultado.getFecha_fin(), resultado.getHora_fin(), resultado.getKm_recorridos(), resultado.getPausa(), resultado.getPrecio(), resultado.getMonopatin());
    }

    @Transactional
    public List<DtoViaje> findAll() throws Exception{
        var resultados =  viajeRepository.findAll();
        try {
            return resultados.stream().map(resultado -> new DtoViaje(resultado.getNro_viaje(), resultado.getFecha_inicio(), resultado.getHora_inicio(), resultado.getFecha_fin(), resultado.getHora_fin(), resultado.getKm_recorridos(), resultado.getPausa(), resultado.getPrecio(), resultado.getMonopatin())).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    

    @Transactional
    public DtoViaje findById(Long id) {
        Optional<viaje> res = viajeRepository.findById(id);
        if (res.isPresent()) {
            viaje resultado = res.get();
            return new DtoViaje(resultado.getNro_viaje(), resultado.getFecha_inicio(), resultado.getHora_inicio(), resultado.getFecha_fin(), resultado.getHora_fin(), resultado.getKm_recorridos(), resultado.getPausa(), resultado.getPrecio(), resultado.getMonopatin());
        } else {
            return null;
        }
    }


    @Transactional
    public boolean deleteById(Long id) {
        Optional<viaje> admin = viajeRepository.findById(id);
        if (admin.isPresent()) {
            viajeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public int calcularTotalFacturadoEnRangoDeMeses(int year, int mesInicio, int mesFin) throws Exception {
        try {
            return viajeRepository.calcularTotalFacturadoEnRangoDeMeses(year, mesInicio, mesFin);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
